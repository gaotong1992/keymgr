package com.kkx.kkxconfig.bean;

public class kkxconfig {
    private Long configid;

    private String configname;

    private String configvalue;

    private String configdesc;

    public Long getConfigid() {
        return configid;
    }

    public void setConfigid(Long configid) {
        this.configid = configid;
    }

    public String getConfigname() {
        return configname;
    }

    public void setConfigname(String configname) {
        this.configname = configname == null ? null : configname.trim();
    }

    public String getConfigvalue() {
        return configvalue;
    }

    public void setConfigvalue(String configvalue) {
        this.configvalue = configvalue == null ? null : configvalue.trim();
    }

    public String getConfigdesc() {
        return configdesc;
    }

    public void setConfigdesc(String configdesc) {
        this.configdesc = configdesc == null ? null : configdesc.trim();
    }
}