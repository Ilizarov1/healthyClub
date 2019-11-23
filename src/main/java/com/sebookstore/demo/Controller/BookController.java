package com.sebookstore.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;
import com.sebookstore.demo.Entity.HealthyItem;
import com.sebookstore.demo.Entity.JSUser;
import com.sebookstore.demo.Entity.User;
import com.sebookstore.demo.Entity.UserOrder;
import com.sebookstore.demo.Repository.JSRepository;
import com.sebookstore.demo.Service.HealthyItemService;
import com.sebookstore.demo.Service.OrderService;
import com.sebookstore.demo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController
{
    @Resource
    HealthyItemService healthyItemService;
    @Resource
    OrderService orderService;
    @Resource
    UserService userService;
    @Resource
    JSRepository jsRepository;

    @ResponseBody
    @RequestMapping(value = "/doUpdateBook",method = RequestMethod.POST)
    public String doUpdateBook(@RequestBody HealthyItem healthyItem)
    {
        HealthyItem newbook= healthyItemService.save(healthyItem);
        if(healthyItemService.findById(newbook.getId())!=null)
        {
            System.out.println(newbook.getId());
            return "success";
        }
        return "failure";
    }
    @ResponseBody
    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    public JSONArray getList()
    {
        JSONArray jsonArray=new JSONArray();
        List<HealthyItem> healthyItemList = healthyItemService.findAll();
        jsonArray=JSONArray.parseArray(JSON.toJSONString(healthyItemList));
        System.out.println(jsonArray);
        return jsonArray;
    }
    @ResponseBody
    @RequestMapping(value = "/getJsList",method = RequestMethod.POST)
    public JSONArray getJsList(@RequestBody JSUser jsUser)
    {
        JSONArray jsonArray=new JSONArray();
        List<HealthyItem> healthyItemList = healthyItemService.findByJsId(jsUser.getId());
        jsonArray=JSONArray.parseArray(JSON.toJSONString(healthyItemList));
        System.out.println(jsonArray);
        return jsonArray;
    }
    @ResponseBody
    @RequestMapping(value = "/doAddItem",method = RequestMethod.POST)
    public String doAddItem(@RequestBody HealthyItem healthyItem)
    {
        HealthyItem newbook= healthyItemService.save(healthyItem);
        System.out.println(newbook.getHealthyitemName());
        if(healthyItemService.findById(newbook.getId())!=null)
        {
            System.out.println(newbook.getId());
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/getUserOrder",method = RequestMethod.POST)
    public JSONArray getUserOrder(@RequestBody User user)
    {
        user=userService.findById(user.getId());
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(orderService.findByUserId(user.getId())));
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    public JSONArray getUserList( @RequestBody JSUser jsUser){
        JSONArray jsonArray=new JSONArray();
        List<UserOrder> userOrders =orderService.findByUserId(jsUser.getId());
        ArrayList<HealthyItem> userHealthyItems=new ArrayList<HealthyItem>();
        for(UserOrder x:userOrders){
            HealthyItem temp=healthyItemService.findById(x.getHealthyitemId());
            if(temp!=null)
            {
                userHealthyItems.add(temp);
            }

        }
        jsonArray=JSONArray.parseArray(JSON.toJSONString( userHealthyItems));
        System.out.println("用户表：");
        System.out.println(jsonArray);
        return jsonArray;
    }
    @ResponseBody
    @RequestMapping(value = "/getItemDetailMsgByJs",method = RequestMethod.POST)
    public String getItemDetailMsgByJs(HttpSession httpSession, @RequestBody HealthyItem healthyItem){
        //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        HealthyItem theHealthyItem = healthyItemService.findById(healthyItem.getId());
        //System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        List<UserOrder> userOrders =orderService.findByHealthyitemId(theHealthyItem.getId());
        //System.out.println("cccccccccccccccccccccccccccccccccc");
        ArrayList users =new ArrayList<User>();
        for(UserOrder x:userOrders){
            users.add(userService.findById(x.getUserId()));
        }
        httpSession.setAttribute("myuser",users);
        httpSession.setAttribute("thisorder",userOrders);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/getAllUsers",method = RequestMethod.POST)
    public JSONArray getAllUsers()
    {
        List<User> userlist=userService.findAll();
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(userlist));
        return jsonArray;

    }

    @ResponseBody
    @RequestMapping(value = "/getAllJS",method = RequestMethod.POST)
    public JSONArray getAllJS()
    {
        List<JSUser> jsList=jsRepository.findAll();
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(jsList));
        return jsonArray;

    }

    @ResponseBody
    @RequestMapping(value ="/getOrder",method = RequestMethod.POST)
    public JSONArray getOrder(@RequestBody User user)
    {
        user=userService.findById(user.getId());
        List<UserOrder> orderList=orderService.findByUserId(user.getId());
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(orderList));
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping(value = "/changeOrderState",method = RequestMethod.POST)
    public String changeOrderState(@RequestBody UserOrder userOrder)
    {
        userOrder=orderService.findById(userOrder.getId());
        if(userOrder==null || userOrder.getState())
            return "failure";
        userOrder.setState(true);
        orderService.save(userOrder);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/getAllOrder",method = RequestMethod.POST)
    public JSONArray getAllOrder()
    {
        List<UserOrder> orderList=orderService.findAll();
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(orderList));
        return jsonArray;
    }

    @RequestMapping(value = "/doMission",method = RequestMethod.GET)
    public String doMission(@RequestParam long id,HttpSession httpSession)
    {
        JSUser jsUser=jsRepository.findById(id);
        httpSession.setAttribute("jishi",jsUser);
        return "admin/distribute";
    }


    @ResponseBody
    @RequestMapping(value = "/doUpdateItem",method = RequestMethod.POST)
    public String doUpdateItem(@RequestBody HealthyItem healthyItem,HttpSession httpSession)
    {
//        System.out.println(healthyItem.getId());
//        System.out.println(healthyItem.getStartTime());
//        System.out.println(healthyItem.getEndTime());
        httpSession.setAttribute("itemUpdated",healthyItem);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/doUpdateUser",method = RequestMethod.POST)
    public String doUpdateUser(@RequestBody User user)
    {
        userService.save(user);
        return "success";
    }

    @RequestMapping(value = "/showInfo",method = RequestMethod.GET)
    public String showInfo(@RequestParam long id,HttpSession httpSession)
    {
        JSUser jsUser=jsRepository.findById(id);
        httpSession.setAttribute("jsId",jsUser.getId());
        System.out.println("这里是更多:"+jsUser.getId());
        return "admin/jishiDetail";
    }

}
