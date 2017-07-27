package com.alexkgn.listapp.data.remote;

import android.graphics.Bitmap;

import com.alexkgn.listapp.data.GoogleApi;
import com.alexkgn.listapp.data.pojo.GoogleResponse;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex on 27.07.2017.
 */

public class RemoteDataSource implements IRemoteDataSource {

    private GoogleApi mGoogleApi;

    @Inject
    public RemoteDataSource(GoogleApi googleApi) {
        mGoogleApi = googleApi;
    }

    @Override
    public Single<GoogleResponse> fetchPicture(String query) {
        return mGoogleApi.getPicture(query);
    }
}
