package com.kkx.word.bean;

public class kkxword {


    /**
     * CLIENT 1
     */
    public static Integer WORDTYPECLIENT1 = 10;

    /**
     * CLIENT 2
     */
    public static Integer WORDTYPECLIENT2 = 20;


    private Long tableid;

    private String wordname;

    private Integer wordstatus;

    private Integer wordtype;

    private String wordcolname;

    public Long getTableid() {
        return tableid;
    }

    public void setTableid(Long tableid) {
        this.tableid = tableid;
    }

    public String getWordname() {
        return wordname;
    }

    public void setWordname(String wordname) {
        this.wordname = wordname == null ? null : wordname.trim();
    }

    public Integer getWordstatus() {
        return wordstatus;
    }

    public void setWordstatus(Integer wordstatus) {
        this.wordstatus = wordstatus;
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
}