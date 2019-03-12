package com.kkx.userauth.bean;

import java.util.Date;

public class userauth {


    /**
     * 客户端一
     */
    public static Integer AUTHCLIENTONE = 1;
    /**
     * 客户端二
     */
    public static Integer AUTHCLIENTTWO = 2;

    /**
     * 正常权限类型
     */
    public static Integer AUTHTYPE = 10;




    private Long userauthid;

    private Long userid;

    private Integer authid;

    private Integer authtype;

    private Date crtime;

    private Long cruserid;

    public Long getUserauthid() {
        return userauthid;
    }

    public void setUserauthid(Long userauthid) {
        this.userauthid = userauthid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getAuthid() {
        return authid;
    }

    public void setAuthid(Integer authid) {
        this.authid = authid;
    }

    public Integer getAuthtype() {
        return authtype;
    }

    public void setAuthtype(Integer authtype) {
        this.authtype = authtype;
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }

    public Long getCruserid() {
        return cruserid;
    }

    public void setCruserid(Long cruserid) {
        this.cruserid = cruserid;
    }
}