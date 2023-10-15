package com.sametersoyoglu.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sametersoyoglu.todoapp.data.repo.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddTaskViewModel : ViewModel() {
    var taskRepository = TaskRepository()

    fun save(task_name:String) {
        CoroutineScope(Dispatchers.Main).launch {
            taskRepository.save(task_name)
        }
    }

}