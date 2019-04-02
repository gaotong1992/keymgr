package com.kkx.word.word;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkx.kkxconfig.bean.kkxconfig;
import com.kkx.kkxconfig.bean.kkxconfigExample;
import com.kkx.kkxconfig.service.kkxconfigMapper;
import com.kkx.user.bean.kkxuser;
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
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * 词表维护
 */
@Controller
@RequestMapping(value = "word")
public class WordAction {


    @Autowired
    private kkxconfigMapper kkxconfigmapper;

    @Autowired
    private kkxwordMapper kkxwordmapper;



    /**
     * 链接到词表维护首页
     * @param _response
     * @param _session
     * @return
     */
    @RequestMapping(value = "linkwordmanager")
    public ModelAndView linkwordmanager(HttpServletResponse _response,
                                        HttpSession _session,
                                        ModelAndView _mav,
                                        @RequestParam(value = "wordtype")Integer _wordtype){

        _mav.addObject("wordtype",_wordtype);
        _mav.addObject("wordtypetext",_wordtype==kkxword.WORDTYPECLIENT1?"Client1：中医药文献数据结构化处理系统":"Client2：中医药文献数据结构化处理系统针灸");

        _mav.setViewName("word/userword");
        return _mav;
    }

    @RequestMapping(value = "linkwordmanagercontent")
    public ModelAndView linkwordmanager(HttpServletResponse _response,
                                        HttpSession _session,
                                        ModelAndView _mav,
                                        @RequestParam(value = "pagesize")Integer _pagesize,
                                        @RequestParam(value = "wordtype")Integer _wordtype,
                                        @RequestParam(value = "wordsearchcontent")String _wordsearchcontent,
                                        @RequestParam(value = "selcolval",required = false)String _selcolval,
                                        @RequestParam(value = "orderby",required = false)String orderby){
        long pagezong = 0;
        long pagetotalnum = 0;
        List<kkxword> listword = null;
        PageHelper.startPage(_pagesize,15);
        kkxwordExample example = new kkxwordExample();




        if(_selcolval!=null && (!_selcolval.equals(""))){
            if(_selcolval.equals("all")){

                if(_wordsearchcontent!=null && (!_wordsearchcontent.equals(""))){
                    example.or(example.createCriteria().andWordnameLike("%"+_wordsearchcontent+"%"));
                    example.or(example.createCriteria().andWordcolnameLike("%"+_wordsearchcontent+"%"));
                }else{
                    example.createCriteria().andWordtypeEqualTo(_wordtype);
                }


            }else{

                if(_wordsearchcontent!=null && (!_wordsearchcontent.equals(""))){
                    example.or(example.createCriteria().andWordnameLike("%"+_wordsearchcontent+"%").andWordcolnameEqualTo(_selcolval));
                    example.or(example.createCriteria().andWordcolnameLike("%"+_wordsearchcontent+"%").andWordcolnameEqualTo(_selcolval));
                }else{
                    example.createCriteria().andWordtypeEqualTo(_wordtype).andWordcolnameEqualTo(_selcolval);
                }
            }
        }else{
            if(_wordsearchcontent!=null && (!_wordsearchcontent.equals(""))){
                example.or(example.createCriteria().andWordnameLike("%"+_wordsearchcontent+"%"));
                example.or(example.createCriteria().andWordcolnameLike("%"+_wordsearchcontent+"%"));
            }else{
                example.createCriteria().andWordtypeEqualTo(_wordtype);
            }
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
            example.setOrderByClause("tableid desc");
        }

        _mav.addObject("_orderbystr",_orderbystr);



        listword = this.kkxwordmapper.selectByExample(example);
        PageInfo<kkxword> pageInfo = new PageInfo<kkxword>(listword);
        if(listword!=null){
            pagetotalnum = pageInfo.getTotal();
        }
        if(pagetotalnum%15==0){
            pagezong = pagetotalnum/15;
        }else{
            pagezong = pagetotalnum/15+1;
        }

        _mav.addObject("wordlist",pageInfo.getList());
        _mav.addObject("pagenum",_pagesize);
        _mav.addObject("pagesize",15);
        _mav.addObject("pagezong",pagezong);

        _mav.addObject("wordtype",_wordtype);
        _mav.addObject("wordtypetext",_wordtype==kkxword.WORDTYPECLIENT1?"Client1：中医药文献数据结构化处理系统":"Client2：中医药文献数据结构化处理系统针灸");
        _mav.addObject("wordscontent",_wordsearchcontent);

        _mav.addObject("selcolval",_selcolval);


        _mav.setViewName("word/word");
        return _mav;
    }

