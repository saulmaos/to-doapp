package com.recodigo.todoapp.ui.addTaskActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.recodigo.todoapp.R
import com.recodigo.todoapp.ToDoApplication
import com.recodigo.todoapp.utils.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity() {
    private lateinit var addTaskViewModel: AddTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        createViewModel()
        setListeners()
        setObservers()
    }

    private fun createViewModel() {
        val repository = (application as ToDoApplication).repository
        val viewModelProviderFactory = ViewModelProviderFactory(repository)

        addTaskViewModel = ViewModelProvider(this, viewModelProviderFactory).get(AddTaskViewModel::class.java)
    }

    private fun setListeners() {
        btnSave.setOnClickListener {
            addTaskViewModel.onBtnSavePressed(etTask.text.toString(), etDate.text.toString())
        }
    }

    private fun setObservers() {
        addTaskViewModel.taskTitleError.observe(this, Observer {
            etTask.error = getString(it)
            etTask.requestFocus()
        })
        addTaskViewModel.taskDateError.observe(this, Observer {
            etDate.error = getString(it)
            etDate.requestFocus()
        })
        addTaskViewModel.finish.observe(this, Observer {
            if (it) finish() // this destroys the activity
        })
    }
}