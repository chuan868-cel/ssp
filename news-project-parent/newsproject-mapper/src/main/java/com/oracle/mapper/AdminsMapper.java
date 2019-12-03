package com.oracle.mapper;

import com.oracle.pojo.Admins;
import com.oracle.pojo.AdminsExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminsMapper {
    int countByExample(AdminsExample example);

    int deleteByExample(AdminsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admins record);

    int insertSelective(Admins record);

    List<Admins> selectByExample(AdminsExample example);

    Admins selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admins record, @Param("example") AdminsExample example);

    int updateByExample(@Param("record") Admins record, @Param("example") AdminsExample example);

    int updateByPrimaryKeySelective(Admins record);

    int updateByPrimaryKey(Admins record);

    @Select("select * from admins where loginname = #{loginname}")
    Admins selectAdminByName(String loginname);

    @Select("select P.url " +
            "  from permission P " +
            " left join roles_pers rp on P.id = rp.pers " +
            " left join roles_admins ra on ra.roles = rp.roles " +
            " where ra.admins = #{id}")
    List<String> selectUrlById(Integer id);

    List<Admins> selectContainRole();

    List<Admins> selectContainRoleById(Integer id);

    @Delete("delete from roles_admins where admins=#{id}")
    void deleteRoleByAdminId(Integer id);

    @Insert("insert into roles_admins values(#{0},#{1})")
    void addRoleByAdminId(Integer roleId, Integer adminId);

}