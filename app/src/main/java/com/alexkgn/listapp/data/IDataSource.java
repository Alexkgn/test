package com.alexkgn.listapp.data;

import javax.annotation.Nonnull;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Alex on 27.07.2017.
 */

public interface IDataSource {

    Observable<Picture> getPictures();

    Completable savePicture(Picture picture);

    Single fetchPicture(@Nonnull String query);

}
