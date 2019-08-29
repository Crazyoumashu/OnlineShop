package com.hhw.service.impl;
import com.hhw.beans.CartHasGoods;
import com.hhw.beans.Shopcarts;
import com.hhw.dao.ShopcartsDao;
import com.hhw.service.ShopcartsService;
import com.hhw.dao.CartHasGoodsDao;
import com.hhw.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("shopcartsService")
public class ShopcartsServiceImpl implements ShopcartsService{

    @Autowired
    private CartHasGoodsDao cartHasGoodsDao = null;
    @Autowired
    private ShopcartsDao shopcartsDao=null;

    @Override
    public List<CartHasGoods> getCartsByUserId(int userId) {
        return cartHasGoodsDao.getAllGoods(userId);
    }

    @Override
    public void addCart(CartHasGoods cartHasGoods) {
//        cartHasGoods.setId(ShopUtil.getCgid());
        int maxId;
        if(cartHasGoodsDao.getMaxId()==null)
            maxId=0;
        else
            maxId = cartHasGoodsDao.getMaxId()+1;
        cartHasGoods.setId(maxId+1);
        cartHasGoodsDao.addGoods(cartHasGoods);
    }

    @Override
    public void deleteById(int userId, int goodsId) {
        cartHasGoodsDao.deleteGoods(userId,goodsId);
    }

    @Override
    public void editNum(int id, int num){
        cartHasGoodsDao.editNum(num,id);
    }

    @Override
    public void addShopcart(int uid) {
//      int scid = ShopUtil.getScid();
        int maxScid;
        if(shopcartsDao.getMaxScid()==null){
             maxScid = 0;
        }
        else{
             maxScid = shopcartsDao.getMaxScid();
        }
        Shopcarts shopcarts = new Shopcarts();
        shopcarts.setScid(maxScid+1);
        shopcarts.setUid(uid);
        shopcartsDao.addShopcarts(shopcarts);
    }

    @Override
    public Shopcarts getShopcarts(int uid) {
        return shopcartsDao.getShopcartsByUid(uid);
    }

    @Override
    public CartHasGoods getCartById(int id) {
        return cartHasGoodsDao.getCartById(id);
    }

    @Override
    public void deleteAllCarts(int uid) {
        cartHasGoodsDao.deleteAllCarts(uid);
    }

    @Override
    public int getMaxScid() {
        if(shopcartsDao.getMaxScid()==null)
            return 0;
        return shopcartsDao.getMaxScid();
    }

    @Override
    public int getMaxId() {
        if(cartHasGoodsDao.getMaxId()==null)
            return 0;
        return cartHasGoodsDao.getMaxId();
    }
}
