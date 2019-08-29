package com.hhw.beans;

public class PayTools {
    private int ptid;
    private String name;
    private String picture;

    public PayTools(){

    }

    public PayTools(String name, String picture){
        this.name = name;
        this.picture = picture;
    }

    public int getPtid(){
        return ptid;
    }

    public void setPtid(String Ptid){
        this.ptid = ptid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPicture(){
        return picture;
    }

    public void setPicture(String picture){
        this.picture = picture;
    }
}
