package com.hhw.dto;

import com.hhw.beans.OrderHasGoods;

import java.io.Serializable;
import java.util.List;

public class OrderHasGoodsDTO implements Serializable {
    List<OrderHasGoods> orderHasGoodsList;

    public OrderHasGoodsDTO(){
        super();
    }

    public List<OrderHasGoods> getOrderHasGoodsList() {
        return orderHasGoodsList;
    }

    public void setOrderHasGoodsList(List<OrderHasGoods> orderHasGoodsList) {
        this.orderHasGoodsList = orderHasGoodsList;
    }
}
