package com.sebookstore.demo.Controller;

import com.sebookstore.demo.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController
{
    @RequestMapping(value = "/")
    public String index()
    {
        return "index";
    }
    @RequestMapping(value = "/signup")
    public String registration()
    {
        return "register/signup";
    }
    @RequestMapping(value = "/login")
    public String login()
    {
        return "register/login";
    }
    @RequestMapping(value = "/adminLogin")
    public String adminLogin()
    {
        return "register/adminLogin";
    }
    @RequestMapping(value = "/updateBook")
    public String updateBook()
    {
        return "admin/updateBook";
    }
    @RequestMapping(value = "/jishiLogin")
    public String jishiLogin()
    {
        return "register/jishiLogin";
    }

    @RequestMapping(value = "/addItem")
    public String addItem()
    {
        return "jiShi/addItem";
    }
    @RequestMapping(value = "/jsList")
    public String JsList()
    {
        return "jiShi/JsList";
    }
    @RequestMapping(value = "/browse")
    public String Browse()
    {
        return "user/list";
    }
    @RequestMapping(value = "/mylist")
    public String Mylist()
    {
        return "user/mylist";
    }
    @RequestMapping(value = "/usercart")
    public String Usercart()
    {
        return "user/cart";
    }

    @RequestMapping(value = "/myuser")
    public String Myuser()
    {
        return "jiShi/UserList";
    }
    @RequestMapping(value = "/updateUser")
    public String allUSers(){return "admin/updateUser";}
    @RequestMapping(value = "/updateJishi")
    public String allJishi(){return "admin/updateJishi";}
    @RequestMapping(value = "/updateOrder")
    public String allOrders(){return "admin/updateOrder";}
    @RequestMapping(value = "/jsself")
    public String Jsself(){return "jiShi/self";}

    @RequestMapping(value = "/jishisignup")
    public String jishisignup(){return "register/jishisignup";}
    @RequestMapping(value = "itemUpdated")
    public String itemUpdated(){return "admin/itemUpdated";}
}
