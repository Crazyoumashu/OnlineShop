package com.hhw.dao;

import com.hhw.BaseTest;
import com.hhw.beans.Goods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class GoodsDaoTest extends BaseTest {
    @Autowired
    GoodsDao goodsDao = null;

    @Test
    public void queryById_correct(){
        Goods goods = goodsDao.queryById(911);
        Assert.isTrue(goods.getName().equals("Iphone X"),"查找出错");
    }
}
