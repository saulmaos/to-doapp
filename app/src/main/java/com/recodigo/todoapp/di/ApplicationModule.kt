package com.recodigo.todoapp.di

import android.content.Context
import com.recodigo.todoapp.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by SAUL on 05/02/2021.
 */
@Module
class ApplicationModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }
}