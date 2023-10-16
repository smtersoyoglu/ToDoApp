package com.sametersoyoglu.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sametersoyoglu.todoapp.R
import com.sametersoyoglu.todoapp.data.entity.Task
import com.sametersoyoglu.todoapp.databinding.TaskRowBinding
import com.sametersoyoglu.todoapp.ui.fragment.HomeFragmentDirections
import com.sametersoyoglu.todoapp.ui.viewmodel.HomeViewModel

class TaskListAdapter (var mContext:Context, var taskList: List<Task>, var viewModel: HomeViewModel) : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {
    inner class TaskViewHolder(var binding: TaskRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
       val binding: TaskRowBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.task_row,parent,false)
        return TaskViewHolder(binding)
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList.get(position)
        val t = holder.binding

        t.taskObject = task

        //t.taskObject.task_date = task.task_date
        t.textViewDate.text = task.task_date

        t.cardViewRow.setOnClickListener {
            val action = HomeFragmentDirections.homeFragmentTotaskDetailFragment(task = task)
            Navigation.findNavController(it).navigate(action)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${task.task_description} Delete this task?", Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    viewModel.delete(task.task_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}