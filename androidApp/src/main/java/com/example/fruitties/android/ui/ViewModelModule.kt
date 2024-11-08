package com.example.fruitties.android.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.example.fruitties.di.AppContainer
import com.example.fruitties.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    fun provideMainViewModel(
        appContainer: AppContainer
    ): MainViewModel {
        val viewModelStore = ViewModelStore()
        return ViewModelProvider(
            viewModelStore,
            MainViewModel.Factory // Pass the Factory directly
        )[MainViewModel::class.java]  // Use get() to create the ViewModel
    }
}