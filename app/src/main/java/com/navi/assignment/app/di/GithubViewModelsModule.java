package com.navi.assignment.app.di;

import androidx.lifecycle.ViewModel;

import com.navi.assignment.app.common.ViewModelKey;
import com.navi.assignment.app.ui.GithubViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class GithubViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(GithubViewModel.class)
    public abstract ViewModel bindsGithubViewModel(GithubViewModel viewModel);
}