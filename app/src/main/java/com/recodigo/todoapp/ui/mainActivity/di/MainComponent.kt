package com.recodigo.todoapp.ui.mainActivity.di

import com.recodigo.todoapp.ui.mainActivity.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by SAUL on 05/02/2021.
 */
@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: MainActivity): MainComponent
    }
}