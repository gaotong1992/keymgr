package com.kkx.kkxuserword.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkx.kkxuserword.bean.kkxuserword;
import com.kkx.kkxuserword.bean.kkxuserwordExample;
import com.kkx.kkxuserword.service.kkxuserwordMapper;
import com.kkx.user.bean.kkxuser;
import com.kkx.userauth.bean.userauth;
import com.kkx.userauth.bean.userauthExample;
import com.kkx.userauth.service.userauthMapper;
import com.kkx.util.ActionUtil;
import com.kkx.word.bean.kkxword;
import com.kkx.word.bean.kkxwordExample;
import com.kkx.word.service.kkxwordMapper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * 用户个人词表维护
 */
@Controller
@RequestMapping(value = "userword")
public class UserWordAction {



    @Autowired
    private userauthMapper userauthmapper;


    @Autowired
    private kkxuserwordMapper kkxuserwordmapper;

    @Autowired
    private kkxwordMapper kkxwordmapper;


    /**
     * 链接到用户个人词表维护首页
     * @return
     */
    @RequestMapping(value = "linkuserextendword")
    public ModelAndView linkuserextendword(ModelAndView _mav,HttpSession _session){

        //查询用户对客户端的权限
        kkxuser kkxuser = (kkxuser)_session.getAttribute("user");

        userauthExample example = new userauthExample();
        example.createCriteria().andAuthtypeEqualTo(userauth.AUTHTYPE)
                                .andUseridEqualTo(kkxuser.getUserid());
        List<userauth> userauthlist = userauthmapper.selectByExample(example);

        List<Integer> liststr = new ArrayList();

        if(userauthlist!=null && userauthlist.size()>0){
            for (int i = 0; i < userauthlist.size() ; i++) {
                liststr.add(userauthlist.get(i).getAuthid());
            }
        }


        _mav.addObject("authlist",liststr);
        _mav.setViewName("userword/personal");

        return  _mav;
    }

    /**
     * 上传用户个人词表
     * @param _request
     */
    @RequestMapping(value = "uploaduserword")
    public void uploaduserword(HttpServletRequest _request, HttpServletResponse _response,HttpSession _session,
                               @RequestParam(value = "wordtype",required = false)Integer _wordtype){


        int msg = 0;

        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(_request.getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(_request)){


            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)_request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    kkxuser kkxuser = (kkxuser)_session.getAttribute("user");
                    //String path="E:/springUpload"+file.getOriginalFilename();
                    String path = "E:/"+kkxuser.getUsername()+System.currentTimeMillis()+".xlsx";
                    //上传
                    try {
                        File ff = new File(path);
                        file.transferTo(ff);

                        msg =  this.initExcelAndAddDB(ff,kkxuser.getUserid(),_wordtype);
                        ActionUtil.write("uploadSuccess",_response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }


        }


    }


