package com.alexkgn.listapp.ui.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Alex on 22.07.2017.
 */

public class BasePresenter<V extends IView> implements IPresenter<V> {
    private V view;
    private CompositeDisposable disposable = null;

    @Override
    public void bind(V view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        dispose();
        this.view = null;
    }

    protected V getView(){
        return this.view;
    }

    protected void addDisposable(final Disposable disposable){
        if (this.disposable == null || this.disposable.isDisposed()){
            this.disposable = new CompositeDisposable();
        }
        this.disposable.add(disposable);
    }
    protected void dispose(){
        if (disposable != null) {
            disposable.clear();
        }
    }
}
