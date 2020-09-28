package com.recodigo.todoapp.data.local.db

import com.recodigo.todoapp.data.local.db.entity.TaskEntity

/**
 * Created by SAUL on 28/09/2020.
 */
class TaskDB {
    private val tasks: ArrayList<TaskEntity> = ArrayList()

    fun addTask(task: TaskEntity) {
        tasks.add(task)
    }

    fun getAllTasks() = tasks
}