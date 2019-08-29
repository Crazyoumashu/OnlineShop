package com.hhw.dao;

import com.hhw.BaseTest;
import com.hhw.beans.Receivers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class ReceiversDaoTest extends BaseTest {
    @Autowired
    ReceiversDao receiversDao = null;
    @Test
    public void getReceiverById_correct(){
        Receivers receivers = receiversDao.getReceiverById(0);
        Assert.isTrue(receivers.getName().equals("黄浩威"),"错误");
    }
}
