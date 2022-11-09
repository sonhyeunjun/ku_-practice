package com.example.kurmap.User.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kurmap.User.model.dto.UserDto;
import com.example.kurmap.User.model.service.UserService;
import com.example.kurmap.User.model.vo.UserVo;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // 로그인 페이지
    @RequestMapping("/login.do")
    public String LoignGet() {
        return "User/login";
    }

    //로그인 페이지
    @RequestMapping(value = "/loginsucces.do")
    public String LoginPost(@ModelAttribute UserDto userDto, HttpSession session, Model model){
        UserDto a = userService.memberLoginDo(userDto);
        if(a != null){
            session.setAttribute("loginId", a.getEmail());
            session.setAttribute("id", a.getId());
            return "redirect:/list.do";
        }
        else{
            return "User/login";
        }

    }
    // 회원가입 페이지
    @RequestMapping("/register.do")
    public String RegisterGet() {
        return "User/register";
    }
    
    // 회원가입 페이지
    @RequestMapping(value = "/registersave.do")
    public String RegisterPost(@ModelAttribute UserVo userVo)
    {
        UserVo vo  = new UserVo();
        vo.setEmail(vo.getEmail());
        vo.setPassword(vo.getPassword());
        userService.register(userVo);
        return "redirect:/login.do";
    }
    @RequestMapping(value = "/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.do";
    }

}
