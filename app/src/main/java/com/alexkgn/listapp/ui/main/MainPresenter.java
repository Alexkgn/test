package com.alexkgn.listapp.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alexkgn.listapp.data.IDataSource;
import com.alexkgn.listapp.data.Picture;
import com.alexkgn.listapp.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alex on 22.07.2017.
 */

public class MainPresenter extends BasePresenter<IMainView> implements IMainPresenter {

    private Context mContext;
    private IDataSource mDataSource;

    @Inject
    public MainPresenter(@NonNull final Context context, @NonNull IDataSource dataSource) {
        mContext = context;
        mDataSource = dataSource;
    }

    @Override
    public void getAllPictures() {
        Single<List<Picture>> pictures = mDataSource.getPictures().toList();
        Disposable d = pictures.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        pic -> setContent(pic)
                );
        addDisposable(d);
    }

    @Override
    public void addNewPictureClick() {
        if (getView() != null) {
            getView().openAddPicture();
        }
    }

    @Override
    public void pictureClick(int pictureId) {
        if (getView() != null) {
            getView().showPictureFullInfo(pictureId);
        }
    }

    private void setContent(List<Picture> pictures) {
        if (getView() != null) {
            getView().setListPictures(pictures);
        }
    }
}
