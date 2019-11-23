package com.sebookstore.demo.Controller;

import com.sebookstore.demo.Entity.JSUser;
import com.sebookstore.demo.Entity.User;
import com.sebookstore.demo.Entity.AdminUser;
import com.sebookstore.demo.Service.AdminService;
import com.sebookstore.demo.Service.JSService;
import com.sebookstore.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Console;

@Controller
public class RegisterController
{
    @Resource
    private UserService userService;
    @Resource
    private AdminService adminService;
    @Resource
    private JSService jsService;

    @ResponseBody
    @RequestMapping(value = "/doSignUp",method = RequestMethod.POST)
    public String addNewUser(@RequestBody User user, HttpSession httpSession)
    {
        User tempUser=userService.findByUserName(user.getUserName());
        if(tempUser==null)
        {
            userService.save(user);
            httpSession.setAttribute("user",user);
            return "success";
        }
        else return "failure";

    }

    @ResponseBody
    @RequestMapping(value = "/dojishiSignUp",method = RequestMethod.POST)
    public String addNewJS(@RequestBody JSUser jsUser)
    {
        JSUser tempJS=jsService.findByJsName(jsUser.getJsName());
        if(tempJS==null)
        {
            jsService.save(jsUser);
            return "success";
        }
        else return "failure";
    }


    @ResponseBody
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(@RequestBody User user,HttpSession httpSession)
    {
        User tempUser=userService.findByUserName(user.getUserName());
        if(tempUser==null)
        {
            return "none";
        }
        if(tempUser.getPwd().equals(user.getPwd()))
        {
            httpSession.setAttribute("user",tempUser);
            httpSession.setAttribute("userid",tempUser.getId());
        }
        else
        {
            return "failure";
        }
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "/doAdminLogin",method = RequestMethod.POST)
    public String doAdminLogin(@RequestBody AdminUser adminUser,HttpSession httpSession)
    {
        AdminUser tempAdmin=adminService.findByAdminName(adminUser.getAdminName());
        if(tempAdmin==null)
        {
            return "none";
        }
        if(tempAdmin.getAdminPwd().equals(adminUser.getAdminPwd()))
        {
            httpSession.setAttribute("admin",tempAdmin);
        }
        else
        {
            return "failure";
        }
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "/doJishiLogin",method = RequestMethod.POST)
    public String doJishiLogin(@RequestBody JSUser jsUser, HttpSession httpSession)
    {
        JSUser tempJS = jsService.findByJsName(jsUser.getJsName());
        System.out.println(jsUser.getJsName());
        if(tempJS==null)
        {
            return "none";
        }
        if(tempJS.getJsPwd().equals(jsUser.getJsPwd()))
        {
            httpSession.setAttribute("jishi",tempJS);
            httpSession.setAttribute("jsId",tempJS.getId());
        }
        else
        {
            return "failure";
        }
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "/loginOut",method = RequestMethod.POST)
    public String LoginOut(HttpSession httpSession){
        //httpSession.setAttribute("user",null);
        httpSession.removeAttribute("user");
        httpSession.removeAttribute("jishi");
        httpSession.removeAttribute("jsID");
        httpSession.removeAttribute("admin");

        return "success";
    }

}
