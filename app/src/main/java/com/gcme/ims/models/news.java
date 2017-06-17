package com.gcme.ims.models;

/**
 * Created by kzone on 6/17/2017.
 */

public class news {
    int id;
    String newstitle;
    String newsdetail;
    String newsimg;

    public news(int id, String newsimg, String newstitle, String newsdetail) {
        this.id = id;
        this.newstitle = newstitle;
        this.newsdetail = newsdetail;
        this.newsimg = newsimg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewsdetail() {
        return newsdetail;
    }

    public void setNewsdetail(String newsdetail) {
        this.newsdetail = newsdetail;
    }

    public String getNewsimg() {
        return newsimg;
    }

    public void setNewsimg(String newsimg) {
        this.newsimg = newsimg;
    }
}
