package com.imran.demo.services;

import com.imran.demo.payloads.StoreDto;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public interface StoreService {

    StoreDto placeOrder(StoreDto storeDto);
    void deleteOrder(int orderId);
    StoreDto findOrderById(int orderId);
    HashMap<String,Integer> countByStatus();
}
