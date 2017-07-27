package com.alexkgn.listapp.di;

import com.alexkgn.listapp.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Alex on 22.07.2017.
 */

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AppModule.class,
                InjectorModule.class,
        }
)
interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    @Singleton
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
