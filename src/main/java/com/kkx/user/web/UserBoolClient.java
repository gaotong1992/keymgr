package com.kkx.user.web;


import com.kkx.kkxuserword.bean.kkxuserword;
import com.kkx.kkxuserword.bean.kkxuserwordExample;
import com.kkx.kkxuserword.service.kkxuserwordMapper;
import com.kkx.user.bean.kkxuser;
import com.kkx.user.service.kkxuserMapper;
import com.kkx.userauth.bean.userauth;
import com.kkx.userauth.bean.userauthExample;
import com.kkx.userauth.service.userauthMapper;
import com.kkx.util.ActionUtil;
import com.kkx.word.bean.kkxword;
import com.kkx.word.bean.kkxwordExample;
import com.kkx.word.service.kkxwordMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;

/**
 * client
 * 用户认证
 */
@Controller
@RequestMapping(value = "bool")
public class UserBoolClient {

    @Autowired
    private kkxuserMapper kkxusermapper;

    @Autowired(required = false)
    private userauthMapper userauthmapper;

    @Autowired
    private kkxwordMapper kkxwordmapper;

    @Autowired
    private kkxuserwordMapper kkxuserwordmapper;


    /**
     * 验证客户端合法性
     * @param _username
     * @param _userpwd
     * @param _mac
     */
    @RequestMapping(value = "boolclient")
    @ResponseBody
    public void boolclient(@RequestParam(value = "username",required = false)String _username,
                           @RequestParam(value = "userpwd",required = false)String _userpwd,
                           @RequestParam(value = "mac",required = false)String _mac,
                           @RequestParam(value = "clienttype",required = false)Integer _clienttype,
                           HttpServletResponse _response){


        int msg = 0;
        List<kkxuser> list = null;
        Map map = new HashMap();
        map.put("username",_username);
        String jpwd = DigestUtils.md5DigestAsHex(_userpwd.getBytes());
        map.put("userpwd",jpwd);
        list = this.kkxusermapper.selectKkxUserByUnameByUpwd(map);
        if(list!=null && list.size()>0){
            kkxuser user = list.get(0);
            userauthExample example = new userauthExample();
            example.createCriteria().andUseridEqualTo(user.getUserid())
                                    .andAuthtypeEqualTo(_clienttype);
            List<userauth> authlist = userauthmapper.selectByExample(example);
            if(authlist!=null && authlist.size()>0){
                //用户有权限 更新绑定mac   先把相同的mac去掉
                Map mapmac = new HashMap();
                mapmac.put("token",_mac);
                List<kkxuser> userlistmac = this.kkxusermapper.selectKkxUserByMac(mapmac);
                if(userlistmac!=null && userlistmac.size()>0){
                    for (int i = 0; i <userlistmac.size() ; i++) {
                        kkxuser userkkx = userlistmac.get(i);
                        userkkx.setToken("");
                        this.kkxusermapper.updateByPrimaryKeySelective(userkkx);
                    }
                }


                kkxuser users = new kkxuser();
                users.setUserid(user.getUserid());
                users.setToken(_mac);
                int num =  this.kkxusermapper.updateByPrimaryKeySelective(users);
                if (num==1){
                    msg = 3;
                }



            }else{
                //用户没有权限
                msg = 2;
            }
        }else{
            //用户名或密码错误
            msg = 1;
        }
        System.out.println("      "+msg);
        ActionUtil.write(""+msg,_response);
    }


    /**
     * mac地址登陆
     * @param _macstr
     * @param _response
     */
    @RequestMapping(value = "boolmac")
    @ResponseBody
    public void boolmac(@RequestParam(value = "macstr",required = false)String _macstr,
                        HttpServletResponse _response,
                        @RequestParam(value = "clienttype",required = false)Integer _clienttype){
        String msgstr = "";
        if(_macstr!=null && (!_macstr.equals(""))){
            Map map = new HashMap();
            map.put("token",_macstr);
            List<kkxuser> userlist = this.kkxusermapper.selectKkxUserByMac(map);
            System.out.println("000000000000000000    "+userlist.size());
            if(userlist!=null && userlist.size()>0){
                kkxuser userobj = userlist.get(0);
                userauthExample example = new userauthExample();
                example.createCriteria().andUseridEqualTo(userobj.getUserid())
                        .andAuthtypeEqualTo(_clienttype);
                List<userauth> authlist = userauthmapper.selectByExample(example);

                System.out.println("000000000000000000    "+authlist.size());
                if(authlist!=null && authlist.size()>0){
                    //mac验证正常  且有权限
                    msgstr = userobj.getUsername()+"###########"+userobj.getUserpwd();
                }
            }
        }
        ActionUtil.write(""+msgstr,_response);
    }


