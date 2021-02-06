package com.recodigo.todoapp.ui.addTaskActivity.di

import com.recodigo.todoapp.ui.addTaskActivity.AddTaskActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by SAUL on 05/02/2021.
 */
@Subcomponent(modules = [AddTaskModule::class])
interface AddTaskComponent {

    fun inject(addTaskActivity: AddTaskActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: AddTaskActivity): AddTaskComponent
    }
}