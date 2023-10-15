package com.sametersoyoglu.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sametersoyoglu.todoapp.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskDetailViewModel @Inject constructor(var taskRepository : TaskRepository) : ViewModel() {

    fun update(task_id:Int,task_name:String) {
        CoroutineScope(Dispatchers.Main).launch {
            taskRepository.update(task_id,task_name)
        }
    }


}