package com.atguigu.gmall.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddress implements Serializable {
    private Integer id;
    private String userAddress;
    
    public UserAddress(Integer id, String userAddress) {
        this.id = id;
        this.userAddress = userAddress;
    }
}
