package com.kkx.kkxuserword.bean;

import java.util.Date;

public class kkxuserword {


    /**
     * 正常词表状态为10
     * @return
     */
    public final static Integer NORMALWORDTYPE = 10;

    private Long kkxuserlinkwordid;

    private String wordname;

    private Integer wordtype;

    private String wordcolname;

    private Long worduserid;

    private Date crtime;

    public Long getKkxuserlinkwordid() {
        return kkxuserlinkwordid;
    }

    public void setKkxuserlinkwordid(Long kkxuserlinkwordid) {
        this.kkxuserlinkwordid = kkxuserlinkwordid;
    }

    public String getWordname() {
        return wordname;
    }

    public void setWordname(String wordname) {
        this.wordname = wordname == null ? null : wordname.trim();
    }

    public Integer getWordtype() {
        return wordtype;
    }

    public void setWordtype(Integer wordtype) {
        this.wordtype = wordtype;
    }

    public String getWordcolname() {
        return wordcolname;
    }

    public void setWordcolname(String wordcolname) {
        this.wordcolname = wordcolname == null ? null : wordcolname.trim();
    }

    public Long getWorduserid() {
        return worduserid;
    }

    public void setWorduserid(Long worduserid) {
        this.worduserid = worduserid;
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }
}