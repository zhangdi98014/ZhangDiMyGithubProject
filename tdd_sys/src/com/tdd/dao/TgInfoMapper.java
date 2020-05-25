package com.tdd.dao;

import com.tdd.model.TgInfo;
import com.tdd.model.TgInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TgInfoMapper {
    long countByExample(TgInfoExample example);

    int deleteByExample(TgInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TgInfo record);

    int insertSelective(TgInfo record);

    List<TgInfo> selectByExample(TgInfoExample example);

    TgInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    TgInfo record, @Param("example")
    TgInfoExample example);

    int updateByExample(@Param("record")
    TgInfo record, @Param("example")
    TgInfoExample example);

    int updateByPrimaryKeySelective(TgInfo record);

    int updateByPrimaryKey(TgInfo record);
}

