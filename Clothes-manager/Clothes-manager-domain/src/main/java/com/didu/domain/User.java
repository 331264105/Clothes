package com.didu.domain;

/**
 * Created by Administrator on 2017/10/28.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String status;
    private String userphone;
    private double balance;
    private String member;
    private String openid;

    public User(int id, String username, String password, String status, String userphone, double balance, String member, String openid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.userphone = userphone;
        this.balance = balance;
        this.member = member;
        this.openid = openid;
    }

    public User(String username, String password, String status, String userphone, double balance, String member, String openid) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.userphone = userphone;
        this.balance = balance;
        this.member = member;
        this.openid = openid;
    }

    public User() {
        super();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", userphone='" + userphone + '\'' +
                ", balance=" + balance +
                ", member='" + member + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }
}
