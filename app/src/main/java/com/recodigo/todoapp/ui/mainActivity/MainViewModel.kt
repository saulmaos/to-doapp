package com.recodigo.todoapp.ui.mainActivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.recodigo.todoapp.data.local.db.entity.TaskEntity
import com.recodigo.todoapp.data.repository.Repository

/**
 * Created by SAUL on 28/09/2020.
 */
class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _tasks: MutableLiveData<ArrayList<TaskEntity>> = MutableLiveData()
    val tasks: LiveData<ArrayList<TaskEntity>> = _tasks

    fun getTasks() {
        val savedTasks = repository.getTasks()
        _tasks.postValue(savedTasks)
    }
}