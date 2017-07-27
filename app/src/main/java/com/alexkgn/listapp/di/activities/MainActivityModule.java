package com.alexkgn.listapp.di.activities;

import com.alexkgn.listapp.ui.main.IMainPresenter;
import com.alexkgn.listapp.ui.main.MainPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex on 22.07.2017.
 */

@Module
public abstract class MainActivityModule {

    @Binds
    abstract IMainPresenter mainPresenter(MainPresenter mainPresenter);

}
