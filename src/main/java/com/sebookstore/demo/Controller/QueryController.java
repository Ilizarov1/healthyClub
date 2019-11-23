package com.sebookstore.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sebookstore.demo.Entity.JSUser;
import com.sebookstore.demo.Entity.User;
import com.sebookstore.demo.Entity.UserOrder;
import com.sebookstore.demo.Service.JSService;
import com.sebookstore.demo.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class QueryController {
    @Resource
    JSService jsService;
    @Resource
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value ="/getJsOrders",method = RequestMethod.POST)
    public JSONArray GetJsOrders(@RequestBody JSUser jsUser)
    {
        jsUser = jsService.findById(jsUser.getId());
        List<UserOrder> orderList=orderService.findByJsId(jsUser.getId());
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(orderList));
        return jsonArray;
    }
}

//fucker
