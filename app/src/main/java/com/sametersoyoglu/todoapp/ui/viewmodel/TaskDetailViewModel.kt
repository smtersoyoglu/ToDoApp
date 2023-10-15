package com.sametersoyoglu.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sametersoyoglu.todoapp.data.repo.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskDetailViewModel : ViewModel() {
    var taskRepository = TaskRepository()

    fun update(task_id:Int,task_name:String) {
        CoroutineScope(Dispatchers.Main).launch {
            taskRepository.update(task_id,task_name)
        }
    }


}