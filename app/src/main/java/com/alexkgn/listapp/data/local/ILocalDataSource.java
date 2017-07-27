package com.alexkgn.listapp.data.local;

import android.support.annotation.NonNull;

import com.alexkgn.listapp.data.Picture;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by Alex on 24.07.2017.
 */

public interface ILocalDataSource {

    Completable savePicture(@NonNull final Picture picture);

    Observable<Picture> getPictures();

}
