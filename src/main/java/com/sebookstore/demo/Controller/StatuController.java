package com.sebookstore.demo.Controller;

import com.sebookstore.demo.Entity.JSUser;
import com.sebookstore.demo.Service.JSService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class StatuController {
    @Resource
    JSService jsService;

    @ResponseBody
    @RequestMapping(value = "/workOn" , method = RequestMethod.POST)
    public String WorkOn(HttpSession session, @RequestBody JSUser jsUser){
        jsUser = jsService.findById(jsUser.getId());
        if(jsUser.getJsStatu()==1){
            return "failure";
        }
        jsUser.setJsStatu(1);
        session.setAttribute("jishi",jsUser);
        jsService.save(jsUser);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value ="/workOff",method = RequestMethod.POST)
    public String WorkOff(HttpSession session, @RequestBody JSUser jsUser){
        jsUser = jsService.findById(jsUser.getId());
        if(jsUser.getJsStatu()==0){
            return "failure";
        }
        jsUser.setJsStatu(0);
        session.setAttribute("jishi",jsUser);
        jsService.save(jsUser);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/updateJs",method = RequestMethod.POST)
    public String UpdateJs(@RequestBody JSUser jsUser){
        jsService.save(jsUser);
        return "success";
    }
}



//wdnmd！！！！！