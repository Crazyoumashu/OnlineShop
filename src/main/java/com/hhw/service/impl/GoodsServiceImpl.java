package com.hhw.service.impl;
import com.hhw.beans.PageBeans;
import com.hhw.dao.GoodsDao;
import com.hhw.beans.Goods;
import com.hhw.service.GoodsService;
import com.hhw.util.ShopUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsdao =null;
    @Override
    public PageBeans<Goods> getGoodsByPageAndOrder(int page, Goods goods, String order) {
        return null;
    }

    @Override
    public List<Goods> search(String keywords) {
        return null;
    }

    @Override
    public void createIndex() {

    }

    @Override
    public void addGoods(Goods goods) {
        int maxGid;
        if(goodsdao.getMaxGid()==null)
            maxGid = 0;
        else
            maxGid = goodsdao.getMaxGid();
        goods.setGid(maxGid+1);
        goodsdao.addGoods(goods);
    }

    @Override
    public List<Goods> getGoods() {
        return goodsdao.getAllGoods();
    }

    @Override
    public PageBeans<Goods> getGoodsByPage(int page, Goods goods) {
        return null;
    }

    @Override
    public Goods getGoodsById(int id) {
        return goodsdao.queryById(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsdao.editInfo(goods);
    }

    @Override
    public void deleteGoods(Goods goods) {
        goodsdao.deleteGoods(goods.getGid());
    }

    @Override
    public List<Goods> getGoodsByOrder(String order, int num, String cateId) {
        return null;
    }

    @Override
    public List<Goods> getGoodsBySellNum(int num) {
        return null;
    }

    @Override
    public List<Goods> getGoodsByRole(int num) {
        return null;
    }

    @Override
    public List<Goods> getGoodsBySellTime(int num) {
        return null;
    }

    @Override
    public List<Goods> getGoodsByCateId(String cateId) {
        return null;
    }

    @Override
    public List<Goods> getGoodsByIds(int... ids) {
        return null;
    }

    @Override
    public List<Goods> getGoodsByUid(int uid){
        return goodsdao.getGoodsByUid(uid);
    }

    @Override
    public List<Goods> getGoodsByTypeAndName(String type, String name){
        type = "%"+type+"%";
        name = "%"+name+"%";
        System.out.println(type);
        System.out.println(name);
        return goodsdao.getGoodsByTypeAndName(type,name);
    }

    @Override
    public PageBeans<Goods> getGoodsByPage(int page) {
        int pageSize = 10;
        PageBeans<Goods> pageBeans = new PageBeans<>();
        Map<String, Object> params = new HashMap<>();
        params.put("indexPage", (page-1)*pageSize);
        params.put("pageSize", pageSize);

        List<Goods> data = goodsdao.getGoodsByPage(params);
        //System.out.println(data.size());

        pageBeans.setData(data);
        pageBeans.setPage(page);
        pageBeans.setPageSize(pageSize);
        pageBeans.setActualPageSize(data.size());
        int totalNum = goodsdao.getAllGoods().size();
        pageBeans.setTotalNum(totalNum);
        int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        pageBeans.setTotalPage(totalPage);
        return pageBeans;
    }

    @Override
    public List<String> getAllTypes() {
        return goodsdao.getAllTypes();
    }

    @Override
    public int getMaxGid() {
        if(goodsdao.getMaxGid()==null)
            return 0;
        return goodsdao.getMaxGid();
    }
}
