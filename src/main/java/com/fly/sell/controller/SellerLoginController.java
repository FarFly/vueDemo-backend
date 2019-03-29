package com.fly.sell.controller;

import com.fly.sell.entity.SellerMaster;
import com.fly.sell.service.SellerService;
import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/seller/account")
public class SellerLoginController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static String USER_PRE = "USER_";

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("account/login");
    }

    @PostMapping("/verify")
    public ModelAndView verify(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Map<String, Object> map,
                               HttpSession httpSession){
        SellerMaster sellerMaster = sellerService.login(username, password);
        if(sellerMaster == null){
            map.put("msg", "用户名或密码错误");
            return new ModelAndView("account/login", map);
        }else{
            httpSession.setAttribute("user", sellerMaster.getId());
            return new ModelAndView("redirect:/seller/order/list");
        }
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return new ModelAndView("account/login");
    }


}
