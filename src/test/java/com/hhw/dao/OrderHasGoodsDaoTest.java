package com.hhw.dao;

import com.hhw.BaseTest;
import com.hhw.beans.OrderHasGoods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class OrderHasGoodsDaoTest extends BaseTest {
    @Autowired
    OrderHasGoodsDao orderHasGoodsdao = null;

    @Test
    public void getOrderDetailByOrderId_correct(){
        int num = orderHasGoodsdao.getOrderDetailByOrderId(0).size();
        Assert.isTrue(num==0,"错误");
    }
}
