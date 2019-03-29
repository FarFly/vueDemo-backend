package com.fly.sell.enums;

import lombok.Getter;

@Getter
public enum FilePathEnum {
    IMG("/image/"),
    ICON("/icon/");

    private String path;

    FilePathEnum(String path){
        this.path = path;
    }

}
