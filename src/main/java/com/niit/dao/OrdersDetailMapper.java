package com.niit.dao;

import com.niit.entity.OrdersDetail;
import com.niit.entity.OrdersDetailKey;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetailMapper {
    int deleteByPrimaryKey(OrdersDetailKey key);

    int insert(OrdersDetail record);

    int insertSelective(OrdersDetail record);

    OrdersDetail selectByPrimaryKey(OrdersDetailKey key);

    int updateByPrimaryKeySelective(OrdersDetail record);

    int updateByPrimaryKey(OrdersDetail record);
}