package com.atguigu.gmall.service;

import java.util.List;

import com.atguigu.gmall.bean.UserAddress;

public interface UserService {
    // 根据用户 id 返回用户收货地址
    List<UserAddress> getUserAddressList(String id);
}
