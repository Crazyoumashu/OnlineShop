package com.hhw.dao;

import com.hhw.beans.Receivers;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiversDao {
    public void addReceiver(Receivers receiver);
    public Receivers getReceiverById(int rid);
    public Integer getMaxRid();
    public Receivers getFirstReceiver(int uid);
}
