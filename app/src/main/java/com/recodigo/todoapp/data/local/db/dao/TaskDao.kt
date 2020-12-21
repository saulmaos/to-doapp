package com.recodigo.todoapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.recodigo.todoapp.data.local.db.entity.TaskEntity
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by SAUL on 23/10/2020.
 */
@Dao
interface TaskDao {
    @Insert
    fun insert(task: TaskEntity): Completable

    @Update
    fun update(task: TaskEntity): Completable

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flowable<List<TaskEntity>>
}