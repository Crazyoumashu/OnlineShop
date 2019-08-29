package com.hhw.dao;

import com.hhw.BaseTest;
import com.hhw.beans.Shopcarts;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class ShopcartsDaoTest extends BaseTest {
    @Autowired
    ShopcartsDao shopcartsDao = null;

    @Test
    public void getShopcartsByUid_correct(){
        Shopcarts shopcarts = shopcartsDao.getShopcartsByUid(911);
        Assert.isTrue(shopcarts.getScid()==0,"出错");
    }
}
