package com.alexkgn.listapp.di;

import com.alexkgn.listapp.di.activities.AddPictureActivityModule;
import com.alexkgn.listapp.ui.add_picture.AddPictureActivity;
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

    @ActivityScope
    @ContributesAndroidInjector(modules = {
            AddPictureActivityModule.class
    })
    abstract AddPictureActivity addPictureActivity();

}
