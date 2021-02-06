package com.recodigo.todoapp.ui.mainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.recodigo.todoapp.R
import com.recodigo.todoapp.ToDoApplication
import com.recodigo.todoapp.ui.addTaskActivity.AddTaskActivity
import com.recodigo.todoapp.ui.addTaskActivity.AddTaskViewModel
import com.recodigo.todoapp.ui.mainActivity.adapter.TaskAdapter
import com.recodigo.todoapp.utils.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ToDoApplication).applicationComponent
            .getMainComponent()
            .create(this)
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()

        setAdapter()
        setObservers()

        mainViewModel.getTasks()
    }

    private fun setListeners() {
        fabCreateTask.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }

    private fun setAdapter() {
        taskAdapter = TaskAdapter(ArrayList()) { task ->
            val intent = Intent(this, AddTaskActivity::class.java).apply {
                putExtra(AddTaskViewModel.INTENT_TASK, task)
            }
            startActivity(intent)
        }

        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }

    private fun setObservers() {
        mainViewModel.tasks.observe(this, Observer {
            taskAdapter.addTasks(it)
        })
    }
}