package com.kkx.kkxpdf.bean;

import java.util.Date;

public class kkxpdf {
    private Long contentid;

    private String pdfname;

    private String pdfdesc;

    private Long userid;

    private String domsg;

    private Date crtime;

    private String pdfcontent;

    public Long getContentid() {
        return contentid;
    }

    public void setContentid(Long contentid) {
        this.contentid = contentid;
    }

    public String getPdfname() {
        return pdfname;
    }

    public void setPdfname(String pdfname) {
        this.pdfname = pdfname == null ? null : pdfname.trim();
    }

    public String getPdfdesc() {
        return pdfdesc;
    }

    public void setPdfdesc(String pdfdesc) {
        this.pdfdesc = pdfdesc == null ? null : pdfdesc.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getDomsg() {
        return domsg;
    }

    public void setDomsg(String domsg) {
        this.domsg = domsg == null ? null : domsg.trim();
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }

    public String getPdfcontent() {
        return pdfcontent;
    }

    public void setPdfcontent(String pdfcontent) {
        this.pdfcontent = pdfcontent == null ? null : pdfcontent.trim();
    }
}