package com.hhw.controller;
import com.hhw.beans.*;
import com.hhw.dto.CartListDTO;
import com.hhw.service.*;
import com.hhw.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

@Controller
@RequestMapping("/user")
public class UsersAction {

    @Autowired
    private UsersService userService = null;
    @Autowired
    private GroupService groupService =null;
    @Autowired
    private OrdersService ordersService = null;
    @Autowired
    private GoodsService goodsService = null;
    @Autowired
    private ShopcartsService shopcartsService = null;
    @Autowired
    private ReceiversService receiversService = null;

    /**
     *   * 生成验证码
     *   * @param request
     *   * @param response
     *   * @throws IOException
     *  
     */
    @RequestMapping("/getcode")
    public String code(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws IOException {
        int IMG_HEIGHT = 100;
        int IMG_WIDTH = 40;
// 用于绘制图片，设置图片的长宽和图片类型（RGB)
        BufferedImage bi = new BufferedImage(IMG_HEIGHT, IMG_WIDTH, BufferedImage.TYPE_INT_RGB);
// 获取绘图工具
        Graphics graphics = bi.getGraphics();
        graphics.setColor(new Color(180, 200, 200)); // 使用RGB设置背景颜色
        graphics.fillRect(0, 0, 100, 40); // 填充矩形区域
// 验证码中所使用到的字符
        char[] codeChar = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789".toCharArray();
        String captcha = ""; // 存放生成的验证码
        Random random = new Random();
        for (int i = 0; i < 4; i++) { // 循环将每个验证码字符绘制到图片上
            int index = random.nextInt(codeChar.length);
            graphics.setFont(new Font("黑体", Font.BOLD, 20));
            // 随机生成验证码颜色
            graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            // 将一个字符绘制到图片上，并制定位置（设置x,y坐标）
            graphics.drawString(codeChar[index] + "", (i * 20) + 15, 30);
            captcha += codeChar[index];
        }
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(IMG_HEIGHT);
            int y = random.nextInt(IMG_WIDTH);
            int xl = random.nextInt(20);
            int yl = random.nextInt(20);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        // 将生成的验证码code放入session中
        request.getSession().setAttribute("code", captcha);
        System.out.println(captcha);
        BASE64Encoder encoder = new BASE64Encoder();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//IO流
        ImageIO.write(bi,"png",baos);//写入流中
        byte[] bytes = baos.toByteArray();
        String png_base64 = encoder.encodeBuffer(bytes).trim();
        png_base64 = png_base64.replace("\n","").replace("\r","");
        String codeSource = "data:image/png;base64,"+png_base64;
        model.addAttribute("codeSource",codeSource);
        if(session.getAttribute("codemsg")!=null&&session.getAttribute("msg")!=null){
            String codemsg = (String)session.getAttribute("codemsg");
            String msg = (String)session.getAttribute("msg");
            model.addAttribute("codemeg",codemsg);
            model.addAttribute("msg",msg);
        }
        return "login";
    }

    /**
     * 进行登陆操作 判断当前的用户名和密码是否正确，如果验证正确还需要将
     * 用户信息存放在session里面
     * @return 返回对应result
     */
    @RequestMapping(value = "/login", method= RequestMethod.POST)
    public String login(String name, String password, int groupid, String code, HttpSession session,
                        HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException, Exception{
        password = MD5Util.EncoderByMd5(password);
        Users user = userService.findUser2(name, password,groupid);
        String Code = (String) session.getAttribute("code");
        code = code.toLowerCase();
        Code = Code.toLowerCase();
        if(!code.equals(Code)){
            session.setAttribute("codemsg","验证码错误!");
            session.setAttribute("msg","");
           return "redirect:/user/toLogin";
        }

            if (user == null || user.getStatus() == 2) {
                session.setAttribute("msg","用户名或密码错误!");
                session.setAttribute("codemsg","");
                return "redirect:/user/toLogin";
            }

            else {
                session.setAttribute("codemsg","");
                session.setAttribute("msg","");
                user.setStatus(1);
                userService.updateStatus(user.getUid(), user.getStatus());
                session.setAttribute("user", user);

//                if(session.getAttribute("is_paying")!=null) {
//                    int is_paying = (int)session.getAttribute("is_paying");
//                    //System.out.println(is_paying);
//                    if (is_paying == 1) {
//                        List<Integer> gid = (List<Integer>) session.getAttribute("gid_list");
//                        List<Integer> num = (List<Integer>) session.getAttribute("num_list");
//                        user.setIs_paying(0);
//                        double discount = user.getDiscount();
//                        List<Double> cost = new <Double>ArrayList();
//                        List<Goods> goodses = new <Goods>ArrayList();
//                        double totalcost = 0;
//
//                        for (int i = 0; i < gid.size(); i++) {
//                            Goods goods = goodsService.getGoodsById(gid.get(i));
//                            goods.setPrice(goods.getPrice()*discount);
//                            goodses.add(goods);
//                            double tmp =  goods.getPrice() * (num.get(i));
//                            BigDecimal bg = new BigDecimal(tmp);
//                            double tmp1 = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
//                            cost.add(tmp1);
//                            totalcost += tmp1;
//                        }
//                        model.addAttribute("cost", cost);
//                        model.addAttribute("totalcost", totalcost);
//                        model.addAttribute("goodses", goodses);
//                        model.addAttribute("num", num);
//                        session.setAttribute("is_paying",0);
//                        return "add_info";
//                    } else if (is_paying == 2) {
//                        int gid = (int) session.getAttribute("gid");
//                        int num = (int) session.getAttribute("num");
//                        Goods goods = goodsService.getGoodsById(gid);
//                        goods.setPrice(goods.getPrice() * user.getDiscount());
//                        double cost = num * goods.getPrice();
//                        BigDecimal bg = new BigDecimal(cost);
//                        double cost1 = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
//                        model.addAttribute("goods", goods);
//                        model.addAttribute("num", num);
//                        model.addAttribute("cost", cost1);
//                        session.setAttribute("is_paying",0);
//                        return "add_info2";
//                    }
//                }
                String jsp = groupService.getJspByGroupid(user.getGroupid());
                return jsp;

            }

    }

    @RequestMapping(value = "/login2", method= RequestMethod.POST)
    public String login2(String name, String password,  HttpSession session,
                         Model model) throws Exception{
        if(session.getAttribute("user")==null)
            return "redirect:/user/toLogin";
        password = MD5Util.EncoderByMd5(password);
        System.out.println(name);
        Users user_login = userService.findUser(name, password);
        if (user_login == null || user_login.getStatus() == 2) {
            session.setAttribute("msg","用户名或密码错误!");
            session.setAttribute("codemsg","");
            return "login2";
        }
        Users user = (Users)session.getAttribute("user");
        int is_paying = (int)session.getAttribute("is_paying");
        if (is_paying == 1) {
            List<Integer> gid = (List<Integer>) session.getAttribute("gid_list");
            List<Integer> num = (List<Integer>) session.getAttribute("num_list");
            user.setIs_paying(0);
            double discount = user.getDiscount();
            List<Double> cost = new <Double>ArrayList();
            List<Goods> goodses = new <Goods>ArrayList();
            double totalcost = 0;

            for (int i = 0; i < gid.size(); i++) {
                Goods goods = goodsService.getGoodsById(gid.get(i));
                double tt = goods.getPrice()*discount;
                BigDecimal ak = new BigDecimal(tt);
                double tt1 = ak.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                goods.setPrice(tt1);
                goodses.add(goods);
                double tmp =  goods.getPrice() * (num.get(i));
                BigDecimal bg = new BigDecimal(tmp);
                double tmp1 = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                cost.add(tmp1);
                totalcost += tmp1;
            }
            BigDecimal bk = new BigDecimal(totalcost);
            totalcost = bk.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            Receivers receivers = receiversService.getFirstReceiver(user.getUid());
            model.addAttribute("receiver", receivers);
            model.addAttribute("cost", cost);
            model.addAttribute("totalcost", totalcost);
            model.addAttribute("goodses", goodses);
            model.addAttribute("num", num);
            //model.addAttribute("gidList", gid);
            session.setAttribute("is_paying",0);
            return "add_info";
        } else if (is_paying == 2) {
            int gid = (int) session.getAttribute("gid");
            int num = (int) session.getAttribute("num");
            user.setIs_paying(0);
            Goods goods = goodsService.getGoodsById(gid);
            double tt = goods.getPrice()*user.getDiscount();
            BigDecimal ak = new BigDecimal(tt);
            double tt1 = ak.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            goods.setPrice(tt1);
            double cost = num * goods.getPrice();
            BigDecimal bg = new BigDecimal(cost);
            double cost1 = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            Receivers receivers = receiversService.getFirstReceiver(user.getUid());
            model.addAttribute("receiver", receivers);
            model.addAttribute("goods", goods);
            model.addAttribute("num", num);
            model.addAttribute("cost", cost1);
            session.setAttribute("is_paying",0);
            return "add_info2";
        }
        return null;
    }
    /**
     * 用户登出
     * @return 返回登录界面
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        if(user==null)
            return "redirect:/user/toLogin";
        user.setStatus(0); // status=0表示不在线
        userService.updateStatus(user.getUid(), user.getStatus());
        session.removeAttribute("user"); // 清空session
        session.invalidate();
        //System.out.println("用户退出了!");
        return "redirect:/index";
    }

    /**
     * 用户尝试结账
     */
    @RequestMapping("/try_pay")
    public String try_pay(HttpSession session, CartListDTO cartListDTO, Model model){
        if(session.getAttribute("user")==null)
            return "redirect:/user/toLogin";
        Users user = (Users) session.getAttribute("user");
        session.setAttribute("is_paying",1);
        //user.setIs_paying(1);
        List<Integer> gid_list = new ArrayList<Integer>();
        List<Integer> num_list = new ArrayList<Integer>();
        List<CartHasGoods> cart_list = cartListDTO.getCartList();
        for(CartHasGoods cart: cart_list){
            gid_list.add(cart.getGid());
            num_list.add(cart.getNum());
            shopcartsService.editNum(cart.getId(),cart.getNum());
            //System.out.println(cart.getGid());
        }
        int flag = 0;
        List<String> msg = new ArrayList<>();
        for(int i = 0; i<gid_list.size();i++){
            if(goodsService.getGoodsById(gid_list.get(i)).getNum()< num_list.get(i)){
                msg.add("商品库存不足");
                flag = 1;
            }
            else{
                msg.add("");
            }
        }
        if(flag==1){
            List<Goods> goodses = new <Goods>ArrayList();
            for(int i = 0; i<gid_list.size();i++){
                goodses.add(goodsService.getGoodsById(gid_list.get(i)));
            }
            model.addAttribute("msg",msg);
            model.addAttribute("goodsList",goodses);
            model.addAttribute("numList",num_list);
            List<CartHasGoods> cartHasGoodsList = shopcartsService.getCartsByUserId(user.getUid());
            model.addAttribute("cartList",cartHasGoodsList);
            return "shopCarts";
        }
        if(session.getAttribute("gid_list")!=null)
            session.removeAttribute("gid_list");
        session.setAttribute("gid_list",gid_list);
        if(session.getAttribute("num_list")!=null)
            session.removeAttribute("num_list");
        session.setAttribute("num_list", num_list);
        //return "redirect:/user/toLogin";
        return "login2";
    }

    @RequestMapping("/try_pay_one")
    public String try_pay_one(HttpSession session, int gid, int num, Model model){
        if(session.getAttribute("user")==null)
            return "redirect:/user/toLogin";
        Users user = (Users) session.getAttribute("user");
        if(num>goodsService.getGoodsById(gid).getNum()){
            model.addAttribute("numMsg","该商品库存不足");
            Goods goods = goodsService.getGoodsById(gid);
            double tmp = goods.getPrice()*user.getDiscount();
            BigDecimal bd = new BigDecimal(tmp);
            double tmp1 = bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            goods.setPrice(tmp1);
            model.addAttribute("goods",goods);
            return "goods_view";
        }

        //user.setIs_paying(2);
        session.setAttribute("is_paying",2);
        int is_paying = (int)session.getAttribute("is_paying");
        //System.out.println(is_paying);
        if(session.getAttribute("gid")!=null)
            session.removeAttribute("gid");
        session.setAttribute("gid",gid);
        if(session.getAttribute("num")!=null)
            session.removeAttribute("num");
        session.setAttribute("num", num);
        //return "redirect:/user/toLogin";
        return "login2";
    }

    @RequestMapping("/updateUser")
    public String updateUser(HttpSession session, Users user) throws Exception
    {
        if(session.getAttribute("user")==null)
            return "redirect:/user/toLogin";
        user.setPassword(MD5Util.EncoderByMd5(user.getPassword()));
        userService.updateUser(user);
        return "redirect:/index";
    }

    @RequestMapping("/userRegister")
    public String userRegister(Users user) throws Exception{
        user.setIs_paying(0);
        user.setStatus(0);
        double discount = 0.6+0.4*Math.random();
        int dis = (int)(100*discount);
        double dis1 = (double) dis;
        dis1 = dis1/100.0;
        user.setDiscount(dis1);
        user.setPassword(MD5Util.EncoderByMd5(user.getPassword()));
        //userService.updateUser(user);
        userService.addUsers(user);
        return "redirect:/index";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "redirect:/user/getcode";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(HttpSession session, Model model){
        if(session.getAttribute("user")==null)
            return "redirect:/user/toLogin";
        Users user = (Users)session.getAttribute("user");
        model.addAttribute("users",user);
        return "user_update";
    }

    @RequestMapping("toRegister")
    public String toRegister(){
        return "user_register";
    }

    @RequestMapping("payForOrder")
    public String payForOrder(int oid){
        ordersService.editState(1,oid);
        return "redirect:/order/listByUser";
    }

    @RequestMapping("deleteOrder")
    public String deleteOrder(int oid){
        //ordersService.deleteOrder(oid);
        ordersService.editState(4,oid);
        return "redirect:/order/listByUser";
    }

}

