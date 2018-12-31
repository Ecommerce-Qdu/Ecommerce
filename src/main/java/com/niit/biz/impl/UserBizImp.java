package com.niit.biz.impl;

import com.niit.biz.IUserBiz;
import com.niit.dao.*;
import com.niit.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBizImp implements IUserBiz {

    @Autowired
    private UsersMapper usersDao;
    @Autowired
    private UsersInfoMapper usersInfoDao;
    @Autowired
    private UsersAddressMapper usersAddressDao;
    @Autowired
    private OrdersMapper OrderDao;
    @Autowired
    private ProjectMapper projectDao;
    @Autowired
    private ProjectCommentMapper projectCommentDao;

    //注册业务
    @Override
    public String RegisterUser(Users u) {

        //根据手机号查询用户
        Users user = usersDao.findByPhone(u.getUphone());

        //判断用户是否存在
        boolean PhoneExistFlag = true;
        try {
            if (null == user) {
                PhoneExistFlag = false;
            }
            if (user.getUphone().equals(u.getUphone())) {
                PhoneExistFlag = true;
            } else {
                PhoneExistFlag = false;
            }
        } catch (Exception e) {
            PhoneExistFlag = false;
        }

        if (PhoneExistFlag) {
            System.out.println("biz:手机号已存在!");
            return "UserExisted";
        } else {
            System.out.println("biz:手机号不存在");

            if (u.getUtype() == 1) {
                System.out.println("insert user:" + u.toString());
                if (usersDao.insert(u) == 1) {
                    System.out.println("biz:注册成功");
                    return "ok";
                } else {
                    System.out.println("biz:注册失败");
                    return "error";
                }
            } else {
                System.out.println("biz:用户类型为2");
                return "Type2";
            }
        }

        //测试数据
//        return "ok";
    }

    @Override
    public String RegisterUser(Users user, UsersInfo userinfo) {
        if (usersInfoDao.save(user, userinfo)) {
            System.out.println("biz:注册成功");
            return "ok";
        } else {
            System.out.println("biz:注册失败");
            return "error";
        }
    }

    @Override
    public List<UsersAddress> findAllAddress(String Phone) {
        return usersAddressDao.findAllAddress(Phone);
    }


    @Override
    public boolean saveAddress(UsersAddress addr) {
        return usersAddressDao.save(addr);
    }

    @Override
    public boolean changepwd(String s, String newpwd) {
        return usersDao.changepwd(s, newpwd);
    }

    @Override
    public boolean update(Users user,String uphone) {

        System.out.println("change info : "+uphone+"\n new is:"+user.toString());
        return usersDao.update(user,uphone);
    }

    @Override
    public boolean updateinfo(String uphone,UsersInfo usersInfo) {
        return usersInfoDao.updateinfo(uphone,usersInfo);
    }

    @Override
    public List<Orders> findAllOrder(String s) {
        return OrderDao.findAllOrder(s);
    }

    @Override
    public List<Project> findAllUserProject(String s) {
        return projectDao.findAllUserProject(s);
    }

    @Override
    public List<ProjectComment> findAllUserProjectComment(String s) {
        return projectCommentDao.findAllUserProjectComment(s);
    }

    @Override
    public List<Orders> findOrderByPid(int pid) {
        return OrderDao.findOrderByPid(pid);
    }

    @Override
    public boolean deleteAddress(int aid) {
        return usersAddressDao.delete(aid);
    }

    @Override
    public Users findUserByPhone(String phone) {
        Users user = usersDao.findByPhone(phone);

        //在修改手机号后未注销的情况下重启浏览器传入的phone为旧手机号
        try{
            System.out.println("user = " + user.toString());
        }catch(Exception e){
            Users u = new Users();
            u.setUflag(new Integer(-1));
            return u;
        }
        return user;
    }


}