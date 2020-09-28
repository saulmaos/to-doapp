package com.recodigo.todoapp.ui.mainActivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.recodigo.todoapp.R
import com.recodigo.todoapp.data.local.db.entity.TaskEntity
import kotlinx.android.synthetic.main.card_view_task.view.*

/**
 * Created by SAUL on 28/09/2020.
 */
class TaskAdapter(private val tasks: ArrayList<TaskEntity>
): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_task,
            parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    fun addTasks(newTasks: ArrayList<TaskEntity>) {
        tasks.clear()
        tasks.addAll(newTasks)
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(task: TaskEntity) {
            itemView.tvTask.text = task.task
            itemView.tvDate.text = task.date
        }
    }
}
