package com.hhw.dao;

import com.hhw.BaseTest;
import com.hhw.beans.CartHasGoods;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class CartHasGoodsDaoTest extends BaseTest {
    @Autowired
    CartHasGoodsDao cartHasGoodsdao = null;

    @Test
    public void getAllGoods_correct(){
        int count = cartHasGoodsdao.getAllGoods(913).size();
        Assert.isTrue(count==0,"错误");
    }
}
