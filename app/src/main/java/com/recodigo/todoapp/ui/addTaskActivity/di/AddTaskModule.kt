package com.recodigo.todoapp.ui.addTaskActivity.di

import androidx.lifecycle.ViewModelProvider
import com.recodigo.todoapp.data.repository.Repository
import com.recodigo.todoapp.ui.addTaskActivity.AddTaskActivity
import com.recodigo.todoapp.ui.addTaskActivity.AddTaskViewModel
import com.recodigo.todoapp.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

/**
 * Created by SAUL on 05/02/2021.
 */
@Module
class AddTaskModule {

    @Provides
    fun provideDetailViewModelFactory(
        activity: AddTaskActivity,
        repository: Repository
    ): AddTaskViewModel {
        val factory = ViewModelProviderFactory(repository)
        return ViewModelProvider(activity, factory).get(AddTaskViewModel::class.java)
    }

}