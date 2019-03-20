package com.fly.sell.controller;

import com.fly.sell.common.ResultVO;
import com.fly.sell.service.SellerService;
import com.fly.sell.vo.SellerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/seller")
@CrossOrigin
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/get")
    public ResultVO<SellerVO> getSeller(@RequestParam(name = "sellerId", required = false, defaultValue = "1") Integer sellerId){
        SellerVO sellerVO = sellerService.querySeller(sellerId);
        return ResultVO.success(sellerVO);
    }

}
