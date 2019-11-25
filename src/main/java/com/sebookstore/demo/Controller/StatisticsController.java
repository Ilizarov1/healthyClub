package com.sebookstore.demo.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sebookstore.demo.Entity.JSUser;
import com.sebookstore.demo.Entity.User;
import com.sebookstore.demo.Entity.UserOrder;
import com.sebookstore.demo.Repository.JSRepository;
import com.sebookstore.demo.Service.HealthyItemService;
import com.sebookstore.demo.Service.JSService;
import com.sebookstore.demo.Service.OrderService;
import com.sebookstore.demo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StatisticsController {
    @Resource
    HealthyItemService healthyItemService;
    @Resource
    OrderService orderService;
    @Resource
    UserService userService;
    @Resource
    JSService jsService;

    @ResponseBody
    @RequestMapping(value ="/getUsersCount",method = RequestMethod.POST)
    public JSONArray GetUserCount()
    {
        List<User> users= userService.findAll();
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(users));
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping(value ="/getJishiCount",method = RequestMethod.POST)
    public JSONArray GetJishiCount()
    {
        List<JSUser> jsUsers= jsService.findAll();
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(jsUsers));
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping(value ="/getOnlineJishiCount",method = RequestMethod.POST)
    public JSONArray GetOnlineJishiCount()
    {
        List<JSUser> jsUsers= jsService.findAllByJsStatu(1);
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(jsUsers));
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping(value ="/getFinishedOrderCount",method = RequestMethod.POST)
    public JSONArray GetFinishedOrderCount()
    {
        List<UserOrder> userOrders = orderService.findAllByState(true);
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(userOrders));
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping(value ="/getTypeOrderCount",method = RequestMethod.POST)
    public JSONArray GetTypeOrderCount(@RequestParam String type)
    {
        System.out.println(type);
        List<UserOrder> userOrders = orderService.findAllByType(type);
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(userOrders));
        return jsonArray;
    }
}
