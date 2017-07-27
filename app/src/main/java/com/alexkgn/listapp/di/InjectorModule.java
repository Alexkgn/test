package com.alexkgn.listapp.di;

import com.alexkgn.listapp.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Alex on 22.07.2017.
 */

@Module
@SuppressWarnings("unused,WeakerAccess")
public abstract class InjectorModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {
            MainActivityModule.class
    })
    abstract MainActivity mainActivity();

}
