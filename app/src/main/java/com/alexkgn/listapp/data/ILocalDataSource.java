package com.alexkgn.listapp.data;

import android.support.annotation.NonNull;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by Alex on 24.07.2017.
 */

public interface ILocalDataSource {

    Completable savePicture(@NonNull final Picture picture);

    Observable<Picture> getPictures();

}
