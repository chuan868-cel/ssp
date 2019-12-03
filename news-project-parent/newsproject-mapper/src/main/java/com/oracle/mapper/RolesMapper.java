package com.oracle.mapper;

import com.oracle.pojo.Permission;
import com.oracle.pojo.Roles;
import com.oracle.pojo.RolesExample;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RolesMapper {
    int countByExample(RolesExample example);

    int deleteByExample(RolesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Roles record);

    int insertSelective(Roles record);

    List<Roles> selectByExample(RolesExample example);

    Roles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByExample(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);

    @Select("select P.id" +
            " from roles r" +
            " left join roles_pers rp on rp.roles = r.id" +
            " left join permission P on P.id = rp.pers" +
            " where r.id = #{id}")
    List<Permission> selectRoleInPer(Integer id);


    void deleteRoleInPer(@Param("roleId") Integer roleId);

    @Insert("insert into roles_pers values(#{roleId},#{perId})")
    void addPermissionByRoleId(@Param("roleId") Integer roleId, @Param("perId") Integer perId);
}