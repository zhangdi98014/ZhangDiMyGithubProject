package com.tdd.dao;

import com.tdd.model.ProTypeInfo;
import com.tdd.model.ProTypeInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProTypeInfoMapper {
    long countByExample(ProTypeInfoExample example);

    int deleteByExample(ProTypeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProTypeInfo record);

    int insertSelective(ProTypeInfo record);

    List<ProTypeInfo> selectByExample(ProTypeInfoExample example);

    ProTypeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    ProTypeInfo record, @Param("example")
    ProTypeInfoExample example);

    int updateByExample(@Param("record")
    ProTypeInfo record, @Param("example")
    ProTypeInfoExample example);

    int updateByPrimaryKeySelective(ProTypeInfo record);

    int updateByPrimaryKey(ProTypeInfo record);
}

