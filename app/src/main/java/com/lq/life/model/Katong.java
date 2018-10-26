package com.lq.life.model;

import java.io.Serializable;

/**
 * Created by lq on 2018/10/23.
 */

public class Katong implements Serializable{
    private int logo;
    private String name;
    private int power;

    public Katong(int logo, String name, int power) {
        this.logo = logo;
        this.name = name;
        this.power = power;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
