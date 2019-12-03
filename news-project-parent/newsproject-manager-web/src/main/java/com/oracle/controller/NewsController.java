package com.oracle.controller;

import com.oracle.data.ServiceEntity;
import com.oracle.news.service.api.NewsCatalogService;
import com.oracle.news.service.api.NewsService;
import com.oracle.pojo.Admins;
import com.oracle.pojo.News;
import com.oracle.pojo.NewsCatalog;
import com.oracle.pojo.Roles;
import com.oracle.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.annotation.MultipartConfig;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/news")
public class NewsController{

    @Value("${upload_server_host}")
    private String UPLOAD_PATH;

    @Autowired(required = false)
    private NewsService newsService;

    @Autowired
    private NewsCatalogService newsCatalogService;

    @RequestMapping("/list")
    public String list(Model model){
        ServiceEntity<News> serviceEntity=this.newsService.list();
        model.addAttribute("newsList",serviceEntity.getListData());
        return "/admin/news/list";
    }

    @RequestMapping("/detail")
    public String list(Model model,Integer id){
        ServiceEntity<NewsCatalog> serviceEntity=this.newsCatalogService.list();
        ServiceEntity<News> serviceEntity2=this.newsService.selectNewsById(id);
        model.addAttribute("newsCataList",serviceEntity.getListData());
        model.addAttribute("news",serviceEntity2.getEntity());
        return "/admin/news/detail";
    }

    @RequestMapping("/edit")
    public String edit(Model model,Integer id){
        ServiceEntity<NewsCatalog> serviceEntity=this.newsCatalogService.list();
        model.addAttribute("newsCataList",serviceEntity.getListData());
        if(id!=null){
            ServiceEntity<News> serviceEntity2=this.newsService.selectNewsById(id);
            model.addAttribute("news",serviceEntity2.getEntity());
        }
        return "/admin/news/edit";
    }

    @RequestMapping("/saveOrUpdate")
    public String newsSave(News news,RedirectAttributes redirectAttributes){
        ServiceEntity<News> serviceEntity;
        if(news.getId()==null){
            serviceEntity = this.newsService.add(news);
            redirectAttributes.addAttribute("editMessage",serviceEntity.getMsg());
        }else{
            serviceEntity = this.newsService.UpdateNewsByCatalog(news);
            redirectAttributes.addAttribute("editMessage",serviceEntity.getMsg());
        }
        if (serviceEntity.getCode()==0){
            redirectAttributes.addAttribute("editMessage","操作成功");
        }else{
            redirectAttributes.addAttribute("editMessage","操作失败");
        }
        return "redirect:list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String edit(Integer id){
        ServiceEntity<News> serviceEntity = this.newsService.deleteRoleById(id);
        if(serviceEntity.getCode()==0){
            return "200";
        }
        return "400";
    }

    /**
     *  originalFilename:获取文件名
     *  extName ： 获取文件扩展名
     *  map.put("url",url);map.put("error",0); 这是富文本编辑器默认的返回值
     *  uploadFile(imgFile.getBytes(),extName); imgFile 参数必须是文件全路径
     * @Title: upload
     * @param [imgFile]
     * @return java.util.Map
     * @author: Flame
     * @since: 2019/7/23 10:58
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Map upload(@RequestParam MultipartFile imgFile){
        String  originalFilename= imgFile.getOriginalFilename();
        String  extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        Map<String,Object> map = new HashMap<>();
        try {
            FastDFSClient client = new FastDFSClient("classpath:conf/fdfs_client.conf");
            String filedId = client.uploadFile(imgFile.getBytes(),extName);
            // filedId 组名 + 路径 + 随机ID名
            String url = UPLOAD_PATH + filedId;
            map.put("url",url);
            map.put("error",0);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
