package com.alexkgn.listapp.ui.add_picture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alexkgn.listapp.data.IDataSource;
import com.alexkgn.listapp.data.Picture;
import com.alexkgn.listapp.data.pojo.GoogleResponse;
import com.alexkgn.listapp.ui.base.BasePresenter;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alex on 27.07.2017.
 */

public class AddPresenter extends BasePresenter<IAddView> implements IAddPresenter {

    private Context mContext;
    private IDataSource mDataSource;

    private Picture mPicture;

    @Inject
    public AddPresenter(@NonNull final Context context, @NonNull IDataSource dataSource) {
        mContext = context;
        mDataSource = dataSource;

        mPicture = new Picture();
    }

    @Override
    public void fetchPicture(String query) {
        Single<GoogleResponse> picture = mDataSource.fetchPicture(query);
        Disposable d = picture.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        googleResponse -> setContent(googleResponse)
                );;

        addDisposable(d);
    }

    @Override
    public void setTitle(String title) {
        mPicture.setTitle(title);
    }

    @Override
    public void setDescription(String description) {
        mPicture.setDescription(description);
    }

    @Override
    public void setPicture(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        mPicture.setPicture(stream.toByteArray());
    }

    @Override
    public void savePicture() {
        mDataSource.savePicture(mPicture).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        if (getView() != null) {
                            getView().pictureSaved();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    private void setContent(GoogleResponse response) {
        if (getView() != null && !TextUtils.isEmpty(response.getUrlIfExists())) {
            getView().setPicture(response.getUrlIfExists());
        }
    }
}
