package com.recodigo.todoapp.di

import android.content.Context
import com.recodigo.todoapp.ui.addTaskActivity.di.AddTaskComponent
import com.recodigo.todoapp.ui.mainActivity.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by SAUL on 05/02/2021.
 */
@Singleton
@Component(modules = [ApplicationModule::class, SubComponents::class])
interface ApplicationComponent {

    fun getMainComponent(): MainComponent.Factory

    fun getDetailComponent(): AddTaskComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}