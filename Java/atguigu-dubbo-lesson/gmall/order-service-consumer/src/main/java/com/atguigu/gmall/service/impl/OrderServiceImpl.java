package com.atguigu.gmall.service.impl;

import java.io.IOException;
import java.util.List;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 使用的是 Spring 的注解
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserService userService;
    
    public void initOrder(String userId) {
        System.out.println("用户 id：" + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : userAddressList) {
            System.out.println(userAddress.getUserAddress());
        }
    }
}
