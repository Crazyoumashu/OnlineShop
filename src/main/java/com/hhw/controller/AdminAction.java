package com.hhw.controller;

import com.hhw.beans.Users;
import com.hhw.service.UsersService;
import com.hhw.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    private UsersService usersService = null;
    @RequestMapping("/viewUser")
    ModelAndView view_user(ModelAndView mv, HttpSession session){
        Users user = (Users)session.getAttribute("user");
        if(user==null||(user!=null&&user.getGroupid()!=2)){
            mv.setViewName( "redirect:/user/toLogin");
            return mv;
        }
        List<Users> users = usersService.getAllUser();
        mv.addObject("users",users);
        mv.setViewName("admin/view_user");
        return mv;
    }

    @RequestMapping("jumpAddUser")
    String jumpAddUser(HttpSession session){
        Users user = (Users)session.getAttribute("user");
        if(user==null||(user!=null&&user.getGroupid()!=2)){
            return "redirect:/user/toLogin";
        }
        return "/admin/add_user";
    }
    @RequestMapping("/addUser")
    String addUser(Users user, HttpSession session) throws Exception{
        Users users = (Users)session.getAttribute("user");
        if(users==null||(users!=null&&users.getGroupid()!=2)){
            return "redirect:/user/toLogin";
        }
        user.setPassword(MD5Util.EncoderByMd5(user.getPassword()));
        usersService.addUsers(user);
        return "redirect:viewUser";
    }

    @RequestMapping("/deleteUser")
    String deleteUser(int uid, HttpSession session){
        Users users = (Users)session.getAttribute("user");
        if(users==null||(users!=null&&users.getGroupid()!=2)){
            return "redirect:/user/toLogin";
        }
        usersService.deleteUser(uid);
        return "redirect:viewUser";
    }

    @RequestMapping("/jumpUserUpdate")
    String jumpUserUpdate(int uid, Model model, HttpSession session){
        Users user = (Users)session.getAttribute("user");
        if(user==null||(user!=null&&user.getGroupid()!=2)){
            return "redirect:/user/toLogin";
        }
        Users users = usersService.getUser(uid);
        model.addAttribute("users", users);
        return "/admin/update_user";
    }
    @RequestMapping("/updateUser")
    String updateUser(Users user, HttpSession session) throws Exception{
        Users users = (Users)session.getAttribute("user");
        if(users==null||(users!=null&&users.getGroupid()!=2)){
            return "redirect:/user/toLogin";
        }
        System.out.println(user.getUid());
        user.setPassword(MD5Util.EncoderByMd5(user.getPassword()));
        usersService.updateUser(user);
        return "redirect:viewUser";
    }

    @RequestMapping("/toIndex")
    String toIndex(HttpSession session){
        Users user = (Users)session.getAttribute("user");
        if(user==null||(user!=null&&user.getGroupid()!=2)){
            return "redirect:/user/toLogin";
        }
        return "admin/index";
    }
}
