package com.tdd.dao;

import com.tdd.model.TzInfo;
import com.tdd.model.TzInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TzInfoMapper {
    long countByExample(TzInfoExample example);

    int deleteByExample(TzInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TzInfo record);

    int insertSelective(TzInfo record);

    List<TzInfo> selectByExample(TzInfoExample example);

    TzInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    TzInfo record, @Param("example")
    TzInfoExample example);

    int updateByExample(@Param("record")
    TzInfo record, @Param("example")
    TzInfoExample example);

    int updateByPrimaryKeySelective(TzInfo record);

    int updateByPrimaryKey(TzInfo record);
}

