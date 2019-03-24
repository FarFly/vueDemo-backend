package com.fly.sell.common;

import lombok.Data;

@Data
public class Page<T> {

    private Integer index;
    private Integer size;
    private Integer totalPages;
    private Integer totalCount;
    private T data;


}
