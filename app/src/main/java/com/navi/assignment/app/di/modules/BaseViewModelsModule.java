package com.navi.assignment.app.di.modules;

import androidx.lifecycle.ViewModel;

import com.navi.assignment.app.common.ViewModelKey;
import com.navi.assignment.app.ui.BaseViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class BaseViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(BaseViewModel.class)
    public abstract ViewModel bindsAuthViewModel(BaseViewModel viewModel);
}