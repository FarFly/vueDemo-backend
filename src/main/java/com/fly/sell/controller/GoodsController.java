package com.fly.sell.controller;

import com.fly.sell.common.ResultVO;
import com.fly.sell.service.GoodsService;
import com.fly.sell.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/get")
    public ResultVO<List<GoodsVO>> getGoods(){
        List<GoodsVO> goodsVOList = goodsService.queryGoods();
        return ResultVO.success(goodsVOList);
    }

}
