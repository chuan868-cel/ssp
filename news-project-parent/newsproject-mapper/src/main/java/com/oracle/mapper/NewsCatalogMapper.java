package com.oracle.mapper;

import com.oracle.pojo.NewsCatalog;
import com.oracle.pojo.NewsCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsCatalogMapper {
    int countByExample(NewsCatalogExample example);

    int deleteByExample(NewsCatalogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewsCatalog record);

    int insertSelective(NewsCatalog record);

    List<NewsCatalog> selectByExampleWithBLOBs(NewsCatalogExample example);

    List<NewsCatalog> selectByExample(NewsCatalogExample example);

    NewsCatalog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewsCatalog record, @Param("example") NewsCatalogExample example);

    int updateByExampleWithBLOBs(@Param("record") NewsCatalog record, @Param("example") NewsCatalogExample example);

    int updateByExample(@Param("record") NewsCatalog record, @Param("example") NewsCatalogExample example);

    int updateByPrimaryKeySelective(NewsCatalog record);

    int updateByPrimaryKeyWithBLOBs(NewsCatalog record);

    int updateByPrimaryKey(NewsCatalog record);
}