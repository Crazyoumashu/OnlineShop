package com.hhw.util;
import com.hhw.beans.Goods;
import com.hhw.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
public class ShopUtil {
    @Autowired
    UsersService usersService = null;
    @Autowired
    GoodsService goodsService = null;
    @Autowired
    OrdersService ordersService = null;
    @Autowired
    ReceiversService receiversService = null;
    @Autowired
    ShopcartsService shopcartsService = null;

    public static int uid=0;
    private static int gid=0;
    private static int oid=0;
    private static int groupid=0;
    private static int ogid=0;
    private static int rid=0;
    private static int scid=0;
    private static int cgid=0;
    /**
     * 使用UUID类提供的静态方法randomUUID() 得到一个id
     * UUID: A class that represents an immutable universally unique identifier (UUID).
     * A UUID represents a 128-bit value.
     * length: 32
     * @return 随机id，32位字符串
     */
    public static String getId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

    public static int getUid() {
        return uid++;
    }

    public static int getGid() {
        return gid++;
    }

    public static int getOid(){
        return oid++;
    }

    public static int getGroupid(){
        return groupid++;
    }

    public static int getOGid() {return ogid++;}

    public static int getRid() {return rid++;}

    public static int getScid(){return scid++;}

    public static  int getCgid(){return cgid++;}

    /**
     * 得到当前的时间
     * @return 当前时间，格式为"yyyy-MM-dd  HH:mm:ss"
     */
    public static String getNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 得到商品的货号，用时间作为产生的方法
     * @return 18位商品货号，格式为"yyyyMMddHHmmssms"
     */
    public static String getGoodsNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
        return sdf.format(new Date());
    }
}
