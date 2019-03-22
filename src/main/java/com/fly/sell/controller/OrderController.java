package com.fly.sell.controller;

import com.fly.sell.common.ResultVO;
import com.fly.sell.form.ProductForm;
import com.fly.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResultVO createOrder(@RequestBody ProductForm productForm,
                                HttpServletRequest httpServletRequest){

        Integer tableId = (Integer) httpServletRequest.getSession().getAttribute("tableId");
        orderService.createOrder(productForm, tableId);
        return ResultVO.success(new String("Hello world"));
    }

}
