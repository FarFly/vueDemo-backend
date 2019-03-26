package com.fly.sell.service;

import com.fly.sell.entity.SellerMaster;
import com.fly.sell.vo.SellerVO;

public interface SellerService {
    SellerVO querySeller(int sellerId);
    SellerMaster login(String username, String password);
}
