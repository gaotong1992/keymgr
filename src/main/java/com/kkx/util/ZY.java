package com.kkx.util;

public class ZY {

    public static String zycontent(String _pdfcontent,String _pdfname){
        String str = "";

        if ((_pdfcontent != null) && (!_pdfcontent.equals("")))
        {
            String str1 = _pdfcontent.replace("\r", "").replace("\n", "").replace("　", "").replace(" ", "").replace(" ", "").trim();
            int num1 = str1.indexOf(_pdfname);
            if (num1 > 0)
            {
                String str2 = str1.substring(num1).replace(" ", "");


                int starzytnum = 0;
                int startzynum_1 = 0;

                int endzynum = 0;
                int endzynum_1 = 0;

                starzytnum = str2.indexOf("摘要");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("摘要：");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("摘要:");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("[摘要]:");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("[摘要]");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("[摘要]：");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("【摘要】");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("【摘要】：");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("【摘要】:");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                endzynum = str2.indexOf("关键词");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("关键词：");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("关键词:");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("[关键词]:");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("[关键词]");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("[关键词]：");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("【关键词】");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("【关键词】：");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("【关键词】:");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("主题词");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("主题词：");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("主题词:");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("[主题词]:");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("[主题词]");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("[主题词]：");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("【主题词】");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("【主题词】：");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("【主题词】:");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                if ((startzynum_1 > 0) && (endzynum_1 > 0) && (endzynum_1 > startzynum_1)) {
                    str = str2.substring(startzynum_1, endzynum_1);
                }
            }
            else
            {
                String str2 = str1.replace(" ", "");

                int starzytnum = 0;
                int startzynum_1 = 0;

                int endzynum = 0;
                int endzynum_1 = 0;

                starzytnum = str2.indexOf("摘要");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("摘要：");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("摘要:");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("[摘要]:");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("[摘要]");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("[摘要]：");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("【摘要】");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("【摘要】：");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                starzytnum = str2.indexOf("【摘要】:");
                if ((starzytnum > 0) && (startzynum_1 == 0)) {
                    startzynum_1 = starzytnum;
                }
                endzynum = str2.indexOf("关键词");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("关键词：");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("关键词:");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("[关键词]:");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("[关键词]");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("[关键词]：");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("【关键词】");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("【关键词】：");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                endzynum = str2.indexOf("【关键词】:");
                if ((endzynum > 0) && (endzynum_1 == 0)) {
                    endzynum_1 = endzynum;
                }
                if ((startzynum_1 > 0) && (endzynum_1 > 0) && (endzynum_1 > startzynum_1)) {
                    str = str2.substring(startzynum_1, endzynum_1);
                }
            }
        }


        return str;
    }

}
