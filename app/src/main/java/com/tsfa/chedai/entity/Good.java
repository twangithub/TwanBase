package com.tsfa.chedai.entity;

/**
 * Created by admin on 2017/11/17.
 */

public class Good extends Entity {
    private int goodid;
    private String goodname;// --产品名称
    private String goodtype;//--产品类别
    private int istimer; //--是否计时

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getGoodtype() {
        return goodtype;
    }

    public void setGoodtype(String goodtype) {
        this.goodtype = goodtype;
    }

    public int getIstimer() {
        return istimer;
    }

    public void setIstimer(int istimer) {
        this.istimer = istimer;
    }
}
