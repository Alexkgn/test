package com.alexkgn.listapp.data;

import android.content.Context;

import com.alexkgn.listapp.data.local.ILocalDataSource;
import com.alexkgn.listapp.data.remote.IRemoteDataSource;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Alex on 27.07.2017.
 */

public class DataSource implements IDataSource {

    private ILocalDataSource mLocalDataSource;
    private IRemoteDataSource mRemoteDataSource;
    private Context mContext;

    @Inject
    public DataSource(Context context, ILocalDataSource localDataSource, IRemoteDataSource remoteDataSource) {
        mContext = context;
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<Picture> getPictures() {
        return mLocalDataSource.getPictures();
    }

    @Override
    public Completable savePicture(Picture picture) {
        return mLocalDataSource.savePicture(picture);
    }

    @Override
    public Single fetchPicture(@Nonnull String query) {
        return mRemoteDataSource.fetchPicture(query);
    }
}
