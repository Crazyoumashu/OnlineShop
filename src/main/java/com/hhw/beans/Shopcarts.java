package com.hhw.beans;

public class Shopcarts {
    //主键
    private int scid;
    private int uid;
    public Shopcarts() {
    }

    public Shopcarts(int uid) {
        this.uid = uid;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
