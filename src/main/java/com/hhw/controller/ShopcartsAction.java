package com.hhw.controller;

import com.hhw.beans.CartHasGoods;
import com.hhw.beans.Goods;
import com.hhw.beans.Users;
import com.hhw.service.GoodsService;
import com.hhw.service.ShopcartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shopcarts")
public class ShopcartsAction {
    @Autowired
    private ShopcartsService shopcartsService = null;
    @Autowired
    private GoodsService goodsService = null;

    @RequestMapping("/delete")
    String delete(int gid, HttpSession session, Model model){
        Users user = (Users)session.getAttribute("user");
        if(user==null){
            return "redirect:/user/toLogin";
        }
        int uid = user.getUid();
        shopcartsService.deleteById(uid,gid);
        List<Goods> goodsList = new <Goods>ArrayList();
        List<Integer> numList = new <Integer>ArrayList();
        List<String> msg = new ArrayList<>();
        List<CartHasGoods> cartHasGoodsList = shopcartsService.getCartsByUserId(user.getUid());
        for(CartHasGoods cart:cartHasGoodsList){
            goodsList.add(goodsService.getGoodsById(cart.getGid()));
            numList.add(cart.getNum());
            msg.add("");
        }
        model.addAttribute("numList",numList);
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("cartList",cartHasGoodsList);
        model.addAttribute("msg",msg);
        return "shopCarts";
    }

    @RequestMapping("/editNum")
    String editNum(int num, int id, HttpSession session){
        Users user = (Users)session.getAttribute("user");
        if(user==null){
            return "redirect:/user/toLogin";
        }
        shopcartsService.editNum(id,num);
        return "shopCarts";
    }

    @RequestMapping("/addCarts")
    String addCarts(int gid, int num, HttpSession session, Model model){
        Users user = (Users)session.getAttribute("user");
        if(user==null){
            return "redirect:/user/toLogin";
        }
        if(shopcartsService.getShopcarts(user.getUid())==null)
            shopcartsService.addShopcart(user.getUid());
        System.out.println(shopcartsService.getShopcarts(user.getUid()).getScid());
        CartHasGoods cartHasGoods = new CartHasGoods();
        cartHasGoods.setNum(num);
        cartHasGoods.setGid(gid);
        cartHasGoods.setUid(user.getUid());
        cartHasGoods.setScid(shopcartsService.getShopcarts(user.getUid()).getScid());
        shopcartsService.addCart(cartHasGoods);
        System.out.println(gid);
        Goods goods = goodsService.getGoodsById(gid);
        double price = goods.getPrice()*user.getDiscount();
        BigDecimal bg = new BigDecimal(price);
        double price1 = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        goods.setPrice(price1);
        model.addAttribute("goods",goods);
        return "goods_view";
    }

    @RequestMapping("/listCarts")
    ModelAndView listCarts(ModelAndView mv, HttpSession session){
        if(session.getAttribute("user")==null){
            mv.setViewName("redirect:/user/toLogin");
            return mv;
        }
        Users user = (Users)session.getAttribute("user");
        List<Goods> goodsList = new <Goods>ArrayList();
        List<Integer> numList = new <Integer>ArrayList();
        List<String> msg = new ArrayList<String>();
        List<CartHasGoods> cartHasGoodsList = shopcartsService.getCartsByUserId(user.getUid());
        for(CartHasGoods cart:cartHasGoodsList){
            goodsList.add(goodsService.getGoodsById(cart.getGid()));
            numList.add(cart.getNum());
            msg.add("");
        }
        mv.addObject("numList",numList);
        mv.addObject("goodsList",goodsList);
        mv.addObject("cartList",cartHasGoodsList);
        mv.addObject("msg",msg);
        mv.setViewName("shopCarts");
        return mv;
    }
}
