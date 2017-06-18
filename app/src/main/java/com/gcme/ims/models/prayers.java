package com.gcme.ims.models;

/**
 * Created by kzone on 6/17/2017.
 */

public class prayers {
    int id;
    String prayertitle;
    String prayerdetail;

    public prayers() {
    }

    public prayers(int id, String prayertitle, String prayerdetail) {
        this.id = id;
        this.prayertitle = prayertitle;
        this.prayerdetail = prayerdetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrayertitle() {
        return prayertitle;
    }

    public void setPrayertitle(String prayertitle) {
        this.prayertitle = prayertitle;
    }

    public String getPrayerdetail() {
        return prayerdetail;
    }

    public void setPrayerdetail(String prayerdetail) {
        this.prayerdetail = prayerdetail;
    }



}
