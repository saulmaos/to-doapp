package com.recodigo.todoapp.data.local.db.entity

/**
 * Created by SAUL on 28/09/2020.
 */
data class TaskEntity(
  val task: String,
  val date: String,
  val completed: Boolean = false
)