package com.hhw.dao;
import java.util.List;
import com.hhw.beans.Orders;
import com.hhw.beans.OrderHasGoods;
import com.hhw.beans.Goods;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderHasGoodsDao {
    /**
     * 增加一个OrderDetail对象
     * @param orderDetail 要增加的订单详细信息实体
     */
    public void addOrderDetail(OrderHasGoods orderDetail);

    /**
     * 更新一个订单详细信息
     * @param orderDetail 要更新的订单详细信息实体
     */
    public void updateOrderDetail(OrderHasGoods orderDetail);

    /**
     * 通过Order的id来得到这个order所包含的所有的orderDetail
     * @param oid
     * @return
     */
    public List<OrderHasGoods> getOrderDetailByOrderId(int oid);

    /**
     * 删除某order的所有orderDetail，即删除Order的一个子过程
     */
    public void deleteByOrderId(int oid);

    //得到订单单元最大的ID
    public Integer getMaxId();

}