    /**
     * 根据id删除词语
     * @param _response
     * @param _session
     * @param _tableid
     */
    @RequestMapping(value = "delword")
    @ResponseBody
    public void delword(HttpServletResponse _response,
                        HttpSession _session,
                        @RequestParam(value = "tableid")Long _tableid){
        int msg = 0;

        kkxwordExample example = new kkxwordExample();
        example.createCriteria().andTableidEqualTo(_tableid);
        msg = this.kkxwordmapper.deleteByExample(example);


        ActionUtil.write(""+msg,_response);

    }

    /**
     * 根据id修改 构建表单
     * @param _response
     * @param _session
     * @param _tableid
     */
    @RequestMapping(value = "updateword")
    @ResponseBody
    public void  updateword(HttpServletResponse _response,
                            HttpSession _session,
                            @RequestParam(value = "tableid")Long _tableid){

        kkxword word = null;
        if (_tableid!=null){
            kkxwordExample example = new kkxwordExample();
            example.createCriteria().andTableidEqualTo(_tableid);
            List<kkxword> listword = this.kkxwordmapper.selectByExample(example);
            if(listword!=null){
                word = listword.get(0);
            }
        }


        StringBuffer sbstr = new StringBuffer();
        if (word!=null){
            sbstr.append("{\"tableid\":\""+word.getTableid()+"\"");
            sbstr.append(",\"wordname\":\""+word.getWordname()+"\"");
            sbstr.append(",\"wordcolname\":\""+word.getWordcolname()+"\"}");
        }

        ActionUtil.write(sbstr.toString(),_response);


    }

    /**
     * 执行更新词语操作
     * @param _response
     * @param _session
     * @param _tableid
     * @param _wordname
     * @param _wordcolname
     */
    @RequestMapping(value = "wordupdateform")
    @ResponseBody
    public void  wordupdateform(HttpServletResponse _response,
                                HttpSession _session,
                                @RequestParam(value = "tableid")Long _tableid,
                                @RequestParam(value = "wordname")String _wordname,
                                @RequestParam(value = "wordcolname")String _wordcolname){

        int msg = 0;
        if (_tableid!=null){
            kkxword word = new kkxword();
            word.setWordname(_wordname);
            word.setWordcolname(_wordcolname);
            kkxwordExample example = new kkxwordExample();
            example.createCriteria().andTableidEqualTo(_tableid);
            msg = this.kkxwordmapper.updateByExampleSelective(word,example);
        }
        ActionUtil.write(""+msg,_response);
    }







    /**
     * 上传用户个人词表
     * @param _request
     */
    @RequestMapping(value = "uploaduserword")
    public void uploaduserword(HttpServletRequest _request, HttpServletResponse _response, HttpSession _session,
                               @RequestParam(value = "wordtype",required = false)Integer _wordtype){


        int msg = 0;

        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(_request.getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(_request)){

            String keystrconfig = "";
            kkxconfigExample example = new kkxconfigExample();
            example.createCriteria().andConfignameEqualTo("KKXUPLOADPATH");
            List<kkxconfig> configlist = kkxconfigmapper.selectByExample(example);
            if(configlist!=null && configlist.size()>0){
                keystrconfig = configlist.get(0).getConfigvalue();
            }



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





                    String path = keystrconfig+"/"+kkxuser.getUsername()+System.currentTimeMillis()+".xlsx";
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
            /*    kkxuserwordExample example = new kkxuserwordExample();
                example.createCriteria().andWordcolnameEqualTo(cellstr).andWordnameEqualTo(cellstr2).andWordtypeEqualTo(_wordtype).andWorduseridEqualTo(_userid);
                countnum = this.kkxuserwordmapper.countByExample(example);*/

                kkxwordExample example = new kkxwordExample();
                example.createCriteria().andWordtypeEqualTo(_wordtype).andWordcolnameEqualTo(cellstr).andWordnameEqualTo(cellstr2);
                countnum =  kkxwordmapper.countByExample(example);


                if(countnum==0){
                    Long nextid = this.kkxwordmapper.getMaxIdByWord();

                    kkxword word = new kkxword();
                    word.setTableid(nextid);
                    word.setWordname(cellstr2);
                    word.setWordstatus(kkxword.WORDTYPECLIENT1);
                    word.setWordtype(_wordtype);
                    word.setWordcolname(cellstr);
                    msg =  this.kkxwordmapper.insertSelective(word);
                }
            }
        }

        return  msg;

    }

}
