package com.yhh.playground.mybatis.entity;

public class Role {

    private int id;
    private String rolename;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename=" + rolename +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
