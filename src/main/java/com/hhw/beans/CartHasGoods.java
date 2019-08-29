package com.hhw.beans;

public class CartHasGoods {
    private int id;
    private int scid;
    private int uid;
    private int gid;
    private int num;

    public CartHasGoods() {

    }

    public CartHasGoods(int scid, int uid, int gid, int num) {
        this.scid = scid;
        this.uid = uid;
        this.gid = gid;
        this.num = num;
    }

    public CartHasGoods(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
