package com.hhw.controller;

import com.hhw.beans.Goods;
import com.hhw.beans.PageBeans;
import com.hhw.beans.Users;
import com.hhw.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsAction {
    @Autowired
    private GoodsService goodsService = null;


    /**
     * 显示某一商品的详细信息
     * @param
     */
    @RequestMapping("/view")
    public ModelAndView view(int goodsId, ModelAndView mv, HttpSession session){
        if(session.getAttribute("user")==null){
            mv.setViewName("redirect:/user/toLogin");
            return mv;
        }
        Goods goods = goodsService.getGoodsById(goodsId);
        Users user =  (Users)session.getAttribute("user");
        double discount = user.getDiscount();
        double price = goods.getPrice()*discount;
        BigDecimal bg = new BigDecimal(price);
        double price1 = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        goods.setPrice(price1);
        mv.addObject("goods", goods);
        mv.setViewName("goods_view");
        return mv;
    }

    @RequestMapping ("/viewGoodByTypeAndName")
    ModelAndView  viewGoodByTypeAndName(String type, String name,ModelAndView mv){
        System.out.println(type);
        System.out.println(name);
        List<Goods> goods = goodsService.getGoodsByTypeAndName(type,name);
        mv.addObject("goodses",goods);
        mv.addObject("type",type);
        mv.addObject("name",name);
        if(goods.size()==0)
            mv.addObject("nullMsg","对不起，未能找到相应的商品");
        mv.setViewName("search_results");
        return mv;
    }

    @RequestMapping("/listByPage")
    public String listByPage(Integer page, Model model){
        if(page==null||page==0){
            page = new Integer(1);
        }
        PageBeans<Goods> pageBeans = goodsService.getGoodsByPage(page);
        model.addAttribute("pageBeans",pageBeans);
        return "admin/goods_list";
    }
}
