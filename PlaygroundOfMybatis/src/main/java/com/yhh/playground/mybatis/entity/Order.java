package com.yhh.playground.mybatis.entity;

public class Order {

    private int id;
    private double total;
    private User user;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Order{" +
                "id=" + id +
                ", total=" + total);
        if (user != null) {
            stringBuilder.append(", user=").append(user.getUsername());
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
