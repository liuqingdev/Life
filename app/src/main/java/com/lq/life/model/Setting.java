package com.lq.life.model;

/**
 * Created by lq on 2018/10/23.
 */

public class Setting {
    private int imgId;
    private String descrition;

    public Setting(int imgId, String descrition) {
        this.imgId = imgId;
        this.descrition = descrition;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }
}
