package com.atguigu.gmall.service.impl;

import java.util.Arrays;
import java.util.List;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;

public class UserServiceImpl implements UserService {
    public List<UserAddress> getUserAddressList(String id) {
        UserAddress address = new UserAddress(1, "南京市北京东路");
        return Arrays.asList(address);
    }
}
