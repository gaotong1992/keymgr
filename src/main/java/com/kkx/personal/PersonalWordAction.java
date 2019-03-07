package com.kkx.personal;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkx.user.bean.kkxuser;
import com.kkx.user.service.kkxuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 个人扩展词表管理界面
 */
@Controller
@RequestMapping(value = "personal")
public class PersonalWordAction {

    /**
     * 用户service
     */
    @Autowired(required = false)
    private kkxuserMapper kkxusermapper;



    /**
     * 链接到个人扩展词表界面
     * @param _session
     * @param _mav
     * @return
     */
    @RequestMapping(value = "linkpersonalwordmanager")
    public ModelAndView linkPersonalWordManager(HttpSession _session,ModelAndView _mav){

        _mav.setViewName("personal/personal");
        return  _mav;
    }


    /**
     * 个人扩展词表
     * 用户列表页
     * @param _session
     * @param _mav
     * @return
     */
    @RequestMapping(value = "userlist")
    public ModelAndView userList(HttpSession _session,ModelAndView _mav
            ,@RequestParam(value = "pagesize")Integer _pagesize){

        long pagetotalnum = 0;
        long pagezong = 0;
        //分页查询所有用户信息
        PageHelper.startPage(_pagesize,15);
        List<kkxuser> userlist = this.kkxusermapper.selectKkxuserlist();
        PageInfo<kkxuser> pageInfo = new PageInfo<kkxuser>(userlist);
        if(userlist!=null){
            pagetotalnum = pageInfo.getTotal();
        }
        if(pagetotalnum%15==0){
            pagezong = pagetotalnum/15;
        }else{
            pagezong = pagetotalnum/15+1;
        }

        _mav.addObject("userlist",pageInfo.getList());
        _mav.addObject("pagenum",_pagesize);
        _mav.addObject("pagesize",15);
        _mav.addObject("pagezong",pagezong);



        _mav.setViewName("personal/userlist");
        return  _mav;
    }



}
