package com.recodigo.todoapp.ui.addTaskActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.recodigo.todoapp.R
import com.recodigo.todoapp.data.local.db.entity.TaskEntity
import com.recodigo.todoapp.data.repository.Repository

/**
 * Created by SAUL on 28/09/2020.
 */
class AddTaskViewModel(private val repository: Repository) : ViewModel() {
    companion object {
        const val INTENT_TASK = "intent_task"
    }

    private val _taskTitleError: MutableLiveData<Int> = MutableLiveData()
    val taskTitleError: LiveData<Int> = _taskTitleError

    private val _taskDateError: MutableLiveData<Int> = MutableLiveData()
    val taskDateError: LiveData<Int> = _taskDateError

    private val _updateTaskFields: MutableLiveData<TaskEntity> = MutableLiveData()
    val updateTaskFields: LiveData<TaskEntity> = _updateTaskFields

    // This will modified in the future
    private val _finish: MutableLiveData<Boolean> = MutableLiveData()
    val finish: LiveData<Boolean> = _finish

    fun onInitValues(task: TaskEntity?) {
        task?.let {
            _updateTaskFields.postValue(it)
        } ?: _updateTaskFields.postValue(TaskEntity(task = "", date = "", completed = false))
    }

    fun onBtnSavePressed(taskTitle: String, date: String, completed: Boolean) {
        if (taskTitle.isEmpty()) {
            _taskTitleError.postValue(R.string.error_task_title_empty)
            return
        }
        if (date.isEmpty()) {
            _taskDateError.postValue(R.string.error_task_date_empty)
            return
        }
        updateTaskFields.value?.let { task ->
            task.task = taskTitle
            task.date = date
            task.completed = completed
            repository.saveTask(task)
        }
        _finish.postValue(true)
    }
}