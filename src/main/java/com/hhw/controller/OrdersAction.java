package com.hhw.controller;

import com.hhw.beans.*;
import com.hhw.dto.OrderHasGoodsDTO;
import com.hhw.service.GoodsService;
import com.hhw.service.OrdersService;
import com.hhw.service.ReceiversService;
import com.hhw.service.ShopcartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrdersAction {
    @Autowired
    GoodsService goodsService = null;
    @Autowired
    OrdersService ordersService = null;
    @Autowired
    ReceiversService receiversService = null;
    @Autowired
    ShopcartsService shopcartsService = null;

    @RequestMapping("/settle")
    public String settle(OrderHasGoodsDTO orderHasGoodsDTO, Receivers receivers, String payType, double totalcost, HttpSession session, Model model){
        if(session.getAttribute("user")==null)
            return "redirect:/user/toLogin";
        Users user = (Users) session.getAttribute("user");
        Orders orders = new Orders();
        List<OrderHasGoods> orderHasGoodsList = orderHasGoodsDTO.getOrderHasGoodsList();
        orders.setSid(goodsService.getGoodsById(orderHasGoodsList.get(0).getGid()).getUid());
        orders.setUid(user.getUid());
        ordersService.addOrder(orders);
        List<Integer> gid = new ArrayList<Integer>();
        List<Integer> num = new ArrayList<Integer>();
        for(OrderHasGoods orderHasGoods: orderHasGoodsList){
            gid.add(orderHasGoods.getGid());
            num.add(orderHasGoods.getNum());
            Goods goods = goodsService.getGoodsById(orderHasGoods.getGid());
            goods.setNum(goods.getNum()-orderHasGoods.getNum());
            //goodsService.getGoodsById(orderHasGoods.getGid()).setNum(goodsService.getGoodsById(orderHasGoods.getGid()).getNum()-orderHasGoods.getNum());
            goodsService.updateGoods(goods);
        }
        ordersService.addOrderHasGoods(orders.getOid(), gid, num);
        receivers.setUid(user.getUid());
        receiversService.addReceiver(receivers);
        shopcartsService.deleteAllCarts(user.getUid());
        model.addAttribute("payType",payType);
        model.addAttribute("totalcost",totalcost);
        model.addAttribute("order",orders);
        model.addAttribute("receiver",receivers);
        return "order_submit";
    }

    @RequestMapping("/settle_one")
    public String settle_one(int gid, int num, Receivers receivers, String payType, double totalcost, HttpSession session, Model model){
        if(session.getAttribute("user")==null)
            return "redirect:/user/toLogin";
        Users user = (Users) session.getAttribute("user");
        Orders orders = new Orders();
        orders.setUid(user.getUid());
        Goods goods = goodsService.getGoodsById(gid);
        orders.setSid(goods.getUid());
        ordersService.addOrder(orders);
        List<Integer> gids = new ArrayList<Integer>();
        List<Integer> nums = new ArrayList<Integer>();
        gids.add(gid);
        nums.add(num);
        System.out.println(num);
        goods.setNum(goods.getNum()-num);
        System.out.println(goods.getNum());
        goodsService.updateGoods(goods);
        ordersService.addOrderHasGoods(orders.getOid(), gids, nums);
        receivers.setUid(user.getUid());
        receiversService.addReceiver(receivers);
        model.addAttribute("payType",payType);
        model.addAttribute("totalcost",totalcost);
        model.addAttribute("order",orders);
        model.addAttribute("receiver",receivers);
        return "order_submit2";
    }

    @RequestMapping("/listByUser")
    public ModelAndView view_by_user(ModelAndView mv, HttpSession session){
        if(session.getAttribute("user")==null){
            mv.setViewName("redirect:/user/toLogin");
            return mv;
        }
        Users user = (Users) session.getAttribute("user");
        List<Orders> orders = ordersService.getOrderByUserId(user.getUid());
        List<String> date = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(Orders order:orders){
            date.add(formatter.format(order.getTime()));
        }
        mv.addObject("date",date);
        mv.addObject("orders",orders);
        mv.setViewName("order_list");
        return mv;
    }

    @RequestMapping("/listById")
    public ModelAndView view_order_by_id(ModelAndView mv, int id){
        Orders orders = ordersService.getOrder(id);
        List<Orders> ordersList = new ArrayList<Orders>();
        ordersList.add(orders);
        List<String> date = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(Orders order:ordersList){
            date.add(formatter.format(order.getTime()));
        }
        mv.addObject("date",date);
        mv.addObject("orders",ordersList);
        mv.setViewName("order_list");
        return mv;
    }

    @RequestMapping("/listByTimeAndState")
    public ModelAndView view_order_by_time_and_state(ModelAndView mv, HttpSession session, Date begin, Date end, int state){
        Users user = (Users) session.getAttribute("user");
        List<Orders> orders = ordersService.getOrderByUidAndDateAndState(user.getUid(),begin,end,state);
        mv.addObject("orders",orders);
        mv.setViewName("listByTimeAndState_view");
        return mv;
    }

    @RequestMapping("/listBySaler")
    public ModelAndView view_order_by_saler(ModelAndView mv, HttpSession session){
        Users user = (Users)session.getAttribute("user");
        if(user==null||(user!=null&&user.getGroupid()!=1)){
            mv.setViewName("redirect:/user/toLogin");
        }
        List<Orders> orders = ordersService.getOrderBySalerId(user.getUid());
        List<String> status = new ArrayList<String>();
        status.add("未支付");
        status.add("已支付");
        status.add("卖家已接受");
        status.add("卖家已拒绝");
        status.add("买家已取消");
        List<String> date = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(Orders order:orders){
            date.add(formatter.format(order.getTime()));
        }
        mv.addObject("date",date);
        session.setAttribute("status",status);
        mv.addObject("orders",orders);
        mv.setViewName("saler/order_list");
        return mv;
    }




}
