package com.hhw.dao;

import com.hhw.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class GroupDaoTest extends BaseTest {
    @Autowired
    GroupDao groupDao = null;

    @Test
    public void getJsp_correct(){
        String jsp = groupDao.getJsp(0);
        Assert.isTrue(jsp.equals("redirect:/index"),"错误");
    }
}
