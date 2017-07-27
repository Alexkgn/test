package com.alexkgn.listapp.data.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex on 27.07.2017.
 */

public class ItemsResponse {

    @SerializedName("pagemap")
    PageMapResponse pageMap;

    public PageMapResponse getPageMap() {
        return pageMap;
    }

    public void setPageMap(PageMapResponse pageMap) {
        this.pageMap = pageMap;
    }
}
