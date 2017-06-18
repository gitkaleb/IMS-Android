package com.gcme.ims.models;

/**
 * Created by kzone on 6/17/2017.
 */

public class testimonies {
    int id;
    String testimonyimg;
    String testimonytitle;
    String testimonydetail;

    public testimonies() {
    }

    public testimonies(int id, String testimonyimg, String testimonytitle, String testimonydetail) {
        this.id = id;
        this.testimonyimg = testimonyimg;
        this.testimonytitle = testimonytitle;
        this.testimonydetail = testimonydetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestimonyimg() {
        return testimonyimg;
    }

    public void setTestimonyimg(String testimonyimg) {
        this.testimonyimg = testimonyimg;
    }

    public String getTestimonytitle() {
        return testimonytitle;
    }

    public void setTestimonytitle(String testimonytitle) {
        this.testimonytitle = testimonytitle;
    }

    public String getTestimonydetail() {
        return testimonydetail;
    }

    public void setTestimonydetail(String testimonydetail) {
        this.testimonydetail = testimonydetail;
    }
}