    /**
     * 客户端用户默认登陆
     * @param _mav
     * @param _username
     * @param _pwd
     */
    @RequestMapping(value = "clientlogin")
    public ModelAndView clientLogin(ModelAndView _mav,@RequestParam(value = "clientusername")String _username,
                            @RequestParam(value = "clientpwd")String _pwd,HttpSession _session){
        int msg = 0;
        List<kkxuser> list = null;
        Map map = new HashMap();
        map.put("username",_username);
        map.put("userpwd",_pwd);
        list = this.kkxusermapper.selectKkxUserByUnameByUpwd(map);
        if(list!=null && list.size()>0) {
            kkxuser user = list.get(0);
            if(user.getUserstatus()==kkxuser.STATUSZHENGCHANG){

                _session.setAttribute("user",user); //用户对象加入session
                msg = 1;
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
     * 根据类型返回字符串集合
     * 加个人词表
     * @param _type
     * @param _response
     */
    @RequestMapping(value = "getword")
    @ResponseBody
    public void getword(@RequestParam(value = "type",required = false)String _type,
                        HttpServletResponse _response,
                        @RequestParam(value = "clienttype",required = false)Integer _clienttype,
                        @RequestParam(value = "objyx",required = false)Object _obyx){

        List<kkxword> wordlist = null;

        String str = "";

        StringBuffer sb = new StringBuffer();
        kkxwordExample example = new kkxwordExample();
        example.createCriteria().andWordcolnameEqualTo(_type)
                                .andWordtypeEqualTo(_clienttype);
        wordlist = this.kkxwordmapper.selectByExample(example);

        if(wordlist!=null && wordlist.size()>0){
            for (int i =0;i<wordlist.size();i++){
                kkxword wordobj = wordlist.get(i);
                sb.append(","+wordobj.getWordname());
            }
        }
        //获取用户个人自定义词表 根据mac获取id
        Map map = new HashMap();
        map.put("token",_obyx);
        List<kkxuser> userkkxlist = this.kkxusermapper.selectKkxUserByMac(map);

        if(userkkxlist!=null && userkkxlist.size()==1){
            Long userid = userkkxlist.get(0).getUserid();
            kkxuserwordExample example2 = new kkxuserwordExample();


            example2.createCriteria().andWorduseridEqualTo(userid).andWordtypeEqualTo(_clienttype).andWordcolnameEqualTo(_type);
            List<kkxuserword> userwordlist = kkxuserwordmapper.selectByExample(example2);
            System.out.println("#####"+userwordlist);
            if (userwordlist!=null && userwordlist.size()>0){
                for (int i = 0; i <userwordlist.size(); i++) {
                    kkxuserword userwordobj =  userwordlist.get(i);
                    System.out.println("*********"+userwordobj.getWordname());
                    sb.append(","+userwordobj.getWordname());
                }
            }
        }

        if (sb.length()>0){

            str = sb.substring(1);
            str = compressData(str);
        }




        ActionUtil.write(str,_response);




    }

    /**
     * 压缩传出到客户端的数据
     * @param data
     * @return
     */
    public static String compressData(String data) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DeflaterOutputStream zos = new DeflaterOutputStream(bos);
            zos.write(data.getBytes());
            zos.close();
            return new String(getenBASE64inCodec(bos.toByteArray()));
        } catch (Exception ex) {
            ex.printStackTrace();
            return "ZIP_ERR";
        }
    }

    //  使用apche codec对数组进行encode
    public static String getenBASE64inCodec(byte [] b) {
        if (b == null)
            return null;
        return new String((new Base64()).encode(b));
    }


}
