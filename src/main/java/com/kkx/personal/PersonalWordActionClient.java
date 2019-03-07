package com.kkx.personal;

import com.kkx.kkxuserword.bean.kkxuserword;
import com.kkx.kkxuserword.service.kkxuserwordMapper;
import com.kkx.util.ActionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * client
 * 自定义词表
 */
@Controller
@RequestMapping(value = "wordclient")
public class PersonalWordActionClient {



    @Autowired
    private kkxuserwordMapper kkxuserwordmapper;

    /**
     * 上传自定义分类词表
     */
    @RequestMapping(value = "uploadwordlist")
    @ResponseBody
    public void uploadwordlist(@RequestParam(value = "fis")String _str,
                               HttpServletResponse _response){
        try {

            if(_str!=null && (!_str.equals(""))){
                String dstr = java.net.URLDecoder.decode(_str,"utf-8");
                String dstrarray[] = dstr.split("##!start!##");
                if(dstrarray!=null && dstrarray.length>0){
                    for (int i = 0;i<dstrarray.length;i++){
                        String singleword = dstrarray[i];
                        if (!singleword.equals("")){
                            String[] singlewordarray = singleword.split("##!:!##");
                            System.out.println(singlewordarray[0]);
                            System.out.println(singlewordarray[1]);
                            System.out.println("*********************************");
                            Long usermaxwordid = kkxuserwordmapper.getMaxIdByUserWord();
                          /*  kkxuserword userword = new kkxuserword();
                            userword.setKkxuserlinkwordid(usermaxwordid);
                            userword.setWordname(singlewordarray[1]);
                            userword

                            kkxuserwordmapper.insertSelective()*/



                        }
                    }
                }
            }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }



}
