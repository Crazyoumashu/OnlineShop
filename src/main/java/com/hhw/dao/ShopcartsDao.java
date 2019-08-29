package com.hhw.dao;
import java.util.List;
import com.hhw.beans.Shopcarts;
import com.hhw.beans.CartHasGoods;
import com.hhw.beans.Goods;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ShopcartsDao {
    // 为指定id用户添加购物车内商品
    public boolean addGoods(@Param("uid") int uid, @Param("gid") int gid, @Param("number") int number);

    // 为指定id用户删除购物车内商品
    public boolean deleteGoods(@Param("uid") int uid, @Param("gid") int gid, @Param("number") int number);

    // 为指定id用户查询购物车所有商品
    public List<Goods> getAllGoods(int uid);

    // 为指定id用户查询指定商品的数量
    public String getDesignateGoodsMs(@Param("uid") int uid, @Param("gid") int gid);

    // 为指定id用户支付商品
    public boolean payGoods(@Param("uid") int uid, @Param("gid") int gid, @Param("number") int number);

    // 位指定id用户支付购物车所有商品
    public boolean payAllGoods(int uid);

    //新建购物车
    public void addShopcarts(Shopcarts shopcarts);

    //由用户得到购物车
    public Shopcarts getShopcartsByUid(int uid);

    public Integer getMaxScid();
}
