package com.tsfa.chedai.entity;

import java.io.Serializable;import java.sql.Date;import java.text.SimpleDateFormat;

/**
 * Created by twan on 2017/10/30.
 */

public abstract class Entity implements Serializable {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    protected int id;
    //other field
    protected String logtime;
    protected String createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogtime() {
        return sdf.format(new Date(Long.parseLong(logtime)));
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    public String getCreatetime() {
        return sdf.format(new Date(Long.parseLong(createtime)));
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }


    //timestamp
    public String getLogTimeStamp() {
        return logtime;
    }

    public String getCreateTimeStamp(){
        return createtime;
    }

}
