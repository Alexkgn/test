package com.alexkgn.listapp.data;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alexkgn.listapp.data.database.IDbHelper;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.Observable;

/**
 * Created by Alex on 24.07.2017.
 */

public class LocalDataSource implements ILocalDataSource {

    private IDbHelper mDBHelper;
    private Context mContext;

    @Inject
    public LocalDataSource(@NonNull Context context, @NonNull IDbHelper iDbHelper) {
        mContext = context;
        mDBHelper = iDbHelper;
    }

    @Override
    public Completable savePicture(@NonNull final Picture picture) {
        return Completable.create((CompletableEmitter emitter) -> {
            if (mDBHelper.savePicture(picture)) {
                emitter.onComplete();
            } else {
                emitter.onError(new Exception("Не удалось сохранить поездку"));
            }
        });
    }

    @Override
    public Observable<Picture> getPictures() {
        return Observable.fromIterable(
                mDBHelper.getPictureList()
        );
    }
}
