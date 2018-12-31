package com.niit.controller;


import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

@Controller
public class SmsController {

    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "SendSms.mvc", method = RequestMethod.POST)
    @ResponseBody
    protected String SmsServlet(String Type,String Phonenum, String UName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, com.github.qcloudsms.httpclient.HTTPException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        if (null == UName || UName.equals("") || null == Phonenum || (Phonenum.equals(""))) {
            return "false";
        }

        if(Type.equals("1")){
        try {
            Users user = userBiz.findUserByPhone(Phonenum);
            if (user != null&&user.getUflag()!=-1) {
                System.out.println("has existed:"+user.toString());
                return "Existed";
            }
        } catch (Exception e) {
            System.out.println("Error !");
        }}


        int appid = 1400086573;
        String appkey = "8251f605677bef6805bca1df9c4a4d63";
        String smsSign = "境界的彼方";
        int code = (int) (Math.random() * 9000 + 1000);


        request.getSession().setAttribute("code", code);
        System.out.println("code = " + code);
        String msg = UName + ",您的验证码为" + code + "，请于30分钟内填写。如非本人操作，请忽略本短信。";

        try {
            //指定模板单发短信；
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", Phonenum,
                    msg, "", "");
            return "success";
        } catch (HTTPException e) {
            System.out.println("HTTP响应码错误");
        } catch (JSONException e) {
            System.out.println("json解析错误");
        }
          catch (IOException e) {
            System.out.println("网络IO错误");
        }
        return "false";

    }

}
