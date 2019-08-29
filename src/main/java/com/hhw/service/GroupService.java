package com.hhw.service;
import java.util.List;

import com.hhw.beans.Group;
import com.hhw.beans.PageBeans;
import org.springframework.stereotype.Service;

public interface GroupService {
    /**
     * 由身份等级获取相应页面
     * @param groupId
     * @return
     */
    public String getJspByGroupid(int groupId);

    /**
     * 增加身份类型
     * @param group
     */
    public void addGroup(Group group);
}
