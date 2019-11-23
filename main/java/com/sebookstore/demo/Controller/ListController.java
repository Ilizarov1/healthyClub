package com.sebookstore.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController
{
    @RequestMapping(value = "/list")
    public String list()
    {
        return "Main/list";
    }
    @RequestMapping(value = "/userlist")
    public String Userlist()
    {
        return "User/list";
    }
    @RequestMapping(value = "/userselflist")
    public String Userselflist()
    {
        return "User/mylist";
    }
    @RequestMapping(value = "/JsList")
    public String JsList(){return "JiShi/JsList";}



}
