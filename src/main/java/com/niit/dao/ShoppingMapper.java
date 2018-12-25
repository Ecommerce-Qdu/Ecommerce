package com.niit.dao;

import com.niit.entity.Shopping;
import com.niit.entity.ShoppingKey;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingMapper {
    int deleteByPrimaryKey(ShoppingKey key);

    int insert(Shopping record);

    int insertSelective(Shopping record);

    Shopping selectByPrimaryKey(ShoppingKey key);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKey(Shopping record);
}