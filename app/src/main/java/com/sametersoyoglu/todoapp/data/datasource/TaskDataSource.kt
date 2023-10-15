package com.sametersoyoglu.todoapp.data.datasource

import android.util.Log

class TaskDataSource {

    suspend fun save(task_name:String) {
        Log.e("To-do record","$task_name")
    }

    suspend fun update(task_id:Int,task_name:String) {
        Log.e("To-do Detail","$task_id - $task_name")
    }
}