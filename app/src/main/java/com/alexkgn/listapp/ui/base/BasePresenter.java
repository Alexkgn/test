package com.alexkgn.listapp.ui.base;

/**
 * Created by Alex on 22.07.2017.
 */

public class BasePresenter<V extends IView> implements IPresenter<V> {
    private V view;

    @Override
    public void bind(V view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }

    protected V getView(){
        return this.view;
    }
}
