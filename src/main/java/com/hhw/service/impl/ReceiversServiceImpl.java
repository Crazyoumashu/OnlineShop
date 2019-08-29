package com.hhw.service.impl;

import com.hhw.beans.Receivers;
import com.hhw.dao.ReceiversDao;
import com.hhw.service.ReceiversService;
import com.hhw.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("receiversService")
public class ReceiversServiceImpl implements ReceiversService {
    @Autowired
    ReceiversDao receiversDao = null;
    @Override
    public void addReceiver(Receivers receiver) {
//        receiver.setRid(ShopUtil.getRid());
        int maxRid;
        if(receiversDao.getMaxRid()==null)
            maxRid = 0;
        else
            maxRid = receiversDao.getMaxRid();
        receiver.setRid(maxRid+1);
        receiversDao.addReceiver(receiver);
    }

    @Override
    public int getMaxRid() {
        if(receiversDao.getMaxRid()==null)
            return 0;
        return receiversDao.getMaxRid();
    }

    @Override
    public Receivers getFirstReceiver(int uid) {
        return receiversDao.getFirstReceiver(uid);
    }
}
