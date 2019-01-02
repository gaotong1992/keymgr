package com.kkx.user.web;

import com.kkx.user.service.kkxuserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserWeb {


    @Autowired(required = false)
    private kkxuserMapper kkxusermapper;


    @RequestMapping("/login")
    public ModelAndView userLogin(@RequestParam(value = "username",required = true)String _uname, @RequestParam(value = "pwd",required = true)String _pwd, ModelAndView _mav){

        System.out.println("****************************");
        System.out.println(_uname);
        System.out.println(_pwd);
        kkxusermapper.selectByPrimaryKey(1l);

        _mav.setViewName("manager");

        return _mav;
    }



}
