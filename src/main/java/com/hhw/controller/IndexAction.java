package com.hhw.controller;

import com.hhw.beans.Goods;
import com.hhw.beans.PageBeans;
import com.hhw.beans.Users;
import com.hhw.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexAction {
    @Autowired
    public GoodsService goodsService;

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/index")
    public String execute(Model model, HttpSession session, Integer page) {
        List<Goods> goodsList = goodsService.getGoods();
        model.addAttribute("goodses", goodsList);
        if(page==null||page==0){
            page = new Integer(1);
        }
        PageBeans<Goods> pageBeans = goodsService.getGoodsByPage(page);
        List<String> types = goodsService.getAllTypes();

        model.addAttribute("pageBeans",pageBeans);
        session.setAttribute("types",types);
        session.setAttribute("base", session.getServletContext().getContextPath());
        session.setAttribute("site", "楚江网上商城");
        List<String> status = new ArrayList<String>();
        status.add("未支付");
        status.add("已支付");
        status.add("卖家已接受");
        status.add("卖家已拒绝");
        status.add("买家已取消");
        session.setAttribute("status",status);
        return "index";
    }
}
