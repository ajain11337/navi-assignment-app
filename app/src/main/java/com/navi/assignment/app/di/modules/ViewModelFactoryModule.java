package com.navi.assignment.app.di.modules;

import androidx.lifecycle.ViewModelProvider;
import com.navi.assignment.app.common.ViewModelProviderFactory;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}