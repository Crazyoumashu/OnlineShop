package com.hhw.dao;
import java.util.List;
import com.hhw.beans.Group;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface GroupDao {
    //添加用户等级与页面的对应
    public void addGroup(Group group);
    //获取不同等级所对应的页面
    public String getJsp(int groupid);
    //获取不同等级所对应的页面
    public List<String> getAllJsp(int groupid);
}
