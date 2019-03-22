package com.fly.sell.common;

import java.util.concurrent.ConcurrentHashMap;

public class LocalStore {

    private static ConcurrentHashMap<String, String> concurrentHashMap;

    private LocalStore(){}

    // double check
    public static ConcurrentHashMap<String, String> getLocalStoreMap(){
        if(concurrentHashMap == null){
            synchronized (LocalStore.class){
                if(concurrentHashMap == null){
                    concurrentHashMap = new ConcurrentHashMap<>();
                }
            }
        }

        return concurrentHashMap;
    }

}
