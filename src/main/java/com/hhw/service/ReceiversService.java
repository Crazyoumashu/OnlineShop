package com.hhw.service;

import com.hhw.beans.Receivers;
import org.springframework.stereotype.Service;

public interface ReceiversService {
    /**
     * 增加收件人
     * @param receiver
     */
    public void addReceiver(Receivers receiver);

    /**
     * 得到当前最大的收件人id
     * @return
     */
    public int getMaxRid();

    /**
     * 得到数据库表中第一个收件人
     * @param uid
     * @return
     */
    public Receivers getFirstReceiver(int uid);
}
