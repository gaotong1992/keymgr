package com.kkx.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 输出类
 */
public class ActionUtil {


    /**
     * 返回页面值
     */
    public static void write(String _content, HttpServletResponse _response){


        try {

            PrintWriter pw = _response.getWriter();
            pw.write(_content);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }










}
