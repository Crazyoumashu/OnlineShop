package com.hhw.beans;

public class Receivers {
    private int rid;
    private int uid;
    private String name;
    private String address;
    private String postcode;
    private String phone_num;
    private String date;

    public Receivers(){

    }

    public Receivers(int uid, String name, String address, String postcode, String phone_num, String date){
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.phone_num = phone_num;
        this.date = date;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }
}
