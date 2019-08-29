package com.hhw.dao;
import java.util.List;
import com.hhw.beans.Shopcarts;
import com.hhw.beans.CartHasGoods;
import com.hhw.beans.Goods;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CartHasGoodsDao {
    // 为指定id用户添加购物车内商品
    public void addGoods(CartHasGoods cartHasGoods);

    // 为指定id用户删除购物车内商品
    public void deleteGoods(@Param("uid") int uid, @Param("gid") int gid);

    // 为指定id用户查询购物车所有商品
    public List<CartHasGoods> getAllGoods(int uid);

    // 为指定id用户查询指定商品的数量
    public String getDesignateGoodsMs(@Param("uid") int uid, @Param("gid") int gid);

    // 为指定id用户支付商品
    public boolean payGoods(@Param("uid") int uid, @Param("gid") int gid, @Param("number") int number);

    // 位指定id用户支付购物车所有商品
    public boolean payAllGoods(int uid);

    //修改购物车内某个商品的数量
    public void editNum(@Param("num") int num, @Param("id") int id);

    //获取一个购物车单元详细信息
    public CartHasGoods getCartById(int id);

    //清空购物车
    public void deleteAllCarts(int uid);

    //得到购物车单元最大的id值
    public Integer getMaxId();
}
