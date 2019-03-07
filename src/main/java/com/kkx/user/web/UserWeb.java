package com.kkx.user.web;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkx.user.bean.kkxuser;
import com.kkx.user.service.kkxuserMapper;
import com.kkx.userauth.bean.userauth;
import com.kkx.userauth.bean.userauthExample;
import com.kkx.userauth.service.userauthMapper;
import com.kkx.util.ActionUtil;
import com.kkx.word.bean.kkxword;
import com.kkx.word.bean.kkxwordExample;
import com.kkx.word.service.kkxwordMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@Controller
public class UserWeb {


    @Autowired(required = false)
    private kkxuserMapper kkxusermapper;

    @Autowired(required = false)
    private userauthMapper userauthmapper;

    @Autowired
    private kkxwordMapper kkxwordmapper;

    /**
     * 用户登陆
     * @param _uname
     * @param _pwd
     * @param _mav
     * @param _session
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView userLogin(@RequestParam(value = "username",required = true)String _uname, @RequestParam(value = "pwd",required = true)String _pwd, ModelAndView _mav,HttpSession _session){
        int msg = 0;
        if((!_uname.equals("")) && (!_pwd.equals(""))){
            List<kkxuser> list = null;

            Map<String,String> map = new HashMap<String,String>();
            map.put("username",_uname);
            String jpwd = DigestUtils.md5DigestAsHex(_pwd.getBytes());
            map.put("userpwd",jpwd);
            list = kkxusermapper.selectKkxUserByUnameByUpwd(map);
            if(list!=null && list.size()==1){
                kkxuser kuser =  list.get(0);
                //登陆成功
/*                if(kuser.getUsertype()==kkxuser.TYPEGUANLIYUAN && kuser.getUserstatus()==kkxuser.STATUSZHENGCHANG){

                    _session.setAttribute("user",kuser); //用户对象加入session
                    msg = 1;
                }*/
                if(kuser.getUserstatus()==kkxuser.STATUSZHENGCHANG){

                    _session.setAttribute("user",kuser); //用户对象加入session
                    msg = 1;
                }

            }
        }


        if(msg==1){
            //正常状态下的管理员
            _mav.setViewName("index");



        }else{

            //其它页面
            _mav.setViewName("index");
        }
        return _mav;
    }

    /**
     * 注销用户
     */
    @RequestMapping(value = "out")
    public void out(HttpServletResponse _response,HttpSession _session){

        _session.removeAttribute("user");
        try {
            _response.sendRedirect("login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 首页
     * @param _mav
     * @return
     */
    @RequestMapping("linkindex")
    public ModelAndView linkIndex(ModelAndView _mav){



        int num1 = 0;
        int num2 = 0;

        num1 = this.kkxwordmapper.getCountByWordType(kkxword.WORDTYPECLIENT1);

        num2 = this.kkxwordmapper.getCountByWordType(kkxword.WORDTYPECLIENT2);

        _mav.addObject("client1",""+num1);
        _mav.addObject("client2",""+num2);

        _mav.setViewName("index/content");
        return _mav;
    }

    /**
     * 用户页面
     * @param _mav
     * @return
     */
    @RequestMapping("linkusermanager")
    public ModelAndView linkUserManager(ModelAndView _mav,@RequestParam(value = "pagesize")Integer _pagesize){

        long pagezong = 0;
        long pagetotalnum = 0;
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


        List<List<userauth>> listauth = new LinkedList<>();

        if(pageInfo.getList()!=null && pageInfo.getList().size()>0){
            for (int i =0;i<pageInfo.getList().size();i++){
                kkxuser userkkx = pageInfo.getList().get(i);
                Long userid = userkkx.getUserid();

                userauthExample example = new userauthExample();
                example.createCriteria().andUseridEqualTo(userid);
                List<userauth> authslist = this.userauthmapper.selectByExample(example);
                listauth.add(authslist);
            }
        }

        _mav.addObject("listauth",listauth);


        _mav.setViewName("user/usermanager");
        return _mav;
    }


    /**
     * 增加普通用户
     * @param _response
     * @param _uname
     * @param _userpwd
     * @param _userdanwei
     * @param _usermobile
     * @param _useremail
     * @param _usernote
     */
    @RequestMapping(value = "normaluseradd")
    @ResponseBody
    public void userAdd(HttpServletResponse _response,
                        HttpSession _session,
                        @RequestParam(value = "username",required = false)String _uname,
                        @RequestParam(value = "userpwd",required = false)String _userpwd,
                        @RequestParam(value = "userdanwei",required = false)String _userdanwei,
                        @RequestParam(value = "usermobile",required = false)String _usermobile,
                        @RequestParam(value = "useremail",required = false)String _useremail,
                        @RequestParam(value = "usernote",required = false)String _usernote,
                        @RequestParam(value = "userauth",required = false)String[] _userauth){


        int msg = 0;
        //组织数据
        Long userid = this.kkxusermapper.selectKkxUserOfNextCateid();
        if((!_uname.equals("")) && (!_userpwd.equals(""))){
            kkxuser kkxuserobj = new kkxuser();
            kkxuserobj.setUseruuid(UUID.randomUUID().toString());
            kkxuserobj.setUserid(userid);
            kkxuserobj.setUsername(_uname);
            kkxuserobj.setUserpwd(DigestUtils.md5DigestAsHex(_userpwd.getBytes()));
            kkxuserobj.setUserstatus(kkxuser.STATUSZHENGCHANG);
            kkxuserobj.setUsertype(kkxuser.TYPEPUTONG);

            kkxuserobj.setUseraddress(_userdanwei);
            kkxuserobj.setUsermobile(_usermobile);
            kkxuserobj.setUseremail(_useremail);
            kkxuserobj.setUserdesc(_usernote);

            kkxuserobj.setCrtime(Calendar.getInstance().getTime());
            kkxuser loginuser = (kkxuser) _session.getAttribute("user");
            kkxuserobj.setCruserid(loginuser.getUserid());


            if(_userauth!=null && _userauth.length>0){
                //增加权限信息
                if(_userauth!=null && _userauth.length>0){
                    for (int i =0;i<_userauth.length;i++){
                        Long authid = userauthmapper.getNextIdByUserAuth();
                        userauth uauth = new userauth();
                        uauth.setUserauthid(authid);
                        uauth.setAuthtype(userauth.AUTHTYPE);
                        uauth.setUserid(userid);
                        uauth.setAuthid(Integer.valueOf(_userauth[i].toString()));
                        uauth.setCrtime(Calendar.getInstance().getTime());
                        uauth.setCruserid(loginuser.getUserid());
                        this.userauthmapper.insertSelective(uauth);
                    }
                }

            }
            msg = this.kkxusermapper.insertSelective(kkxuserobj);

        }

        ActionUtil.write(""+msg,_response);

    }


    /**
     * 根据id删除用户
     * @param _userid
     */
    @RequestMapping(value = "deluser")
    @ResponseBody
    public void delUser(@RequestParam(value = "userid")Long _userid,HttpServletResponse _response){

        int typemsg = 0;
        if(_userid!=null){
            //1删除用户
            typemsg = this.kkxusermapper.deleteByPrimaryKey(_userid);
            //2删除用户对应的权限
            if (typemsg==1){
                userauthExample example = new userauthExample();
                example.createCriteria().andUseridEqualTo(_userid);
                this.userauthmapper.deleteByExample(example);
            }
        }
        ActionUtil.write(""+typemsg,_response);
    }



    /**
     * 根据id查询用户
     * @param _userid
     */
    @RequestMapping(value = "updateuser")
    @ResponseBody
    public void updateUser(@RequestParam(value = "userid")Long _userid,HttpServletResponse _response){

        kkxuser user = null;
        if(_userid!=null){
            user =  this.kkxusermapper.selectByPrimaryKey(_userid);
        }

        StringBuffer sbstr = new StringBuffer();

        if (user!=null){


            StringBuffer sb2 = new StringBuffer();
            userauthExample example1 = new userauthExample();
            example1.createCriteria().andUseridEqualTo(_userid);
            List<userauth> authlist = this.userauthmapper.selectByExample(example1);
            if(authlist!=null && authlist.size()>0){
                for (int i=0;i<authlist.size();i++){
                    sb2.append(","+authlist.get(i).getAuthid());
                }
            }




            sbstr.append("{\"userid\":\""+user.getUserid()+"\"");
            sbstr.append(",\"username\":\""+user.getUsername()+"\"");
            sbstr.append(",\"authstr\":\""+sb2+"\"");
            sbstr.append(",\"useraddress\":\""+user.getUseraddress()+"\"");
            sbstr.append(",\"usermobile\":\""+user.getUsermobile()+"\"");
            sbstr.append(",\"useremail\":\""+user.getUseremail()+"\"");
            sbstr.append(",\"userdesc\":\""+user.getUserdesc()+"\"}");


            ActionUtil.write(sbstr.toString(),_response);

        }


    }

    /**
     * 执行修改用户操作
     * @param _response
     * @param _session
     * @param _uname
     * @param _userdanwei
     * @param _usermobile
     * @param _useremail
     * @param _usernote
     */
    @RequestMapping(value = "userupdateform")
    @ResponseBody
    public void  userUpdateForm(HttpServletResponse _response,
                                HttpSession _session,
                                @RequestParam(value = "userid",required = false)Long _userid,
                                @RequestParam(value = "username",required = false)String _uname,
                                @RequestParam(value = "userdanwei",required = false)String _userdanwei,
                                @RequestParam(value = "usermobile",required = false)String _usermobile,
                                @RequestParam(value = "useremail",required = false)String _useremail,
                                @RequestParam(value = "usernote",required = false)String _usernote,
                                @RequestParam(value = "userauth",required = false)String[] _userauth){

        int msg = 0;

        if (_userid!=null){

            kkxuser user = new kkxuser();
            user.setUserid(_userid);

            user.setUsername(_uname);
            user.setUseraddress(_userdanwei);
            user.setUsermobile(_usermobile);
            user.setUseremail(_useremail);
            user.setUserdesc(_usernote);
            msg = this.kkxusermapper.updateByPrimaryKeySelective(user);


            //修改权限信息
            userauthExample example = new userauthExample();
            example.createCriteria().andUseridEqualTo(_userid);
            int deltemsg = this.userauthmapper.deleteByExample(example);
            kkxuser loginuser = (kkxuser) _session.getAttribute("user");
            if (_userauth!=null && _userauth.length>0){
                for (int i =0;i<_userauth.length;i++){
                    Long authid = userauthmapper.getNextIdByUserAuth();
                    userauth uauth = new userauth();
                    uauth.setUserauthid(authid);
                    uauth.setAuthtype(userauth.AUTHTYPE);
                    uauth.setUserid(_userid);
                    uauth.setAuthid(Integer.valueOf(_userauth[i].toString()));
                    uauth.setCrtime(Calendar.getInstance().getTime());
                    uauth.setCruserid(loginuser.getUserid());
                    this.userauthmapper.insertSelective(uauth);
                }
            }





        }

        ActionUtil.write(""+msg,_response);

    }





    /**
     * 根据id查询用户
     * @param _userid
     */
    @RequestMapping(value = "updateuserpwd")
    @ResponseBody
    public void updateuserpwd(@RequestParam(value = "userid")Long _userid,HttpServletResponse _response){

        kkxuser user = null;
        if(_userid!=null){
            user =  this.kkxusermapper.selectByPrimaryKey(_userid);
        }

        StringBuffer sbstr = new StringBuffer();

        if (user!=null){
            sbstr.append("{\"userid\":\""+user.getUserid()+"\"");
            sbstr.append(",\"username\":\""+user.getUsername()+"\"}");
            ActionUtil.write(sbstr.toString(),_response);
        }


    }

    /**
     * 用户修改密码
     * @param _response
     * @param _session
     * @param _userid
     * @param _uname
     * @param _userpwd
     * @param _userpwd2
     */
    @RequestMapping(value = "userupdateformpwd")
    @ResponseBody
    public void userupdateformpwd(HttpServletResponse _response,
                                  HttpSession _session,
                                  @RequestParam(value = "userid",required = false)Long _userid,
                                  @RequestParam(value = "username",required = false)String _uname,
                                  @RequestParam(value = "userpwd",required = false)String _userpwd,
                                  @RequestParam(value = "userpwd2",required = false)String _userpwd2){


            int msg = 0;
            kkxuser user = new kkxuser();
            user.setUserid(_userid);
            String jpwd = DigestUtils.md5DigestAsHex(_userpwd.getBytes());
            user.setUserpwd(jpwd);


            msg = this.kkxusermapper.updateByPrimaryKeySelective(user);



            ActionUtil.write(""+msg,_response);

    }


}
