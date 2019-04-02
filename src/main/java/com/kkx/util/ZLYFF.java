package com.kkx.util;

public class ZLYFF {


    public static String zlyffcontent(String _pdfcontent,String _pdfname){
        String str = "";
        if ((_pdfcontent != null) && (!_pdfcontent.equals("")))
        {
            String str1 = _pdfcontent.replace("\r", "").replace("\n", "").replace("　", "").replace(" ", "").replace(" ", "").trim();
            int num1 = str1.indexOf(_pdfname);
            if (num1 > 0)
            {
                String str2 = str1.substring(num1).replace(" ", "");















                int startjg = 0;
                int startjg_1 = 0;


                String str3_1 = str2.replaceAll("２结果", "####@结果@####@1");
                String str3_2 = str2.replaceAll("３结果", "####@结果@####@2");
                String str3_3 = str2.replaceAll("４结果", "####@结果@####@3");
                String str3_1_1 = str2.replaceAll("２治疗结果", "####@结果@####@4");
                String str3_2_1 = str2.replaceAll("３治疗结果", "####@结果@####@5");
                String str3_3_1 = str2.replaceAll("４治疗结果", "####@结果@####@6");
                String str3_3_1_1 = str2.replaceAll("治疗结果", "####@结果@####@7");
                String str3 = str2.replaceAll("\\d结果", "####@结果@####@8");
                String str4 = str2.replaceAll("\\d治疗结果", "####@结果@####@9");
                String str5 = str2.replaceAll("\\d.结果", "####@结果@####@10");
                String str6 = str2.replaceAll("\\d.\\d治疗结果", "####@结果@####@11");
                String str7 = str2.replaceAll("\\d.\\d结果", "####@结果@####@12");
                String str8 = str2.replaceAll("\\d.\\d治疗结果", "####@结果@####@13");
                String str8_1 = str2.replaceAll("二、结果", "####@结果@####@14");
                String str8_2 = str2.replaceAll("三、结果", "####@结果@####@15");
                String str8_3 = str2.replaceAll("四、结果", "####@结果@####@16");
                String str3_1_1_1 = str2.replaceAll("２疗效判定标准与结果", "####@结果@####@17");
                String str3_2_1_2 = str2.replaceAll("３疗效判定标准与结果", "####@结果@####@18");
                String str3_3_1_3 = str2.replaceAll("４疗效判定标准与结果", "####@结果@####@19");
                String str3_1_1_1_1 = str2.replaceAll("2疗效判定标准与结果", "####@结果@####@20");
                String str3_2_1_2_1 = str2.replaceAll("3疗效判定标准与结果", "####@结果@####@21");
                String str3_3_1_3_1 = str2.replaceAll("4疗效判定标准与结果", "####@结果@####@22");



                startjg = str3_1_1_1.indexOf("####@结果@####@17");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_2_1_2.indexOf("####@结果@####@18");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_3_1_3.indexOf("####@结果@####@19");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_1_1_1_1.indexOf("####@结果@####@20");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_2_1_2_1.indexOf("####@结果@####@21");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_3_1_3_1.indexOf("####@结果@####@22");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str8_1.indexOf("####@结果@####@14");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str8_2.indexOf("####@结果@####@15");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str8_3.indexOf("####@结果@####@16");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_1_1.indexOf("####@结果@####@4");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_2_1.indexOf("####@结果@####@5");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_3_1.indexOf("####@结果@####@6");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_3_1_1.indexOf("####@结果@####@7");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_1.indexOf("####@结果@####@1");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_2.indexOf("####@结果@####@2");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_3.indexOf("####@结果@####@3");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3.indexOf("####@结果@####@8");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str4.indexOf("####@结果@####@9");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str5.indexOf("####@结果@####@10");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str6.indexOf("####@结果@####@11");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str7.indexOf("####@结果@####@12");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str8.indexOf("####@结果@####@13");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                int startzl = 0;
                int startzl_1 = 0;

                String str2_dis = "";
                if (startjg_1 > 1) {
                    str2_dis = str2.substring(0, startjg_1);
                }
                String zl_str1 = str2_dis.replaceAll("资料与方法", "####@资料@####@1");
                String zl_str2 = str2_dis.replaceAll("材料与方法", "####@资料@####@2");
                String zl_str3 = str2_dis.replaceAll("对象与方法", "####@资料@####@3");
                String zl_str6 = str2_dis.replaceAll("资料和方法", "####@资料@####@6");
                String zl_str4 = str2_dis.replaceAll("临床资料", "####@资料@####@4");
                String zl_str5 = str2_dis.replaceAll("资料方法", "####@资料@####@5");
                String zl_str7 = str2_dis.replaceAll("病例资料", "####@资料@####@7");


                startzl = zl_str1.indexOf("####@资料@####@1");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str2.indexOf("####@资料@####@2");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str3.indexOf("####@资料@####@3");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str4.indexOf("####@资料@####@4");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str5.indexOf("####@资料@####@5");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str6.indexOf("####@资料@####@6");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str7.indexOf("####@资料@####@7");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                if ((startjg_1 > 0) && (startzl_1 > 0) && (startjg_1 > startzl_1)) {
                    str = str2.substring(startzl_1, startjg_1);
                }
            }
            else
            {
                String str2 = str1.replace(" ", "");










                int startjg = 0;
                int startjg_1 = 0;


                String str3_1 = str2.replaceAll("２结果", "####@结果@####@1");
                String str3_2 = str2.replaceAll("３结果", "####@结果@####@2");
                String str3_3 = str2.replaceAll("４结果", "####@结果@####@3");
                String str3_1_1 = str2.replaceAll("２治疗结果", "####@结果@####@4");
                String str3_2_1 = str2.replaceAll("３治疗结果", "####@结果@####@5");
                String str3_3_1 = str2.replaceAll("４治疗结果", "####@结果@####@6");
                String str3_3_1_1 = str2.replaceAll("治疗结果", "####@结果@####@7");
                String str3 = str2.replaceAll("\\d结果", "####@结果@####@8");
                String str4 = str2.replaceAll("\\d治疗结果", "####@结果@####@9");
                String str5 = str2.replaceAll("\\d.结果", "####@结果@####@10");
                String str6 = str2.replaceAll("\\d.\\d治疗结果", "####@结果@####@11");
                String str7 = str2.replaceAll("\\d.\\d结果", "####@结果@####@12");
                String str8 = str2.replaceAll("\\d.\\d治疗结果", "####@结果@####@13");
                String str8_1 = str2.replaceAll("二、结果", "####@结果@####@14");
                String str8_2 = str2.replaceAll("三、结果", "####@结果@####@15");
                String str8_3 = str2.replaceAll("四、结果", "####@结果@####@16");
                String str3_1_1_1 = str2.replaceAll("２疗效判定标准与结果", "####@结果@####@17");
                String str3_2_1_2 = str2.replaceAll("３疗效判定标准与结果", "####@结果@####@18");
                String str3_3_1_3 = str2.replaceAll("４疗效判定标准与结果", "####@结果@####@19");
                String str3_1_1_1_1 = str2.replaceAll("2疗效判定标准与结果", "####@结果@####@20");
                String str3_2_1_2_1 = str2.replaceAll("3疗效判定标准与结果", "####@结果@####@21");
                String str3_3_1_3_1 = str2.replaceAll("4疗效判定标准与结果", "####@结果@####@22");



                startjg = str3_1_1_1.indexOf("####@结果@####@17");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_2_1_2.indexOf("####@结果@####@18");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_3_1_3.indexOf("####@结果@####@19");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_1_1_1_1.indexOf("####@结果@####@20");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_2_1_2_1.indexOf("####@结果@####@21");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_3_1_3_1.indexOf("####@结果@####@22");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str8_1.indexOf("####@结果@####@14");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str8_2.indexOf("####@结果@####@15");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str8_3.indexOf("####@结果@####@16");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_1_1.indexOf("####@结果@####@4");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_2_1.indexOf("####@结果@####@5");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_3_1.indexOf("####@结果@####@6");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_3_1_1.indexOf("####@结果@####@7");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_1.indexOf("####@结果@####@1");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_2.indexOf("####@结果@####@2");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3_3.indexOf("####@结果@####@3");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str3.indexOf("####@结果@####@8");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str4.indexOf("####@结果@####@9");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str5.indexOf("####@结果@####@10");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str6.indexOf("####@结果@####@11");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str7.indexOf("####@结果@####@12");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                startjg = str8.indexOf("####@结果@####@13");
                if ((startjg > 0) && (startjg_1 == 0)) {
                    startjg_1 = startjg;
                }
                int startzl = 0;
                int startzl_1 = 0;

                String str2_dis = "";
                if (startjg_1 > 1) {
                    str2_dis = str2.substring(0, startjg_1);
                }
                String zl_str1 = str2_dis.replaceAll("资料与方法", "####@资料@####@1");
                String zl_str2 = str2_dis.replaceAll("材料与方法", "####@资料@####@2");
                String zl_str3 = str2_dis.replaceAll("对象与方法", "####@资料@####@3");
                String zl_str6 = str2_dis.replaceAll("资料和方法", "####@资料@####@6");
                String zl_str4 = str2_dis.replaceAll("临床资料", "####@资料@####@4");
                String zl_str5 = str2_dis.replaceAll("资料方法", "####@资料@####@5");
                String zl_str7 = str2_dis.replaceAll("病例资料", "####@资料@####@7");


                startzl = zl_str1.indexOf("####@资料@####@1");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str2.indexOf("####@资料@####@2");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str3.indexOf("####@资料@####@3");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str4.indexOf("####@资料@####@4");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str5.indexOf("####@资料@####@5");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str6.indexOf("####@资料@####@6");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                startzl = zl_str7.indexOf("####@资料@####@7");
                if ((startzl > 0) && (startzl_1 == 0)) {
                    startzl_1 = startzl;
                }
                if ((startjg_1 > 0) && (startzl_1 > 0) && (startjg_1 > startzl_1)) {
                    str = str2.substring(startzl_1, startjg_1);
                }
            }
        }


        return str;
    }

}
