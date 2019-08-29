package com.hhw.dao;
import java.util.List;
import com.hhw.beans.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersDao {
    // 添加用户
    public void addUser(Users user);

    //更新用户信息
    public void updateUser(Users user);

    // 修改邮箱
    public void editEmail(@Param("uid") int uid, @Param("email") String email);


    // 修改密码
    public void editPassword(@Param("uid") int uid, @Param("password") String password);

    // 修改性别
    public void editSex(@Param("uid") int uid,  @Param("sex") String sex);

    // 修改电话号码
    public void editPhone(@Param("uid") int uid, @Param("phone_num") String phone_num);

    // 修改名字
    public void editName(@Param("uid") int uid, @Param("name") String name);

    // 修改折扣
    public void editDiscount(@Param("uid") int uid, @Param("discount") float discount);

    //修改权限
    public void editGroupId(@Param("uid") int uid, @Param("groupid") int groupid);

    //修改状态
    public void editStatus(@Param("uid") int uid, @Param("status") int status);

    // 修改最后登录时间
    public void editLoginTime(int uid);

    // 删除用户
    public void deleteUser(int uid);

    // 通过id查找用户
    public Users queryById(int uid);

    // 通过用户名查找用户
    public Users queryByname(String username);

    //通过用户名密码得到用户
    public Users getUserByNameAndPwd(@Param("username") String name,
                                    @Param("password") String password);
    // 通过email查找用户
    public Users queryByEmail(String email);

    //得到所有用户
    public List<Users> getAllUser();

    //得到最大的uid
    public Integer getMaxUid();

    //根据用户名和密码和等级确定用户
    public Users getUserByUsernameAndPwdAndRank(@Param("username") String username, @Param("password") String password,
                                                @Param("groupid") int groupid);
}
