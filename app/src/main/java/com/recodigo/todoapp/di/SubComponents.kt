package com.recodigo.todoapp.di

import com.recodigo.todoapp.ui.addTaskActivity.di.AddTaskComponent
import com.recodigo.todoapp.ui.mainActivity.di.MainComponent
import dagger.Module

/**
 * Created by SAUL on 05/02/2021.
 */
@Module(subcomponents = [MainComponent::class, AddTaskComponent::class])
class SubComponents