package com.example.fruitties.android.di

import android.app.Application
import android.content.Context
import com.example.fruitties.di.AppContainer
import com.example.fruitties.di.Factory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext app: Context): Application {
        return app as Application
    }

    @Provides
    @Singleton
    fun provideAppContainer(factory: Factory): AppContainer {
        return AppContainer(factory)
    }
}