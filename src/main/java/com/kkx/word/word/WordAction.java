package com.kkx.word.word;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkx.user.bean.kkxuser;
import com.kkx.util.ActionUtil;
import com.kkx.word.bean.kkxword;
import com.kkx.word.bean.kkxwordExample;
import com.kkx.word.service.kkxwordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 词表维护
 */
@Controller
@RequestMapping(value = "word")
public class WordAction {




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
                                        @RequestParam(value = "pagesize")Integer _pagesize,
                                        @RequestParam(value = "wordtype")Integer _wordtype,
                                        @RequestParam(value = "wordsearchcontent")String _wordsearchcontent){
        long pagezong = 0;
        long pagetotalnum = 0;
        List<kkxword> listword = null;
        PageHelper.startPage(_pagesize,15);
        kkxwordExample example = new kkxwordExample();


        if(_wordsearchcontent!=null && (!_wordsearchcontent.equals(""))){
            example.or(example.createCriteria().andWordnameLike("%"+_wordsearchcontent+"%"));
            example.or(example.createCriteria().andWordcolnameLike("%"+_wordsearchcontent+"%"));
        }else{
            example.createCriteria().andWordtypeEqualTo(_wordtype);
        }

        example.setOrderByClause("tableid desc");
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

}
