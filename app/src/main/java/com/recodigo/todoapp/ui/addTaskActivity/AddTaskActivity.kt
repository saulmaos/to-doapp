package com.recodigo.todoapp.ui.addTaskActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.recodigo.todoapp.R
import com.recodigo.todoapp.ToDoApplication
import com.recodigo.todoapp.data.local.db.entity.TaskEntity
import com.recodigo.todoapp.utils.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_add_task.*
import javax.inject.Inject

class AddTaskActivity : AppCompatActivity() {

    @Inject
    lateinit var addTaskViewModel: AddTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ToDoApplication).applicationComponent
            .getDetailComponent()
            .create(this)
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        setListeners()
        setObservers()
        setInitialValuesIfPossible()
    }

    private fun setListeners() {
        btnSave.setOnClickListener {
            addTaskViewModel.onBtnSavePressed(etTask.text.toString(), etDate.text.toString(), cbTaskFinished.isChecked)
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
        addTaskViewModel.updateTaskFields.observe(this, Observer {
            etTask.setText(it.task)
            etDate.setText(it.date)
            cbTaskFinished.isChecked = it.completed
        })
    }

    private fun setInitialValuesIfPossible() {
        addTaskViewModel.onInitValues(intent.getSerializableExtra(AddTaskViewModel.INTENT_TASK) as TaskEntity?)
    }
}