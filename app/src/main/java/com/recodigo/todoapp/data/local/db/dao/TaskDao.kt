package com.recodigo.todoapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.recodigo.todoapp.data.local.db.entity.TaskEntity

/**
 * Created by SAUL on 23/10/2020.
 */
@Dao
interface TaskDao {
    @Insert
    fun insert(task: TaskEntity)

    @Update
    fun update(task: TaskEntity)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): List<TaskEntity>
}