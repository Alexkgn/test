package com.alexkgn.listapp.data.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex on 27.07.2017.
 */

public class ImageResponse {

    @SerializedName("src")
    String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
