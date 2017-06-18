package com.gcme.ims.models;

/**
 * Created by kzone on 6/17/2017.
 */

public class devotional {
    int id;
    String devotionaldetail;
    String devotionalimg;
    String devotionaltitle;

    public devotional() {
    }

    public devotional(int id, String devotionaldetail, String devotionalimg, String devotionaltitle) {
        this.id = id;
        this.devotionaldetail = devotionaldetail;
        this.devotionalimg = devotionalimg;
        this.devotionaltitle = devotionaltitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevotionaldetail() {
        return devotionaldetail;
    }

    public void setDevotionaldetail(String devotionaldetail) {
        this.devotionaldetail = devotionaldetail;
    }

    public String getDevotionalimg() {
        return devotionalimg;
    }

    public void setDevotionalimg(String devotionalimg) {
        this.devotionalimg = devotionalimg;
    }

    public String getDevotionaltitle() {
        return devotionaltitle;
    }

    public void setDevotionaltitle(String devotionaltitle) {
        this.devotionaltitle = devotionaltitle;
    }
}
