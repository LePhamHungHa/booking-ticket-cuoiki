package com.example.testbookingticket.Theater;

import com.google.gson.annotations.SerializedName;

public class Theater {
    @SerializedName("theater_name")
    private String theater_name;
    @SerializedName("province")
    private String province;

    @SerializedName("urlImg")
    private int imgTheater;

    public Theater(String theater_name, String province, int imgTheater) {
        this.theater_name = theater_name;
        this.province = province;
        this.imgTheater = imgTheater;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getImgTheater() {
        return imgTheater;
    }

    public void setImgTheater(int imgTheater) {
        this.imgTheater = imgTheater;
    }
}
