
package com.example.geet_pc.tendam_retrofit.frgments.login.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Path {

    @SerializedName("images")
    @Expose
    private String images;
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("thumb")
    @Expose
    private String thumb;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

}
