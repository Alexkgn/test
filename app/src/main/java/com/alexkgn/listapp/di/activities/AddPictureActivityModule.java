package com.alexkgn.listapp.di.activities;

import com.alexkgn.listapp.ui.add_picture.AddPresenter;
import com.alexkgn.listapp.ui.add_picture.IAddPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex on 27.07.2017.
 */

@Module
public abstract class AddPictureActivityModule {

    @Binds
    abstract IAddPresenter addPresenter(AddPresenter addPresenter);

}
