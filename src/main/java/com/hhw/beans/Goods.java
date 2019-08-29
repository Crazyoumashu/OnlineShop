package com.hhw.beans;
import java.util.Date;
public class Goods {
    // 主键
    private int gid;
    //售货商id
    private int uid;
    // 商品名
    private String name;
    // 现有商品数量
    private int num;
    // 商品类型
    private String type;
    // 价格
    private double price;
    // 生产日期
    private Date pdate;
    // 生产地址
    private String paddress;
    // 商品描述
    private String described;
    //缩略图
    private String thumbnail;

    public Goods() {

    }

    public Goods(int uid, String name, int num, String type,
                 String producer, double price, float carriage, Date pdate,
                 String paddress, String described, String thumbnail) {
        this.uid = uid;
        this.name = name;
        this.num = num;
        this.type = type;
        this.price = price;
        this.pdate = pdate;
        this.paddress = paddress;
        this.described = described;
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described;
    }

}
