package com.recodigo.todoapp.ui.mainActivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recodigo.todoapp.R
import com.recodigo.todoapp.data.local.db.entity.TaskEntity
import kotlinx.android.synthetic.main.card_view_task.view.*
import kotlinx.android.synthetic.main.card_view_task_stauts.view.*

/**
 * Created by SAUL on 28/09/2020.
 */
class TaskAdapter(
    private val tasks: ArrayList<Any>,
    private val clickListener: (task: TaskEntity) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val LAYOUT_TYPE_STATUS = 0
        const val LAYOUT_TYPE_TASK = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == LAYOUT_TYPE_STATUS) {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.card_view_task_stauts,
                parent, false
            )
            TaskStatusViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.card_view_task,
                parent, false
            )
            TaskViewHolder(view, clickListener)
        }
    }

    override fun getItemCount(): Int = tasks.size

    override fun getItemViewType(position: Int): Int =
        if (tasks[position] is TaskEntity) LAYOUT_TYPE_TASK
        else LAYOUT_TYPE_STATUS

    override fun onBindViewHolder(generalHolder: RecyclerView.ViewHolder, position: Int) {
        if (tasks[position] is TaskEntity) {
            val holder = generalHolder as TaskViewHolder
            holder.bind(tasks[position] as TaskEntity)
        } else {
            val holder = generalHolder as TaskStatusViewHolder
            holder.bind(tasks[position] as Int)
        }
    }

    fun addTasks(newTasks: List<Any>) {
        tasks.clear()
        tasks.addAll(newTasks)
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(itemView: View, val clickListener: (task: TaskEntity) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(task: TaskEntity) {
            itemView.tvTask.text = task.task
            itemView.tvDate.text = task.date
            itemView.setOnClickListener { clickListener(task) }
        }
    }

    inner class TaskStatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(statusId: Int) {
            itemView.tvStatus.setText(statusId)
        }
    }
}
