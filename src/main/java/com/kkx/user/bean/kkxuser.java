package com.kkx.user.bean;

import java.math.BigDecimal;
import java.util.Date;

public class kkxuser {


    /**
     *  管理员类型
     * @return
     */
    public static Integer TYPEGUANLIYUAN = 10;
    /**
     *  普通类型用户
     * @return
     */
    public static Integer TYPEPUTONG = 20;
    /**
     *  正常状态
     * @return
     */
    public static Integer STATUSZHENGCHANG = 10;

    private Long userid;

    private String useruuid;

    private String username;

    private String userpwd;

    private Integer usertype;

    private Integer userstatus;

    private String userdesc;

    private String userhobby;

    private Date crtime;

    private Long cruserid;

    private Date userstarttime;

    private Date userendtime;

    private BigDecimal crtimestr;

    private BigDecimal userstarttimestr;

    private BigDecimal userendtimestr;

    private String token;

    private String useraddress;

    private String usertelphone;

    private String usermobile;

    private String useremail;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUseruuid() {
        return useruuid;
    }

    public void setUseruuid(String useruuid) {
        this.useruuid = useruuid == null ? null : useruuid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc == null ? null : userdesc.trim();
    }

    public String getUserhobby() {
        return userhobby;
    }

    public void setUserhobby(String userhobby) {
        this.userhobby = userhobby == null ? null : userhobby.trim();
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

    public Date getUserstarttime() {
        return userstarttime;
    }

    public void setUserstarttime(Date userstarttime) {
        this.userstarttime = userstarttime;
    }

    public Date getUserendtime() {
        return userendtime;
    }

    public void setUserendtime(Date userendtime) {
        this.userendtime = userendtime;
    }

    public BigDecimal getCrtimestr() {
        return crtimestr;
    }

    public void setCrtimestr(BigDecimal crtimestr) {
        this.crtimestr = crtimestr;
    }

    public BigDecimal getUserstarttimestr() {
        return userstarttimestr;
    }

    public void setUserstarttimestr(BigDecimal userstarttimestr) {
        this.userstarttimestr = userstarttimestr;
    }

    public BigDecimal getUserendtimestr() {
        return userendtimestr;
    }

    public void setUserendtimestr(BigDecimal userendtimestr) {
        this.userendtimestr = userendtimestr;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress == null ? null : useraddress.trim();
    }

    public String getUsertelphone() {
        return usertelphone;
    }

    public void setUsertelphone(String usertelphone) {
        this.usertelphone = usertelphone == null ? null : usertelphone.trim();
    }

    public String getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile == null ? null : usermobile.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }
}