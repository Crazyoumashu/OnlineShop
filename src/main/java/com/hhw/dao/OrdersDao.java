package com.hhw.dao;
import java.util.Date;
import java.util.List;
import com.hhw.beans.Orders;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdersDao {
    // 添加订单
    public void addOrders(Orders order);

    // 返回未支付订单或已支付订单
    public List<Orders> getOrdersByState(int state);

    public List<Orders> getOrdersByUidAndDateAndState(@Param("begin") Date begin, @Param("end") Date end, @Param("state") int state,@Param("uid") int uid);

    // 返回某用户不同状态的订单
    public List<Orders> getOrdersByUidAndState(@Param("uid") int uid, @Param("state") int state);
    //返回最近的四个订单
    public List<Orders> getLatestOrders();

    // 返回所有订单
    public List<Orders> getAllOrders();

    // 删除订单
    public void deleteOrders(int oid);

    // 查找指定id的订单
    public Orders queryById(int oid);

    //获取某个用户的订单
    public List<Orders> getOrderByUserId(int uid);

    //获取某个商户的订单
    public List<Orders> getOrderBySalerId(int sid);

    //按页展示订单
    public List<Orders> getOrderByPage(Map<String, Object> params);

    //更新订单
    public void updateOrder(Orders order);

    //更新订单状态
    public void editState(@Param("state") int state, @Param("oid") int oid);

    //得到当前最大的订单号
    public Integer getMaxOid();
}
