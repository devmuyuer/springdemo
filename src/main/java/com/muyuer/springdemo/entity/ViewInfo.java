package com.muyuer.springdemo.entity;

import java.io.Serializable;

/**
 * 多表查询 创建一个结果集的接口来接收连表查询后的结果
 * @author muyuer 182443947@qq.com
 * @date 2018-11-30 14:19
 */
public class ViewInfo implements Serializable {

    private static final long serialVersionUID = -6347911007178390219L;

    private UserInfo userInfo;
    private Address address;

    public ViewInfo() {

    }

    public ViewInfo(UserInfo userInfo) {
        Address address = new Address();
        this.userInfo = userInfo;
        this.address = address;
    }

    public ViewInfo(Address address) {
        UserInfo userInfo = new UserInfo();
        this.userInfo = userInfo;
        this.address = address;
    }

    public ViewInfo(UserInfo userInfo, Address address) {
        this.userInfo = userInfo;
        this.address = address;
    }
    public UserInfo getUserInfo() {
        return this.userInfo;
    }
    public Address getAddress() {
        return this.address;
    }

}