    /**
     * 解析excel并添加到数据库
     * @param _f
     * @param _userid   登陆用户id
     */
    public int initExcelAndAddDB(File _f,Long _userid,Integer _wordtype){

        int num = 0;
        //读取excel
        Workbook hwk = null;

        try {
            hwk = new XSSFWorkbook(_f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        Sheet sheet = hwk.getSheetAt(0);

        Row rowone = sheet.getRow(0);

        int nummsg = 0;

        for (int i = 1; i < sheet.getLastRowNum()+1; i++) {


            Row rows = sheet.getRow(i);
            Cell cellone = rowone.getCell(0);
            Cell celltwo =  rows.getCell(0);
            if (cellone!=null && celltwo!=null) {
                nummsg += this.insertWord(cellone,celltwo,_userid,_wordtype);
            }

            Cell cellone1 = rowone.getCell(1);
            Cell celltwo1 =  rows.getCell(1);
            if (cellone1!=null && celltwo1!=null) {
                nummsg +=  this.insertWord(cellone1,celltwo1,_userid,_wordtype);
            }

            Cell cellone2 = rowone.getCell(2);
            Cell celltwo2 =  rows.getCell(2);
            if (cellone2!=null && celltwo2!=null) {
                nummsg += this.insertWord(cellone2,celltwo2,_userid,_wordtype);
            }

            Cell cellone3 = rowone.getCell(3);
            Cell celltwo3 =  rows.getCell(3);
            if (cellone3!=null && celltwo3!=null) {
                nummsg += this.insertWord(cellone3,celltwo3,_userid,_wordtype);
            }

            Cell cellone4 = rowone.getCell(4);
            Cell celltwo4 =  rows.getCell(4);
            if (cellone4!=null && celltwo4!=null) {
                nummsg += this.insertWord(cellone4,celltwo4,_userid,_wordtype);
            }

            Cell cellone5 = rowone.getCell(5);
            Cell celltwo5 =  rows.getCell(5);
            if (cellone5!=null && celltwo5!=null) {
                nummsg += this.insertWord(cellone5,celltwo5,_userid,_wordtype);
            }

            Cell cellone6 = rowone.getCell(6);
            Cell celltwo6 =  rows.getCell(6);
            if (cellone6!=null && celltwo6!=null) {
                nummsg += this.insertWord(cellone6,celltwo6,_userid,_wordtype);
            }

        }

        if (hwk!=null){
            try {
                hwk.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        num = nummsg;
        return  num;

    }

    /**
     * 读取excel 增加内容
     * @param _cell1
     * @param _cell2
     * @param _userid
     * @return
     */
    public Integer insertWord(Cell _cell1,Cell _cell2,Long _userid,Integer _wordtype){

        int msg = 0;

            if(_cell1!=null && _cell2!=null){
                String cellstr = _cell1.getStringCellValue();
                String cellstr2 = _cell2.getStringCellValue();
                if((!cellstr.equals("")) && (!cellstr2.equals(""))){

                    long countnum = 0;
                    kkxuserwordExample example = new kkxuserwordExample();
                    example.createCriteria().andWordcolnameEqualTo(cellstr).andWordnameEqualTo(cellstr2).andWordtypeEqualTo(_wordtype).andWorduseridEqualTo(_userid);
                    countnum = this.kkxuserwordmapper.countByExample(example);
                    if(countnum==0){
                        kkxuserword kxword = new kkxuserword();
                        Long nextid = this.kkxuserwordmapper.getMaxIdByUserWord();
                        kxword.setKkxuserlinkwordid(nextid);
                        kxword.setWordcolname(cellstr);
                        kxword.setWordname(cellstr2);
                        kxword.setWordtype(_wordtype);
                        kxword.setCrtime(Calendar.getInstance().getTime());
                        kxword.setWorduserid(_userid);
                        msg =  this.kkxuserwordmapper.insertSelective(kxword);
                    }
                }
            }

        return  msg;

    }


    /**
     * 获取个人词表内容
     * @param _session
     * @param _mav
     * @param _pagesize
     * @param _client
     * @return
     */
    @RequestMapping(value = "getcontentbypwword")
    public ModelAndView getcontentbypwword(HttpSession _session,ModelAndView _mav,
                                           @RequestParam(value = "pagesize")Integer _pagesize,
                                           @RequestParam(value = "client")Integer _client,
                                           @RequestParam(value = "selcolval",required = false)String _selcolval,
                                           @RequestParam(value = "wordsearchcontent",required = false)String _wordsearchcontent,
                                           @RequestParam(value = "orderby",required = false)String orderby
                                           ){
        kkxuser kkxuser = (kkxuser)_session.getAttribute("user");



        //分页查询
        long pagetotalnum = 0;
        long pagezong = 0;
        PageHelper.startPage(_pagesize,15);
        kkxuserwordExample example = new kkxuserwordExample();




        if ((!_selcolval.equals(""))){
            if((!_wordsearchcontent.equals(""))){
                if(_selcolval.equals("all")){
                    example.createCriteria().andWordtypeEqualTo(_client).andWorduseridEqualTo(kkxuser.getUserid()).andWordnameLike("%"+_wordsearchcontent+"%");

                }else{
                    example.createCriteria().andWordtypeEqualTo(_client).andWorduseridEqualTo(kkxuser.getUserid()).andWordcolnameEqualTo(_selcolval).andWordnameLike("%"+_wordsearchcontent+"%");

                }
            }else{
                if(_selcolval.equals("all")){
                    example.createCriteria().andWordtypeEqualTo(_client).andWorduseridEqualTo(kkxuser.getUserid());
                }else{
                    example.createCriteria().andWordtypeEqualTo(_client).andWorduseridEqualTo(kkxuser.getUserid()).andWordcolnameEqualTo(_selcolval);
                }
            }
        }else{
            example.createCriteria().andWordtypeEqualTo(_client).andWorduseridEqualTo(kkxuser.getUserid());
        }

        String _orderbystr = "desc";

        if(orderby!=null && (!orderby.equals(""))){
            String arrayorderbystr = orderby.split("\\$\\$")[1];
            if(arrayorderbystr.equals("desc")){
                _orderbystr = "asc";
            }else{
                _orderbystr = "desc";
            }
            example.setOrderByClause(orderby.replace("$$","  "));
        }else{
            example.setOrderByClause("crtime desc");
        }

        _mav.addObject("_orderbystr",_orderbystr);

        List<kkxuserword> userwordlist = this.kkxuserwordmapper.selectByExample(example);
        PageInfo<kkxuserword> pageInfo = new PageInfo<kkxuserword>(userwordlist);
        if(pageInfo!=null){
            pagetotalnum = pageInfo.getTotal();
        }
        if(pagetotalnum%15==0){
            pagezong = pagetotalnum/15;
        }else{
            pagezong = pagetotalnum/15+1;
        }
        _mav.addObject("userwordlist",pageInfo.getList());
        _mav.addObject("pagenum",_pagesize);
        _mav.addObject("pagesize",15);
        _mav.addObject("pagezong",pagezong);
        _mav.addObject("client",_client);




        _mav.setViewName("userword/userwordlist");
        return _mav;
    }


    /**
     * 修改个人自定义扩展词表内容
     * @param _wordname
     * @param _wordcolname
     * @param _kkxworduserid
     * @param _response
     */
    @RequestMapping(value = "worduserupdateform")
    public void worduserupdateform(@RequestParam(value = "wordname")String _wordname,
                                   @RequestParam(value = "wordcolname")String _wordcolname,
                                   @RequestParam(value = "kkxworduserid")Long _kkxworduserid,
                                   HttpServletResponse _response){

        int msg = 0;
        kkxuserword obj = new kkxuserword();
        obj.setWordname(_wordname);
        obj.setWordcolname(_wordcolname);

        kkxuserwordExample example = new kkxuserwordExample();
        example.createCriteria().andKkxuserlinkwordidEqualTo(_kkxworduserid);

        msg = this.kkxuserwordmapper.updateByExampleSelective(obj,example);

        ActionUtil.write(msg+"",_response);


    }


    /**
     * 用户扩展此表  根据id删除某个词
     * @param _userlinkwordid
     */
    @RequestMapping(value = "delword")
    public void delword(@RequestParam(value = "userlinkwordid")Long _userlinkwordid,HttpServletResponse _response){

        int msg = 0;

        kkxuserwordExample example = new kkxuserwordExample();
        example.createCriteria().andKkxuserlinkwordidEqualTo(_userlinkwordid);
        msg = this.kkxuserwordmapper.deleteByExample(example);


        ActionUtil.write(""+msg,_response);


    }


    /**
     * 链接到用户个人词表管理界面
     * @param _mav
     * @return
     */
    @RequestMapping(value = "userallwordmanagerlist")
    public ModelAndView userallwordmanagerlist(ModelAndView _mav,
                                               @RequestParam(value = "wordpagesize",required = false)Integer _wordpagesize,
                                               @RequestParam(value = "sel_cate_list",required = false)Integer _sel_cate_list,
                                               @RequestParam(value = "sel_son_colname",required = false)String _sel_son_colname,
                                               @RequestParam(value = "searchwordval",required = false)String _searchwordval,
                                               @RequestParam(value = "userid",required = false)Long _userid){




        //分页查询
        long pagetotalnum = 0;
        long pagezong = 0;
        PageHelper.startPage(_wordpagesize,15);
        kkxuserwordExample example = new kkxuserwordExample();

        if ((!_sel_son_colname.equals(""))){
            if((!_searchwordval.equals(""))){
                if(_sel_son_colname.equals("all")){
                    example.createCriteria().andWordtypeEqualTo(_sel_cate_list).andWorduseridEqualTo(_userid).andWordnameLike("%"+_searchwordval+"%");
                }else{
                    example.createCriteria().andWordtypeEqualTo(_sel_cate_list).andWorduseridEqualTo(_userid).andWordcolnameEqualTo(_sel_son_colname).andWordnameLike("%"+_searchwordval+"%");
                }
            }else{
                if(_sel_son_colname.equals("all")){
                    example.createCriteria().andWordtypeEqualTo(_sel_cate_list).andWorduseridEqualTo(_userid);
                }else{
                    example.createCriteria().andWordtypeEqualTo(_sel_cate_list).andWorduseridEqualTo(_userid).andWordcolnameEqualTo(_sel_son_colname);
                }
            }
        }else{
            example.createCriteria().andWordtypeEqualTo(_sel_cate_list).andWorduseridEqualTo(_userid);
        }
        example.setOrderByClause("crtime desc");

        List<kkxuserword> userwordlist = this.kkxuserwordmapper.selectByExample(example);
        PageInfo<kkxuserword> pageInfo = new PageInfo<kkxuserword>(userwordlist);
        if(pageInfo!=null){
            pagetotalnum = pageInfo.getTotal();
        }
        if(pagetotalnum%15==0){
            pagezong = pagetotalnum/15;
        }else{
            pagezong = pagetotalnum/15+1;
        }
        _mav.addObject("userwordlist",pageInfo.getList());


        Map mapwordlist = new HashMap();
        //判断当前词表 主表是否存在
        if(pageInfo.getList()!=null && pageInfo.getList().size()>0){
            List<kkxuserword> wlist = pageInfo.getList();
            for (int i = 0; i <wlist.size() ; i++) {
                kkxuserword kuword = wlist.get(i);
                kkxwordExample kexample = new kkxwordExample();
                kexample.createCriteria().andWordtypeEqualTo(kuword.getWordtype()).andWordnameEqualTo(kuword.getWordname()).andWordcolnameEqualTo(kuword.getWordcolname());
                List<kkxword> kwordlist = kkxwordmapper.selectByExample(kexample);
                if(kwordlist!=null && kwordlist.size()>0){
                    mapwordlist.put(kuword.getKkxuserlinkwordid(),"1");
                }else{
                    mapwordlist.put(kuword.getKkxuserlinkwordid(),"0");
                }
            }
        }

        _mav.addObject("mapwordlist",mapwordlist);

        _mav.addObject("pagenumright",_wordpagesize);
        _mav.addObject("pagesizeright",15);
        _mav.addObject("pagezongright",pagezong);
        _mav.addObject("client",_sel_cate_list);


        _mav.setViewName("personal/wordlist");
        return  _mav;
    }


    /**
     * 个人词表 加载至主词表
     * @param _wordlinkid
     */
    @ResponseBody
    @RequestMapping(value = "adduserword")
    public  void  adduserword(@RequestParam(value = "wordlinkid")Long _wordlinkid,HttpServletResponse _response){

        int msg = 0;

        kkxuserword uwordobj = null;
        kkxuserwordExample  example = new kkxuserwordExample();
        example.createCriteria().andKkxuserlinkwordidEqualTo(_wordlinkid);
        List<kkxuserword> listkkxuserword = this.kkxuserwordmapper.selectByExample(example);
        if(listkkxuserword!=null && listkkxuserword.size()>0){
            uwordobj = listkkxuserword.get(0);
        }

        if (uwordobj!=null){
            Long wordid =  this.kkxwordmapper.getMaxIdByWord();
            kkxword kword = new kkxword();
            kword.setTableid(wordid);
            kword.setWordcolname(uwordobj.getWordcolname());
            kword.setWordname(uwordobj.getWordname());
            kword.setWordtype(uwordobj.getWordtype());
            kword.setWordstatus(10);
            this.kkxwordmapper.insertSelective(kword);
            msg = 1;
        }
        ActionUtil.write(msg+"",_response);

    }
}
