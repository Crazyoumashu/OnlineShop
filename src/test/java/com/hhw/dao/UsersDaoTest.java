package com.hhw.dao;

import com.hhw.BaseTest;
import com.hhw.beans.Users;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UsersDaoTest extends BaseTest {
    @Autowired
    UsersDao usersDao = null;

    @Test
    public void queryById_test() throws Exception{
        Users user = usersDao.queryById(911);
        System.out.println(user.getName());
        Assert.isTrue(user.getName().equals("黄浩威"),"查找用户出错");
    }
}
