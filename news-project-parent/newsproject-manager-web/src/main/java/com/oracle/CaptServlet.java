package com.oracle;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CaptServlet")
public class CaptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");//jpg图片
		

		response.setHeader("pragma", "no-cache");

		response.setHeader("cache-control", "no-cache");

		response.setHeader("expires", "0");


		int length = 4;

		String valcode = "";

		Random rd = new Random();//创建一个随机数

		for (int i = 0; i < length; i++)

			valcode += rd.nextInt(10);

		// 在这个Servlet中  创建一个图片 (随机的 验证码  )  -> 响应到 前端页面中  
		
		//用户根据图片中的数字进行手动输入  -> 提交  (用户输入的验证  码)
		//当做  请求参数  发送到登录或注册中  (过滤器  )  获取当前请求的会话   
		HttpSession session = request.getSession();//获取session

		session.setAttribute("valcode", valcode);//创建 - jsp   jsp(输入)   request作用域  当验证验证码 时  后台是否能获取
			//用户通过图片识别验证码 输入 

		int width = 80;

		int height = 25;

		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);


		Graphics g = img.getGraphics();


		g.setColor(Color.WHITE);

		g.fillRect(0, 0, width, height);


		for (int i = 0; i < 50; i++) {

			g.setColor(new Color(rd.nextInt(100) + 155, rd.nextInt(100) + 155,
					rd.nextInt(100) + 155));

			g.drawLine(rd.nextInt(width), rd.nextInt(height),
					rd.nextInt(width), rd.nextInt(height));

		}


		g.setColor(Color.GRAY);

		g.drawRect(0, 0, width - 1, height - 1);


		Font[] fonts = { new Font("宋体", Font.BOLD, 18),
				new Font("宋体", Font.BOLD, 18), new Font("楷体", Font.BOLD, 18),
				new Font("楷体", Font.BOLD, 18) };

		for (int i = 0; i < length; i++) {

			g.setColor(new Color(rd.nextInt(150), rd.nextInt(150), rd
					.nextInt(150)));

			g.setFont(fonts[rd.nextInt(fonts.length)]);

			g.drawString(valcode.charAt(i) + "", width / valcode.length() * i
					+ 2, 18);

		}

		g.dispose();
		
		ImageIO.write(img, "jpeg", response.getOutputStream());
	}

}
