package com.kkx.solr;

import com.kkx.kkxconfig.bean.kkxconfig;
import com.kkx.kkxconfig.bean.kkxconfigExample;
import com.kkx.kkxconfig.service.kkxconfigMapper;
import com.kkx.kkxpdf.bean.kkxpdf;
import com.kkx.kkxpdf.service.kkxpdfMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * 处理客户端图谱
 */
@RequestMapping(value = "solr")
@Controller
public class SolrActionClient {

    @Autowired
    private kkxconfigMapper kkxconfigmapper;

    @Autowired
    private kkxpdfMapper kkxpdfmapper;


    /**
     * 获取聚类图页面
     * @param _mav
     * @param _userid
     * @param _domsg
     * @return
     */
    @RequestMapping(value = "jl")
    public ModelAndView getJL(ModelAndView _mav,@RequestParam(value = "userid",required = false)String _userid,@RequestParam(value = "domsg",required = false)String _domsg){

        _mav.addObject("domsg",_domsg);
        _mav.addObject("userid",_userid);
        _mav.setViewName("jl");
        return _mav;
    }

    /**
     * 上载txt内容
     * @param _userid
     * @param _pdfname
     * @param _file
     * @return
     */
    @RequestMapping(value = "uploadfile")
    public String uploadfile(@RequestParam(value="userid", required=true) String _userid, @RequestParam(value="pdfname", required=true) String _pdfname, @RequestParam(value="file", required=true) MultipartFile _file,@RequestParam(value="domsg", required=true) String _domsg)
    {

        String fname = (Math.random()+"").replace(".","")+"_"+_userid+"_"+_pdfname;
        String keystrconfig = "";
        kkxconfigExample example = new kkxconfigExample();
        example.createCriteria().andConfignameEqualTo("KKXUPLOADTXTFILEPATH");
        List<kkxconfig> configlist = kkxconfigmapper.selectByExample(example);
        if(configlist!=null && configlist.size()>0){
            keystrconfig = configlist.get(0).getConfigvalue();
        }
        String truefpath = keystrconfig+"/"+fname;
        File f = new File(truefpath);
        try {
            _file.transferTo(f);
            readDisposeExcel(f,_userid,_domsg);



            /*pdfcontent = FileUtils.readFileToString(f,"utf-8");

            int num = 0;
            kkxpdf pdf = new kkxpdf();
            pdf.setContentid(this.kkxpdfmapper.getMaxIdByWord());
            pdf.setPdfname(_pdfname.replace(".txt",""));


            pdf.setPdfcontent(ZLYFF.zlyffcontent(pdfcontent,_pdfname)+ZY.zycontent(pdfcontent,_pdfname));
            pdf.setUserid(Long.parseLong(_userid));
            System.out.println("***********"+_domsg);
            pdf.setDomsg(_domsg);
            num = kkxpdfmapper.insertSelective(pdf);*/

        } catch (IOException e) {
            e.printStackTrace();
        }

        return _pdfname;
    }

    /**
     * 写入数据库
     * @param _pdfname
     * @param _content
     * @param _userid
     * @param _domsg
     * @return
     */
    private Integer writeDB(String _pdfname,String _content,String _userid,String _domsg){
        int msg = 0;

        int num = 0;
        kkxpdf pdf = new kkxpdf();
        pdf.setContentid(this.kkxpdfmapper.getMaxIdByWord());
        pdf.setPdfname(_pdfname);
        if(!_content.equals("")){
            _content =  _content.replace("("," ").replace(")"," ").replace(" ","").replace(","," ");

        }

        pdf.setPdfcontent(_content);
        pdf.setUserid(Long.parseLong(_userid));
        pdf.setDomsg(_domsg);
        pdf.setCrtime(Calendar.getInstance().getTime());
        msg = kkxpdfmapper.insertSelective(pdf);

        return msg;
    }


