package com.niit.dao;

import com.niit.entity.UsersAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersAddressMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(UsersAddress record);

    int insertSelective(UsersAddress record);

    UsersAddress selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(UsersAddress record);

    int updateByPrimaryKey(UsersAddress record);

    List<UsersAddress> findAllAddress(String phone);

    boolean save(UsersAddress addr);

    boolean delete(int aid);
}