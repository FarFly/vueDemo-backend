package com.fly.sell.controller;

import com.fly.sell.common.Page;
import com.fly.sell.dto.OrderDTO;
import com.fly.sell.entity.OrderMaster;
import com.fly.sell.enums.ResultEnum;
import com.fly.sell.exception.SellException;
import com.fly.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                             @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                             Map<String, Object> map){
        Page<List<OrderDTO>> orderDTOPage = new Page<>();
        orderDTOPage.setIndex((page - 1) * size);
        orderDTOPage.setSize(size);
        orderDTOPage = orderService.pageQuery(orderDTOPage);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") Integer orderId,
                               Map<String, Object> map){
        try{
            orderService.cancel(orderId);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", "取消订单成功");
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") Integer orderId,
                               Map<String, Object> map) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.selectByPrimaryKey(orderId);
        }catch (SellException e) {
            log.error("【卖家端查询订单详情】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    @GetMapping("/finish")
    public ModelAndView finished(@RequestParam("orderId") Integer orderId,
                                 Map<String, Object> map) {
        try {
            orderService.finish(orderId);
        } catch (SellException e) {
            log.error("【卖家端完结订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }




}
