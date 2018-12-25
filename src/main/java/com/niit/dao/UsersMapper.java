package com.niit.dao;

import com.niit.entity.Users;
import com.niit.entity.UsersInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(String uphone);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String uphone);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    boolean changepwd(String s, String newpwd);

    boolean update(Users user);

    boolean updateinfo(UsersInfo usersInfo);

    Users findByPhone(String phone);
}