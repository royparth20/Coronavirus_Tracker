package com.royaldreams.coronavirustracker.Modal;

public class SypmtomsData {
    String img_url, discrpiption, title;
    static String warning;

    public static String getWarning() {
        return warning;
    }

    public static void setWarning(String warning) {
        SypmtomsData.warning = warning;
    }

    public SypmtomsData() {
        this.img_url = img_url;
        this.discrpiption = discrpiption;
        this.title = title;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDiscrpiption() {
        return discrpiption;
    }

    public void setDiscrpiption(String discrpiption) {
        this.discrpiption = discrpiption;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
