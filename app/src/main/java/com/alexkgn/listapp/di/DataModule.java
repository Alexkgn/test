package com.alexkgn.listapp.di;

import android.content.Context;

import com.alexkgn.listapp.data.DataSource;
import com.alexkgn.listapp.data.GoogleApi;
import com.alexkgn.listapp.data.IDataSource;
import com.alexkgn.listapp.data.local.ILocalDataSource;
import com.alexkgn.listapp.data.remote.IRemoteDataSource;
import com.alexkgn.listapp.data.local.LocalDataSource;
import com.alexkgn.listapp.data.remote.RemoteDataSource;
import com.alexkgn.listapp.data.database.DbHelper;
import com.alexkgn.listapp.data.database.IDbHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import static com.alexkgn.listapp.data.Constants.BASE_URL;

/**
 * Created by Alex on 27.07.2017.
 */

@Module
public abstract class DataModule {

    @Provides
    @Singleton
    static IDataSource bindIDataSource(Context context, LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        return new DataSource(context, localDataSource, remoteDataSource);
    }

    @Provides
    @Singleton
    static GoogleApi provideGoogleApi(final Retrofit retrofit) {
        return retrofit.create(GoogleApi.class);
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    static Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    static IDbHelper provideDBHelper(Context context) {
        return new DbHelper(context);
    }

    @Binds
    abstract ILocalDataSource bindILocalDataSource(LocalDataSource localDataSource);

    @Binds
    abstract IRemoteDataSource bindIRemoteDataSource(RemoteDataSource remoteDataSource);

}
