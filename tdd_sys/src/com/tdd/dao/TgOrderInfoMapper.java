package com.tdd.dao;

import com.tdd.model.TgOrderInfo;
import com.tdd.model.TgOrderInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TgOrderInfoMapper {
    long countByExample(TgOrderInfoExample example);

    int deleteByExample(TgOrderInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TgOrderInfo record);

    int insertSelective(TgOrderInfo record);

    List<TgOrderInfo> selectByExample(TgOrderInfoExample example);

    TgOrderInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    TgOrderInfo record, @Param("example")
    TgOrderInfoExample example);

    int updateByExample(@Param("record")
    TgOrderInfo record, @Param("example")
    TgOrderInfoExample example);

    int updateByPrimaryKeySelective(TgOrderInfo record);

    int updateByPrimaryKey(TgOrderInfo record);
}

