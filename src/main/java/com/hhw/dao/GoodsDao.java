package com.hhw.dao;
import java.util.List;
import java.util.Map;

import com.hhw.beans.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface GoodsDao {
    // 添加商品
    public void addGoods(Goods goods);

    // 返回指定类型的最近添加的四件商品
    public List<Goods> getLatestGoods(@Param("gid") int gid, @Param("type") String type);

    // 返回所有商品
    public List<Goods> getAllGoods();

    // 编辑商品信息
    public void editInfo(Goods goods);

    // 删除商品
    public void deleteGoods(int gid);

    // 查找指定id的商品
    public Goods queryById(int gid);

    // 查询指定id的商品的数量
    public int queryNumberById(int gid);

    // 返回指定类型的所有商品
    public List<Goods> getTypeGoodsList(String type);

    //返回指定销售商的所有商品
    public List<Goods> getGoodsByUid(int uid);

    //返回基于类别与名称模糊查找的商品
    public List<Goods> getGoodsByTypeAndName(@Param("type") String type, @Param("name") String name);

    //按页返回商品
    public List<Goods> getGoodsByPage(Map<String,Object> param);

    //返回所有商品类别
    public List<String> getAllTypes();

    //返回最大的gid
    public Integer getMaxGid();
}
