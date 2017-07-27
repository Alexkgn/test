package com.alexkgn.listapp.di;

import android.app.Application;
import android.content.Context;

import com.alexkgn.listapp.App;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex on 22.07.2017.
 */

@Module
public abstract class AppModule {

    @Binds
    abstract Context bindApplicationContext(App app);

}