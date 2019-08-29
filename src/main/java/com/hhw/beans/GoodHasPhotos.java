package com.hhw.beans;

public class GoodHasPhotos {
    //主键
    private int pid;
    private int gid;
    private String photo;

    public GoodHasPhotos(){

    }

    public GoodHasPhotos(String photo){
        this.photo = photo;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
