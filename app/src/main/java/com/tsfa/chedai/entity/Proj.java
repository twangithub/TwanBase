package com.tsfa.chedai.entity;

/**
 * Created by admin on 2017/11/17.
 */

public class Proj extends Entity {
    private int proid;
    private String proname;//--项目名称
    private String protype;// --项目类别
    private int istimer;//--是否计时

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public int getIstimer() {
        return istimer;
    }

    public void setIstimer(int istimer) {
        this.istimer = istimer;
    }
}
