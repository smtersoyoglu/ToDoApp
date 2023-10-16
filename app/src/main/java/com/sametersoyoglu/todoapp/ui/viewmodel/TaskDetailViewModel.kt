package com.sametersoyoglu.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sametersoyoglu.todoapp.data.repo.TaskRepository
import com.sametersoyoglu.todoapp.room.TaskDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class TaskDetailViewModel @Inject constructor(var taskRepository : TaskRepository) : ViewModel() {

    private  var taskDate: String? = null
    fun update(task_id:Int,task_title:String,task_description:String) {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd-MM-yyyy | HH:mm")
        val taskDate = formatter.format(time)

        // ViewModel'deki tarih bilgisini güncelle
        setTaskDate(taskDate)

        CoroutineScope(Dispatchers.Main).launch {
            taskRepository.save(task_title,task_description)
        }
    }

    fun setTaskDate(date: String) {
        taskDate = date
    }

    fun getTaskDate(): String? {
        return taskDate
    }
}