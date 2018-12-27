package com.niit.dao;

import com.niit.entity.Users;
import com.niit.entity.UsersInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersInfoMapper {


    int deleteByPrimaryKey(String uphone);

    int insert(UsersInfo record);

    int insertSelective(UsersInfo record);

    UsersInfo selectByPrimaryKey(String uphone);

    int updateByPrimaryKeySelective(UsersInfo record);

    int updateByPrimaryKey(UsersInfo record);

    boolean save(Users user, UsersInfo userinfo);
    boolean updateinfo(String phone,UsersInfo usersInfo);

}