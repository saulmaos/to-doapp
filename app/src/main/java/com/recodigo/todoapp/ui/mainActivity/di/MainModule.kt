package com.recodigo.todoapp.ui.mainActivity.di

import androidx.lifecycle.ViewModelProvider
import com.recodigo.todoapp.data.repository.Repository
import com.recodigo.todoapp.ui.mainActivity.MainActivity
import com.recodigo.todoapp.ui.mainActivity.MainViewModel
import com.recodigo.todoapp.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

/**
 * Created by SAUL on 05/02/2021.
 */
@Module
class MainModule {

    @Provides
    fun provideMainViewModel(
        activity: MainActivity,
        repository: Repository
    ): MainViewModel {
        val factory = ViewModelProviderFactory(repository)
        return ViewModelProvider(activity, factory).get(MainViewModel::class.java)
    }
}