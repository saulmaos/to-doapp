package com.recodigo.todoapp.ui.mainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.recodigo.todoapp.R
import com.recodigo.todoapp.data.repository.Repository
import com.recodigo.todoapp.ui.addTaskActivity.AddTaskActivity
import com.recodigo.todoapp.utils.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
        createViewModel()
    }

    private fun setListeners() {
        fabCreateTask.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }

    private fun createViewModel() {
        val repository = Repository()
        val viewModelProviderFactory = ViewModelProviderFactory(repository)

        mainViewModel = ViewModelProvider(this, viewModelProviderFactory).get(MainViewModel::class.java)
    }
}