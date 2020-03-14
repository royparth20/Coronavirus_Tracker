package com.example.coronavirustracker.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SymptomArray {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("discription")
    @Expose
    private String discription;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
