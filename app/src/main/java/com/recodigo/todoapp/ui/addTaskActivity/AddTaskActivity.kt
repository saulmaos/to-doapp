package com.recodigo.todoapp.ui.addTaskActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.recodigo.todoapp.R
import com.recodigo.todoapp.data.repository.Repository
import com.recodigo.todoapp.ui.mainActivity.MainViewModel
import com.recodigo.todoapp.utils.ViewModelProviderFactory

class AddTaskActivity : AppCompatActivity() {
    private lateinit var addTaskViewModel: AddTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        createViewModel()
    }

    private fun createViewModel() {
        val repository = Repository()
        val viewModelProviderFactory = ViewModelProviderFactory(repository)

        addTaskViewModel = ViewModelProvider(this, viewModelProviderFactory).get(AddTaskViewModel::class.java)
    }
}