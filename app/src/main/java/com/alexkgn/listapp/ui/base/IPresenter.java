package com.alexkgn.listapp.ui.base;

/**
 * Created by Alex on 22.07.2017.
 */

public interface IPresenter<V> {

    void bind(V view);

    void unbind();

}
