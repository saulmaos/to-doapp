package com.recodigo.todoapp.ui.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.recodigo.todoapp.R
import com.recodigo.todoapp.data.local.db.entity.TaskEntity
import com.recodigo.todoapp.data.repository.Repository

/**
 * Created by SAUL on 28/09/2020.
 */
class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _tasks: MutableLiveData<List<Any>> = MutableLiveData()
    val tasks: LiveData<List<Any>> = _tasks

    fun getTasks() {
        val savedTasks = repository.getTasks()
        _tasks.postValue(addStatus(savedTasks))
    }

    private fun addStatus(tasks: List<TaskEntity>): List<Any> {
        val completedTasks = ArrayList<TaskEntity>()
        val activeTasks = ArrayList<TaskEntity>()
        tasks.forEach { task ->
            if (task.completed)
                completedTasks.add(task)
            else
                activeTasks.add(task)
        }
        val tasksAndStatus = ArrayList<Any>()
        if (activeTasks.isNotEmpty()) {
            tasksAndStatus.add(R.string.tasks_status_active)
            tasksAndStatus.addAll(activeTasks)
        }
        if (completedTasks.isNotEmpty()) {
            tasksAndStatus.add(R.string.tasks_status_completed)
            tasksAndStatus.addAll(completedTasks)
        }
        return tasksAndStatus.toList()
    }
}