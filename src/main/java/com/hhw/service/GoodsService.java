package com.hhw.service;
import java.util.List;

import com.hhw.beans.Goods;
import com.hhw.beans.PageBeans;
import org.springframework.stereotype.Service;

public interface GoodsService {
    public PageBeans<Goods> getGoodsByPageAndOrder(int page,Goods goods,String order);

    /**
     * 搜索商品
     * @param keywords
     */
    public List<Goods> search(String keywords);


    /**
     * 简历商品的搜索索引
     *
     */
    public  void createIndex();


    /**
     * 添加商品
     * @param goods
     */
    public void addGoods(Goods goods);

    /**
     * 得到所有的商品
     * @return
     */
    public List<Goods> getGoods();

    /**
     * 通过参数得到一个含有Goods实体类的PageBean
     * @param page 当前的页数
     * @param goods PageBean包含的实体类
     * @return
     */
    public PageBeans<Goods> getGoodsByPage(int page, Goods goods);

    /**
     * 通过商品的id得到商品的信息
     * @param id 商品的id
     * @return 返回整个商品的信息
     */
    public Goods getGoodsById(int id);

    /**
     * 更新商品的操作
     * @param goods 封装的 Goods参数
     */
    public void updateGoods(Goods goods);

    /**
     * 通过id来删除一个商品
     * @param goods
     */
    public void deleteGoods(Goods goods);

    /**
     * 通过order的排序条件进行排序
     * @param order 排序的条件
     * @param num 取得条数
     * @param cateId 商品的id
     * @return 一个带有Goods的集合
     */
    public List<Goods> getGoodsByOrder(String order, int num, String cateId);

    /**
     * 通过order的排序条件进行排序
     * @param num 取得条数
     * @return 一个带有Goods的集合
     */
    public List<Goods> getGoodsBySellNum(int num);

    /**
     * 通过order的排序条件进行排序
     * @param num 取得条数
     * @return 一个带有Goods的集合
     */
    public List<Goods> getGoodsByRole(int num);

    /**
     * 通过order的排序条件进行排序
     * @param num 取得条数
     * @return 一个带有Goods的集合
     */
    public List<Goods> getGoodsBySellTime(int num);

    /**
     * 通过分类的id来得到商品
     * @param cateId 某个分类的id
     * @return 返回一个带有Goods的集合
     */
    public List<Goods> getGoodsByCateId(String cateId);

    /**
     * 通过一个goodsId的数组来获取一个goods的集合
     * @param ids 一个可变长度的参数的类型
     * @return 返回含有Goods的集合
     */
    public List<Goods> getGoodsByIds(int... ids);

    /**
     * 通过销售商id来获取其销售的全部商品
     * @param uid 销售商id
     * @return 销售商所有商品
     */
    public List<Goods> getGoodsByUid(int uid);

    /**
     * 根据商品类别与名字片段进行模糊搜索
     * @param type
     * @param name
     * @return
     */
    public List<Goods> getGoodsByTypeAndName(String type, String name);

    /**
     * 根据页码查找相应商品
     * @param page
     * @return
     */
    public PageBeans<Goods> getGoodsByPage(int page);

    /**
     * 得到所有商品类型
     * @return
     */
    public List<String> getAllTypes();

    /**
     * 得到当前最大的商品id
     * @return
     */
    public int getMaxGid();
}
