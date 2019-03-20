package com.fly.sell.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ResultVO<T> implements Serializable{
    /** 错误码. */
    private Integer errno;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;

    public ResultVO(Integer errno){
        this.errno = errno;
    }

    public static <T> ResultVO<T> success(T data){
        ResultVO<T> resultVO = new ResultVO<>(0);
        resultVO.data = data;
        return resultVO;
    }

    public static <T> ResultVO<T> success(){
        ResultVO<T> resultVO = new ResultVO<>(0);
        return resultVO;
    }

    public static <T> ResultVO<T> fail(Integer code, String msg) {
        ResultVO<T> resultVO = new ResultVO<>(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("errno", errno);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

}
