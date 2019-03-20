package com.fly.sell.exception;

import lombok.Getter;

/**
 * Created by 廖师兄
 * 2017-06-11 18:55
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
