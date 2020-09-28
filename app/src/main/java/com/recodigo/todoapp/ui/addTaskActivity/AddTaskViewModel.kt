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

    private val _taskTitleError: MutableLiveData<Int> = MutableLiveData()
    val taskTitleError: LiveData<Int> = _taskTitleError

    private val _taskDateError: MutableLiveData<Int> = MutableLiveData()
    val taskDateError: LiveData<Int> = _taskDateError

    // This will modified in the future
    private val _finish: MutableLiveData<Boolean> = MutableLiveData()
    val finish: LiveData<Boolean> = _finish

    fun onBtnSavePressed(taskTitle: String, date: String) {
        if (taskTitle.isEmpty()) {
            _taskTitleError.postValue(R.string.error_task_title_empty)
            return
        }
        if (date.isEmpty()) {
            _taskDateError.postValue(R.string.error_task_date_empty)
            return
        }

        val task = TaskEntity(taskTitle, date)
        repository.saveTask(task)
        _finish.postValue(true)
    }
}