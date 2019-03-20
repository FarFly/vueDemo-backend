package com.fly.sell.handler;


import com.fly.sell.common.ResultVO;
import com.fly.sell.exception.SellException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SellExceptionHandler {


    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVO.fail(e.getCode(), e.getMessage());
    }

}
