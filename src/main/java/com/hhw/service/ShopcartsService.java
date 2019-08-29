package com.hhw.service;

import com.hhw.beans.Shopcarts;
import com.hhw.beans.CartHasGoods;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ShopcartsService {

    /**
     * 查询当前用户的所有购物车记录
     * @param userId
     * @return
     */
    List<CartHasGoods> getCartsByUserId(int userId);

    /**
     * 添加购物车记录
     * @param cartHasGoods
     */
    public void addCart(CartHasGoods cartHasGoods);

    /**
     * 删除购物车记录
     * @param userId
     * @param goodsId
     */
    public void deleteById(int userId, int goodsId);

    /**
     * 更改购物车内商品数量
     * @param id
     * @param num
     */
    public void editNum(int id, int num);

    /**
     * 为还没有购物车的用户新建一个购物车
     * @param uid
     */
    public void addShopcart(int uid);

    /**
     * 获取用户的购物车
     * @param uid
     * @return
     */
    public Shopcarts getShopcarts(int uid);

    /**
     * 根据id得到购物车单元（一种商品）
     * @param id
     * @return
     */
    public CartHasGoods getCartById(int id);

    /**
     * 删除用户购物车内所有商品
     * @param uid
     */
    public void deleteAllCarts(int uid);

    /**
     * 得到当前最大的购物车id
     * @return
     */
    public int getMaxScid();

    /**
     * 得到当前最大的购物车单元id
     * @return
     */
    public int getMaxId();
}