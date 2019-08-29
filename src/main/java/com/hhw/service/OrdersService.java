package com.hhw.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hhw.beans.Orders;
import com.hhw.beans.OrderHasGoods;
import com.hhw.beans.PageBeans;
import org.springframework.stereotype.Service;

public interface OrdersService {

    /**
     * 加一个Order
     * @param order 需要增加的订单信息
     */
    public void addOrder(Orders order);

    public void addOrderHasGoods(int ordersId, List<Integer> goodID, List<Integer> num);

    /**
     * 更新Order和OrderDetail
     * @param order 需要更新的的订单信息
     * @param orderDetails 需要进行更新的订单详细的信息
     */
    public void updateOrder(Orders order, List<OrderHasGoods> orderDetails);

    /**
     * 通过参数得到一个含有Order实体类的PageBean
     * @param page 当前的页数
     * @param order PageBean包含的实体类
     * @return
     */
    public PageBeans<Orders> getOrderByPage(int page, Orders order);

    /**
     * 查询订单的信息
     * @param id 订单号
     * @return
     */
    public Orders getOrder(int id);

    /**
     * 通过用户的id得到当前用户的所有的订单信息
     * @param userId
     * @return
     */
    public List<Orders> getOrderByUserId(int userId);

    /**
     * 通过用户的id得到相关的订单信息
     * @param userId
     * @return 含有订单信息的Map<String, Object>
     */
    public Map<String, Object> getOrderInfoByUserId(int userId);

    /**
     * 通过Order的id来得到这个order所包含的所有的goods
     * @param orderId
     * @return 订单中包含的所有goods和其数量等信息
     */
    public List<OrderHasGoods> getOrderDetailByOrderId(int orderId);

    /**
     * 通过时间，状态和用户ID筛选订单
     * @param uid
     * @param begin
     * @param end
     * @param state
     * @return 满足一定组合条件的订单
     */
    public List<Orders> getOrderByUidAndDateAndState(int uid, Date begin, Date end, int state);

    /**
     * 通过商户ID查找所有在其名下的订单
     * @param sid
     * @return
     */
    public List<Orders> getOrderBySalerId(int sid);

    /**
     * 更改订单状态
     * @param state
     * @param oid
     */
    public void editState(int state, int oid);

    /**
     * 删除某订单
     * @param oid
     */
    public void deleteOrder(int oid);

    /**
     * 获取最大订单号
     * @return
     */
    public int getMaxOid();

    /**
     * 获取最大订单单元号
     * @return
     */
    public int getMaxId();
}
