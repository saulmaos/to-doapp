package com.recodigo.todoapp.data.repository

import com.recodigo.todoapp.data.local.db.AppDatabase
import com.recodigo.todoapp.data.local.db.entity.TaskEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by SAUL on 28/09/2020.
 */
class Repository @Inject constructor(private val taskDB: AppDatabase) {

    fun saveTask(task: TaskEntity): Completable {
        return if (task.id == 0L) taskDB.taskDao.insert(task)
        else taskDB.taskDao.update(task)
    }

    fun getTasks(): Flowable<List<TaskEntity>> = taskDB.taskDao.getAllTasks()

}