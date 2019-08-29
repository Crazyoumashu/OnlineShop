package com.hhw.beans;
import java.util.Date;
public class Orders {
    //主键
    private int oid;
    private Date time;
    private int state;
    private int uid;
    private int sid;



    public Orders() {
    }

    public Orders(Date time, int state, int uid, int sid) {
        this.time = time;
        this.state = state;
        this.uid = uid;
        this.sid = sid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
