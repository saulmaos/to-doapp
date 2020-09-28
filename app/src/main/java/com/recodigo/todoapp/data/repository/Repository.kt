package com.recodigo.todoapp.data.repository

import com.recodigo.todoapp.data.local.db.TaskDB
import com.recodigo.todoapp.data.local.db.entity.TaskEntity

/**
 * Created by SAUL on 28/09/2020.
 */
class Repository(private val taskDB: TaskDB) {

    fun saveTask(task: TaskEntity) {
        taskDB.addTask(task)
    }

    fun getTasks() = taskDB.getAllTasks()

}