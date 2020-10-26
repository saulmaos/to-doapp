package com.recodigo.todoapp.data.local.db.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by SAUL on 28/09/2020.
 */
@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,

    @ColumnInfo(name = "task")
    @NonNull
    var task: String,

    @ColumnInfo(name = "date")
    @NonNull
    var date: String,

    @ColumnInfo(name = "completed")
    @NonNull
    var completed: Boolean = false
): Serializable