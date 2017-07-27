package com.alexkgn.listapp.di;

import android.support.v7.app.AppCompatActivity;

import com.alexkgn.listapp.ui.main.MainActivity;
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
    abstract AppCompatActivity bindActivity(MainActivity activity);

    @Binds
    abstract IMainPresenter mainPresenter(MainPresenter mainPresenter);
}
