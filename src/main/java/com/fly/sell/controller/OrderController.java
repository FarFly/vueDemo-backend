package com.fly.sell.controller;

import com.fly.sell.common.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {


    @PostMapping("/hello")
    public ResultVO hello(){
        return ResultVO.success(new String("Hello world"));
    }

}
