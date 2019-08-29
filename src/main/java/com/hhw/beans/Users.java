package com.hhw.beans;

public class Users {
    //主键
    private int uid;
    private String name;
    private String email;
    private String password;
    private String sex;
    private String phone_num;
    private double discount;
    //指示用户类别（1：普通；2：卖家；3：管理者）
    private int groupid;
    private String username;
    private int status;
    private int is_paying;

    public Users(){
    }

    public Users(String name,String email,String password,
                      String sex,String phone_num,double discount, int groupid, String username, int status, int is_paying){
        this.name = name;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.phone_num = phone_num;
        this.discount = discount;
        this.groupid = groupid;
        this.username = username;
        this.status = status;
        this.is_paying = is_paying;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getIs_paying() {
        return is_paying;
    }

    public void setIs_paying(int is_paying) {
        this.is_paying = is_paying;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
