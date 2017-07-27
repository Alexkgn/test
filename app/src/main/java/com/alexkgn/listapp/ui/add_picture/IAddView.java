package com.alexkgn.listapp.ui.add_picture;

import android.graphics.Bitmap;

import com.alexkgn.listapp.ui.base.IView;

/**
 * Created by Alex on 27.07.2017.
 */

public interface IAddView extends IView{

    void setPicture(String url);

    void pictureSaved();

}
