package com.niit.controller;

import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
import com.niit.entity.UsersInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegisterController {

    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "Register.mvc", method = RequestMethod.POST)
    public String Register(HttpServletRequest req, ModelMap map, String UName,
                           String newpassword, String phone, String sms, String UType) {
        System.out.println("\n++++++++++++++++++++++++++");
        System.out.println("Register");
        System.out.println("UName = " + UName);
        System.out.println("newpassword = " + newpassword);
        System.out.println("phone = " + phone);
        System.out.println("sms = " + sms);
        System.out.println("UType = " + UType);
        System.out.println("++++++++++++++++++++++++++");

        Users user = new Users();
        user.setUphone(phone + "");
        user.setUname(UName);
        user.setUtype(Integer.parseInt(UType));
        user.setUpwd(DigestUtils.md5Hex(newpassword));
        user.setUflag(1);

        //临时保存用户信息
        req.getSession().setAttribute("registeruser", user);

        if ((Integer.parseInt(sms)) != (int) (req.getSession().getAttribute("code"))) {
            System.out.println("验证码错误:" + (Integer.valueOf(sms) + "|" + (req.getSession().getAttribute("code"))));
            map.addAttribute("msg", "验证码错误");
            map.addAttribute("msgtype", "register");
            return "lrf.jsp";
        }

        //尝试保存用户到数据库
        String result = userBiz.RegisterUser(user);

        if (result == "UserExisted") {
            System.out.println("手机号已经存在");
            map.addAttribute("msg", "手机号已经存在");
            map.addAttribute("msgtype", "register");
            return "lrf.jsp";
        } else if (result == "ok") {
            System.out.println("注册成功");
            map.addAttribute("msg", "注册成功");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        } else if (result == "error") {
            map.addAttribute("msg", "注册失败");
            map.addAttribute("msgtype", "register");
            return "lrf.jsp";
        } else if (result == "Type2") {
            System.out.println("con:Type2");
            //注册类型为融资者,需要进一步填写信息
            return "userinfo.jsp";
        } else {
            map.addAttribute("msg", "注册失败");
            map.addAttribute("msgtype", "register");
            return "lrf.jsp";
        }


    }

    @RequestMapping(value = "RegisterType2.mvc", method = RequestMethod.POST)
    public String Register(HttpServletRequest req, ModelMap map, String UName, String UZipCode, String UEmail, String UCardNumber) {
        System.out.println("-------------------------------------------------------");
        System.out.println("RegisterType2");
        Users user = (Users) req.getSession().getAttribute("registeruser");
        String UPhone = null;
        try {
            UPhone = user.getUphone();
        } catch (Exception e) {
            map.addAttribute("msg", "注册失败");
            map.addAttribute("msgtype", "register");
            return "lrf.jsp";
        }

        UsersInfo userinfo = new UsersInfo();
        userinfo.setUzipcode(UZipCode);
        userinfo.setUcardnumber(UCardNumber);
        userinfo.setUemail(UEmail);
        userinfo.setUname(UName);
        userinfo.setUphone(UPhone);

        //尝试保存用户到数据库
        String result = userBiz.RegisterUser(user, userinfo);

        if (result == "ok") {
            System.out.println("注册成功");
            map.addAttribute("msg", "注册成功");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        } else if (result == "error") {
            map.addAttribute("msg", "注册失败");
            map.addAttribute("msgtype", "register");
            return "lrf.jsp";
        } else {
            map.addAttribute("msg", "注册失败");
            map.addAttribute("msgtype", "register");
            return "lrf.jsp";
        }

    }
}