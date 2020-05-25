package com.tdd.dao;

import com.tdd.model.ProInfo;
import com.tdd.model.ProInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProInfoMapper {
    long countByExample(ProInfoExample example);

    int deleteByExample(ProInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProInfo record);

    int insertSelective(ProInfo record);

    List<ProInfo> selectByExample(ProInfoExample example);

    ProInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    ProInfo record, @Param("example")
    ProInfoExample example);

    int updateByExample(@Param("record")
    ProInfo record, @Param("example")
    ProInfoExample example);

    int updateByPrimaryKeySelective(ProInfo record);

    int updateByPrimaryKey(ProInfo record);
}

