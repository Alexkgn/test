package com.alexkgn.listapp.data.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex on 27.07.2017.
 */

public class PageMapResponse {

    @SerializedName("cse_image")
    ImageResponse[] image;

    public ImageResponse[] getImage() {
        return image;
    }

    public void setImage(ImageResponse[] image) {
        this.image = image;
    }
}
