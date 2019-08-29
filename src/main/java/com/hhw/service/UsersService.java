package com.hhw.service;

import java.util.List;
import com.hhw.beans.Users;
import org.springframework.stereotype.Service;

public interface UsersService {
    //public void addLogin(Users user);
    public void updateEmail(int id, String email);
    public void updatePhoneNum(int id, String phoneNum);
    public void updatePassword(int id, String password);
    public void updateStatus(int id, int status);

    /**
     * 用于新增用户
     * @param user 新增用户
     */
    public void addUsers(Users user);
    /**
     * 用于进行用户的登陆操作
     * @param name 用户的登录名
     * @param password 用户密码
     * @return 登陆成功后返回用户的实体类对象
     */
    public Users findUser(String name, String password);
    /**
     * 检验用户是否存在
     * @param name 通过名字
     * @return 返回true or false
     */
    public boolean isexist(String name);

    /**
     * 得到所有的用户
     * @return 含有所有用户的集合
     */
    public List<Users> getAllUser();

    /**
     * 通过user的id来删除用户
     * @param id
     */
    public void deleteUser(int id);

    /**
     * 通过user的id来获取用户
     * @param id
     */
    public Users getUser(int id);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(Users user);

    /**
     * 得到当前最大的uid
     * @return
     */
    public int getMaxUid();

    /**
     * 根据用户名，密码与身份进行校验
     * @param username
     * @param password
     * @param groupid
     * @return
     */
    public Users findUser2(String username, String password, int groupid);
}
