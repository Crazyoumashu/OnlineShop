package com.hhw.controller;

import com.hhw.beans.Goods;
import com.hhw.beans.Orders;
import com.hhw.beans.Users;
import com.hhw.service.GoodsService;
import com.hhw.service.OrdersService;
import com.hhw.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/saler")
public class SalersAction {
    @Autowired
    GoodsService goodsService = null;
    @Autowired
    OrdersService ordersService = null;

    @RequestMapping("/goodsList")
    public ModelAndView goodsList(ModelAndView mv, HttpSession session){
        Users users = (Users)session.getAttribute("user");
        if(users==null||(users!=null&&users.getGroupid()!=1)){
            mv.setViewName("redirect:/user/toLogin");
            return mv;
        }
        List<Goods> goods_list = goodsService.getGoodsByUid(users.getUid());
        mv.addObject("goods_list", goods_list);
        mv.setViewName("saler/goods_list");
        return mv;
    }

    @RequestMapping("/view")
    public ModelAndView view(HttpSession session, int goodsId, ModelAndView mv){
        Users users = (Users)session.getAttribute("user");
        if(users==null||(users!=null&&users.getGroupid()!=1)){
            mv.setViewName("redirect:/user/toLogin");
            return mv;
        }
        Goods goods = goodsService.getGoodsById(goodsId);
        mv.addObject("goods", goods);
        mv.setViewName("goods_view");
        return mv;
    }

    @RequestMapping("/jumpUpdateGoods")
    public String jumpUpdateGoods(HttpSession session, int goodsId, Model model){
        Users users = (Users)session.getAttribute("user");
        if(users==null||(users!=null&&users.getGroupid()!=1)){
            return "redirect:/user/toLogin";
        }
        Goods goods = goodsService.getGoodsById(goodsId);
        System.out.println(goods.getThumbnail());
        model.addAttribute("goods",goods);
        return "/saler/goods_update";
    }
    @RequestMapping("/updateGoods")
    public String updateGoods(int gid, String name, float price, String thumbnail, int num, String described,
                              HttpServletRequest request, MultipartFile pic, HttpSession session)throws IllegalStateException, IOException {
        Users users = (Users)session.getAttribute("user");
        if(users==null||(users!=null&&users.getGroupid()!=1)){
            return "redirect:/user/toLogin";
        }
        Goods goods = goodsService.getGoodsById(gid);
        //System.out.println(pic.getOriginalFilename());
        if(pic.getOriginalFilename()!=""){
            System.out.println("图片不为空");
            String FILE_TARGET = "target";
            String basePath = request.getSession().getServletContext().getRealPath("/");
            System.out.println(basePath);
            //basePath = basePath.substring(0,basePath.lastIndexOf(FILE_TARGET));
            String dir = basePath + "goodsimage/";
            String path = basePath;
            System.out.println(basePath);
            System.out.println(dir);

            //新图片的名称
            String originFileName = pic.getOriginalFilename();
            String newFileName = ShopUtil.getId()+originFileName.substring(originFileName.lastIndexOf("."));
            //新图片
            File newFile = new File(dir + newFileName);
            //将内存中的数据写入磁盘
            pic.transferTo(newFile);
            goods.setThumbnail(newFileName);
        }
        goods.setName(name);
        goods.setPrice(price);
        goods.setNum(num);
        goods.setDescribed((described));
        goodsService.updateGoods(goods);
        return "saler/index";
    }

    @RequestMapping("/acceptOrder")
    public String acceptOrder(HttpSession session, int oid){
        Users users = (Users)session.getAttribute("user");
        if(users==null||(users!=null&&users.getGroupid()!=1)){
            return "redirect:/user/toLogin";
        }
        int state = 2;
        if(ordersService.getOrder(oid).getState()!=4)
        ordersService.editState(state,oid);
        return "redirect:/order/listBySaler";
    }

    @RequestMapping("/rejectOrder")
    public String rejectOrder(HttpSession session, int oid){
        Users users = (Users)session.getAttribute("user");
        if(users==null||(users!=null&&users.getGroupid()!=1)){
            return "redirect:/user/toLogin";
        }
        int state = 3;
        if(ordersService.getOrder(oid).getState()!=4)
        ordersService.editState(state,oid);
        return "redirect:/order/listBySaler";
    }

    @RequestMapping("/toIndex")
    public String toIndex(HttpSession session){
        Users users = (Users)session.getAttribute("user");
        if(users==null||(users!=null&&users.getGroupid()!=1)){
            return "redirect:/user/toLogin";
        }
        return "saler/index";
    }
}
