package com.yhh.playground.mybatis.entity;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;

    List<Order> orderList;

    List<Role> roleList;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'');
        if (orderList != null) {
            stringBuilder.append(", orderList=").append(orderList);
        }
        if (roleList != null) {
            stringBuilder.append(", roleList=").append(roleList);
        }
        stringBuilder.append('}');

        return stringBuilder.toString();
    }


    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
