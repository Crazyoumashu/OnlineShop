package com.hhw.service.impl;

import com.hhw.beans.OrderHasGoods;
import com.hhw.beans.Orders;
import com.hhw.beans.PageBeans;
import com.hhw.dao.GoodsDao;
import com.hhw.dao.OrderHasGoodsDao;
import com.hhw.dao.OrdersDao;
import com.hhw.dao.UsersDao;
import com.hhw.service.OrdersService;
import com.hhw.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersdao = null;
    @Autowired
    private OrderHasGoodsDao ordersHasGoodsdao=null;
    @Autowired
    private UsersDao usersDao=null;
    @Autowired
    private GoodsDao goodsDao=null;

    @Override
    public void addOrder(Orders order) {
//        order.setOid(ShopUtil.getOid());
        int maxOid;
        if(ordersdao.getMaxOid()==null)
            maxOid = 0;
        else
            maxOid= ordersdao.getMaxOid();
        order.setOid(maxOid+1);
        order.setTime(new Date());
        order.setState(0);
        ordersdao.addOrders(order);
    }
    @Override
    public void addOrderHasGoods(int ordersId, List<Integer> goodID, List<Integer> num){
        double discount = usersDao.queryById(ordersdao.queryById(ordersId).getUid()).getDiscount();
        for(int i = 0; i<goodID.size();i++){
            OrderHasGoods orderHasGoods = new OrderHasGoods();
            int maxId;
            if(ordersHasGoodsdao.getMaxId()==null)
                maxId=0;
            else
                maxId = ordersHasGoodsdao.getMaxId();
            orderHasGoods.setId(maxId+1);
            orderHasGoods.setOid(ordersId);
            System.out.println(goodID.get(i));
            orderHasGoods.setGid(goodID.get(i));
            orderHasGoods.setNum(num.get(i));
            orderHasGoods.setPrice(discount*goodsDao.queryById(goodID.get(i)).getPrice());
            ordersHasGoodsdao.addOrderDetail(orderHasGoods);
        }
    }
    @Override
    public void updateOrder(Orders order, List<OrderHasGoods> orderDetails) {
        ordersdao.updateOrder(order);
        for(OrderHasGoods orderDetail : orderDetails){
            ordersHasGoodsdao.updateOrderDetail(orderDetail);
        }
    }

    @Override
    public PageBeans<Orders> getOrderByPage(int page, Orders order) {
        return null;
    }

    @Override
    public Orders getOrder(int id) {
        return ordersdao.queryById(id);
    }

    @Override
    public List<Orders> getOrderByUserId(int userId) {
        return ordersdao.getOrderByUserId(userId);
    }

    @Override
    public Map<String, Object> getOrderInfoByUserId(int userId) {
        return null;
    }

    @Override
    public List<OrderHasGoods> getOrderDetailByOrderId(int orderId) {
        return ordersHasGoodsdao.getOrderDetailByOrderId(orderId);
    }
    @Override
    public List<Orders> getOrderByUidAndDateAndState(int uid, Date begin, Date end, int state){
        return ordersdao.getOrdersByUidAndDateAndState(begin,end,state,uid);
    }

    @Override
    public List<Orders> getOrderBySalerId(int sid){
        return ordersdao.getOrderBySalerId(sid);
    }

    @Override
    public void editState(int state, int oid){
        ordersdao.editState(state,oid);
    }

    @Override
    public void deleteOrder(int oid){
        ordersHasGoodsdao.deleteByOrderId(oid);
        ordersdao.deleteOrders(oid);
    }

    @Override
    public int getMaxOid() {
        if(ordersdao.getMaxOid()==null)
            return 0;
        return ordersdao.getMaxOid();
    }

    @Override
    public int getMaxId() {
        if(ordersHasGoodsdao.getMaxId()==null)
            return 0;
        return ordersHasGoodsdao.getMaxId();
    }
}
