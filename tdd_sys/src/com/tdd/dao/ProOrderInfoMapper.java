package com.tdd.dao;

import com.tdd.model.ProOrderInfo;
import com.tdd.model.ProOrderInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProOrderInfoMapper {
    long countByExample(ProOrderInfoExample example);

    int deleteByExample(ProOrderInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProOrderInfo record);

    int insertSelective(ProOrderInfo record);

    List<ProOrderInfo> selectByExample(ProOrderInfoExample example);

    ProOrderInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    ProOrderInfo record, @Param("example")
    ProOrderInfoExample example);

    int updateByExample(@Param("record")
    ProOrderInfo record, @Param("example")
    ProOrderInfoExample example);

    int updateByPrimaryKeySelective(ProOrderInfo record);

    int updateByPrimaryKey(ProOrderInfo record);
}

