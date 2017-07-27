package com.alexkgn.listapp.data.remote;

import com.alexkgn.listapp.data.pojo.GoogleResponse;

import io.reactivex.Single;

/**
 * Created by Alex on 24.07.2017.
 */

public interface IRemoteDataSource {

    Single<GoogleResponse> fetchPicture(String query);
}
