package com.alexkgn.listapp.ui.add_picture;

import android.graphics.Bitmap;

import com.alexkgn.listapp.ui.base.IPresenter;

/**
 * Created by Alex on 27.07.2017.
 */

public interface IAddPresenter extends IPresenter<IAddView> {

    void savePicture();

    void setTitle(String title);

    void setDescription(String description);

    void setPicture(Bitmap bitmap);

    void fetchPicture(String query);

}
