package com.sametersoyoglu.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sametersoyoglu.todoapp.data.entity.Task
import com.sametersoyoglu.todoapp.databinding.TaskRowBinding
import com.sametersoyoglu.todoapp.ui.fragment.HomeFragmentDirections

class TaskListAdapter (var mContext:Context, var taskList: List<Task> ) : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {
    inner class TaskViewHolder(var binding: TaskRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
       val binding = TaskRowBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return TaskViewHolder(binding)
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList.get(position)
        val t = holder.binding

        t.textViewTask.text = task.task_description

        t.cardViewRow.setOnClickListener {
            val action = HomeFragmentDirections.homeFragmentTotaskDetailFragment(task = task)
            Navigation.findNavController(it).navigate(action)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${task.task_description} Delete this task?", Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    delete(task.task_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun delete(task_id:Int) {
        Log.e("Task Delete",task_id.toString())
    }
}