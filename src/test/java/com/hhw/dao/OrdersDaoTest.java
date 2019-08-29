package com.hhw.dao;

import com.hhw.BaseTest;
import com.hhw.beans.Orders;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class OrdersDaoTest extends BaseTest {
    @Autowired
    OrdersDao ordersDao = null;

    @Test
    public void queryById_correct(){
        Orders orders = ordersDao.queryById(0);
        Assert.isTrue(orders.getUid()==911,"错误");
    }
}
