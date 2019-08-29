package com.hhw.service.impl;
import com.hhw.beans.Group;
import com.hhw.dao.GoodsDao;
import com.hhw.dao.GroupDao;
import com.hhw.service.GroupService;
import com.hhw.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("groupService")
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupDao groupDao = null;

    @Override
    public String getJspByGroupid(int groupId){
        return groupDao.getJsp(groupId);
    };

    @Override
    public void addGroup(Group group){
        group.setGroupid(ShopUtil.getGroupid());
        groupDao.addGroup(group);
    };
}
