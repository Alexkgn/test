package com.alexkgn.listapp.data.pojo;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Nullable;

/**
 * Created by Alex on 27.07.2017.
 */

public class GoogleResponse {

    @SerializedName("items")
    ItemsResponse[] items;

    public ItemsResponse[] getItems() {
        return items;
    }

    public void setItems(ItemsResponse[] items) {
        this.items = items;
    }

    // Получаем из ответа ссылку на первую картинку, если таковая имеется.
    @Nullable
    public String getUrlIfExists() {
        ItemsResponse[] items;
        if ((items = getItems()) != null && getItems().length > 0) {
            ItemsResponse item = items[0];
            PageMapResponse pageMap;
            if (item != null && (pageMap = item.getPageMap()) != null) {
                ImageResponse[] image = pageMap.getImage();
                if (image != null && image.length > 0) {
                    return image[0].getImageUrl();
                }
            }
        }
        return null;
    }

}