    /**
     * 读取excel
     * @param _file
     * @return
     */
    private String readDisposeExcel(File _file,String _userid,String _domsg){
        String readstr = "";
        FileInputStream fis = null;
        Workbook wb = null;
        try
        {
            Map<String,List<String>> map = new LinkedHashMap<String,List<String>>();

            fis = new FileInputStream(_file);
            wb = new XSSFWorkbook(fis);

            Sheet sheet = wb.getSheetAt(0);

            Row row = sheet.getRow(0);

            int rownum = sheet.getLastRowNum();


            for (int j = 1; j <= rownum; j++) {
                Row rowj = sheet.getRow(j);
                StringBuffer tmlist = new StringBuffer();

                StringBuffer ywzclist = new StringBuffer();
                StringBuffer zhlist = new StringBuffer();
                StringBuffer zzlist = new StringBuffer();
                StringBuffer jbmclist = new StringBuffer();
                StringBuffer fmlist = new StringBuffer();
                StringBuffer syszblist = new StringBuffer();
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    if(cell!=null){
                        String cellstr = cell.getStringCellValue();
                        if(cellstr!=null && (!cellstr.equals(""))){

                            if(cellstr.equals("题名")){
                                if(rowj!=null){
                                    Cell cellj = rowj.getCell(i);
                                    if(cellj!=null){
                                        String celljstr = cellj.getStringCellValue();
                                        if(celljstr!=null && (!celljstr.equals(""))){
                                            tmlist.append(celljstr);
                                        }
                                    }
                                }
                            }

                            if(cellstr.equals("药物组成")){
                                if(rowj!=null){
                                    Cell cellj = rowj.getCell(i);
                                    if(cellj!=null){
                                        String celljstr = cellj.getStringCellValue();
                                        if(celljstr!=null && (!celljstr.equals(""))){
                                            ywzclist.append(celljstr);
                                        }
                                    }
                                }
                            }
                            if(cellstr.equals("证候")){
                                if(rowj!=null){
                                    Cell cellj = rowj.getCell(i);
                                    if(cellj!=null){
                                        String celljstr = cellj.getStringCellValue();
                                        if(celljstr!=null && (!celljstr.equals(""))){
                                            zhlist.append(celljstr);
                                        }
                                    }
                                }
                            }
                            if(cellstr.equals("症状")){
                                if(rowj!=null){
                                    Cell cellj = rowj.getCell(i);
                                    if(cellj!=null){
                                        String celljstr = cellj.getStringCellValue();
                                        if(celljstr!=null && (!celljstr.equals(""))){
                                            zzlist.append(celljstr);
                                        }
                                    }
                                }
                            }
                            if(cellstr.equals("疾病名称")){
                                if(rowj!=null){
                                    Cell cellj = rowj.getCell(i);
                                    if(cellj!=null){
                                        String celljstr = cellj.getStringCellValue();
                                        if(celljstr!=null && (!celljstr.equals(""))){
                                            jbmclist.append(celljstr);
                                        }
                                    }
                                }
                            }
                            if(cellstr.equals("方名")){
                                if(rowj!=null){
                                    Cell cellj = rowj.getCell(i);
                                    if(cellj!=null){
                                        String celljstr = cellj.getStringCellValue();
                                        if(celljstr!=null && (!celljstr.equals(""))){
                                            fmlist.append(celljstr);
                                        }
                                    }
                                }
                            }
                            if(cellstr.equals("实验室指标")){
                                if(rowj!=null){
                                    Cell cellj = rowj.getCell(i);
                                    if(cellj!=null){
                                        String celljstr = cellj.getStringCellValue();
                                        if(celljstr!=null && (!celljstr.equals(""))){
                                            syszblist.append(celljstr);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                writeDB(tmlist+"",ywzclist.append(zhlist.append(zzlist.append(jbmclist.append(fmlist.append(syszblist)))))+"",_userid,_domsg);
                System.out.println(ywzclist.toString());
            }



          /*  map.put("药物组成", ywzclist);
            map.put("证候", zhlist);
            map.put("症状", zzlist);
            map.put("疾病名称", jbmclist);
            map.put("方名", fmlist);
            map.put("实验室指标", syszblist);*/
        }
        catch (FileNotFoundException localFileNotFoundException) {}catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            if(wb!=null){
                try {
                    wb.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }

        return readstr;
    }



}
