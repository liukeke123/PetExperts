package com.example.lk.petexperts.vo;

/**
 * Created by lenovo on 2017/11/16.
 */

public class Pet {
    private String name;
    private int imageid;

    public Pet(String name, int imageid) {
        this.name = name;
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
