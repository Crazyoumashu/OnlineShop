package com.hhw.service.impl;

import java.util.List;

import com.hhw.dao.UsersDao;
import com.hhw.beans.Users;
import com.hhw.service.UsersService;
import com.hhw.util.ShopUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("usersService")
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersDao usersDao = null;

    @Override
    public void addUsers(Users user){
        int maxUid;
        if(usersDao.getMaxUid()==null){
            maxUid = 0;
        }
        else
            maxUid = usersDao.getMaxUid();
        user.setUid(maxUid+1);
        user.setIs_paying(0);
        usersDao.addUser(user);
    }

    @Override
    public void updateEmail(int id, String email) {
        usersDao.editEmail(id, email);
    }

    @Override
    public void updatePhoneNum(int id, String phoneNum) {
        usersDao.editPhone(id, phoneNum);
    }

    @Override
    public void updatePassword(int id, String password) {
        usersDao.editPassword(id,password);
    }

    @Override
    public Users findUser(String name, String password) {
        Users user = this.usersDao.getUserByNameAndPwd(name,password);
        return user;
    }

    @Override
    public boolean isexist(String name) {
        Users user = usersDao.queryByname(name);
        return user!=null;
    }

    @Override
    public List<Users> getAllUser() {
        return usersDao.getAllUser();
    }

    @Override
    public void deleteUser(int id) {
        usersDao.deleteUser(id);
    }


    @Override
    public Users getUser(int id) {
        return usersDao.queryById(id);
    }

    @Override
    public void updateStatus(int id, int status){
        usersDao.editStatus(id,status);
    }

    @Override
    public void updateUser(Users user){
        usersDao.updateUser(user);
    }

    @Override
    public int getMaxUid() {
        if(usersDao.getMaxUid()==null)
            return 0;
        return usersDao.getMaxUid();
    }

    @Override
    public Users findUser2(String username, String password, int groupid) {
        return usersDao.getUserByUsernameAndPwdAndRank(username,password,groupid);
    }
}
