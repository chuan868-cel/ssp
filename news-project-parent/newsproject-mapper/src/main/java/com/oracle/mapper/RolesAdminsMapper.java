package com.oracle.mapper;

import com.oracle.pojo.RolesAdminsExample;
import com.oracle.pojo.RolesAdminsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesAdminsMapper {
    int countByExample(RolesAdminsExample example);

    int deleteByExample(RolesAdminsExample example);

    int deleteByPrimaryKey(RolesAdminsKey key);

    int insert(RolesAdminsKey record);

    int insertSelective(RolesAdminsKey record);

    List<RolesAdminsKey> selectByExample(RolesAdminsExample example);

    int updateByExampleSelective(@Param("record") RolesAdminsKey record, @Param("example") RolesAdminsExample example);

    int updateByExample(@Param("record") RolesAdminsKey record, @Param("example") RolesAdminsExample example);
}