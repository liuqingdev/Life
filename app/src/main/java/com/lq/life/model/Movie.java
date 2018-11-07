package com.lq.life.model;

/**
 * Created by lq on 2018/11/7.
 */

public class Movie {
    private int pictureId;
    private String lines;

    public Movie(int pictureId, String lines) {
        this.pictureId = pictureId;
        this.lines = lines;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getLines() {
        return lines;
    }

    public void setLines(String lines) {
        this.lines = lines;
    }
}
