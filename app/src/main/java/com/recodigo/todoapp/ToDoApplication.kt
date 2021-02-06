package com.recodigo.todoapp

import android.app.Application
import com.recodigo.todoapp.data.local.db.AppDatabase
import com.recodigo.todoapp.data.repository.Repository
import com.recodigo.todoapp.di.ApplicationComponent
import com.recodigo.todoapp.di.DaggerApplicationComponent

/**
 * Created by SAUL on 28/09/2020.
 */
class ToDoApplication: Application() {

//    lateinit var repository: Repository
//
//    override fun onCreate() {
//        super.onCreate()
//
//        repository = Repository(AppDatabase.getDatabase(applicationContext))
//    }

    // remember to build your project or DaggerApplicationComponent won't appear
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}