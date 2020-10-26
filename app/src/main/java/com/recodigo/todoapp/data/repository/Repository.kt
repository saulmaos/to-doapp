package com.recodigo.todoapp.data.repository

import com.recodigo.todoapp.data.local.db.AppDatabase
import com.recodigo.todoapp.data.local.db.entity.TaskEntity

/**
 * Created by SAUL on 28/09/2020.
 */
class Repository(private val taskDB: AppDatabase) {

    fun saveTask(task: TaskEntity) {
        if (task.id == 0L) taskDB.taskDao.insert(task)
        else taskDB.taskDao.update(task)
    }

    fun getTasks() = taskDB.taskDao.getAllTasks()

}