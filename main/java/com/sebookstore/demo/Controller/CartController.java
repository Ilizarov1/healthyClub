package com.sebookstore.demo.Controller;

import com.sebookstore.demo.Entity.HealthyItem;
import com.sebookstore.demo.Entity.User;
import com.sebookstore.demo.Entity.UserOrder;

import com.sebookstore.demo.Service.HealthyItemService;
import com.sebookstore.demo.Service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController
{
    @Resource
    HealthyItemService healthyItemService;

    @Resource
    OrderService orderService;

    @RequestMapping(value = "/cart")
    public String cart()
    {
        return "Main/cart";
    }

    @ResponseBody
    @RequestMapping(value = "/doAddCart",method = RequestMethod.POST)
    public String doAddCart(HttpSession httpSession,@RequestBody HealthyItem healthyItem)
    {
        @SuppressWarnings("unchecked")
        List<HealthyItem> booksInCart=(List<HealthyItem>)httpSession.getAttribute("cart");

        if(booksInCart==null)
        {
            booksInCart=new ArrayList<>();
        }
        HealthyItem bookinBase= healthyItemService.findById(healthyItem.getId());
        if(bookinBase==null || bookinBase.getSpace()==0)
        {
            return "failure";
        }
        if(bookinBase.getNow()+1 > bookinBase.getSpace()){
            return "failure";
        }
         booksInCart.add(bookinBase);
         httpSession.setAttribute("cart",booksInCart);
         return "success";
    }


    @RequestMapping(value = "/doDeleteCart" ,method = RequestMethod.GET)
    public String doDeleteCart(HttpSession httpSession,@RequestParam String id)
    {
        System.out.println(id);
        @SuppressWarnings("unchecked")
        List<HealthyItem> booksInCart=(List<HealthyItem>)httpSession.getAttribute("cart");
        for(int i=0;i<booksInCart.size();i++)
        {
            if(booksInCart.get(i).getId().equals(Long.valueOf(id)))
            {
                booksInCart.remove(i);
                break;
            }
        }
        httpSession.setAttribute("cart",booksInCart);
        return "redirect:/usercart";
    }
    @ResponseBody
    @RequestMapping(value = "/doPay")
    public String doPay(HttpSession httpSession,@RequestBody User user){
        List<HealthyItem> booksInCart = (List<HealthyItem>)httpSession.getAttribute("cart");
        if(booksInCart==null){
            System.out.println("错误1");
            return "failure";
        }
        for (HealthyItem x:booksInCart){
            UserOrder neworder = new UserOrder();
            neworder.setHealthyitemId(x.getId());
            neworder.setUserId(user.getId());
            neworder.setEndTime(x.getEndTime());
            neworder.setStartTime(x.getStartTime());
            neworder.setState(false);
            neworder.setHealthyitemName(x.getHealthyitemName());
            neworder.setJsName(x.getJsName());
            neworder.setType(x.getType());
            neworder.setJsId(x.getJsId());
            UserOrder tempOrder= orderService.save(neworder);
            if(orderService.findById(tempOrder.getId())!=null)
            {
                System.out.println(tempOrder.getId());
            }else {
                System.out.println("错误2");
                return "failure";
            }

        }
        for(HealthyItem x:booksInCart)
        {
            HealthyItem orgin=healthyItemService.findById(x.getId());
            orgin.setState(false);
            healthyItemService.save(orgin);
        }
        httpSession.setAttribute("cart",null);
        return "redirect:/usercart";
    }
}
