package com.sametersoyoglu.todoapp.data.datasource

import android.util.Log
import com.sametersoyoglu.todoapp.data.entity.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskDataSource {

    suspend fun loadTasksList() : List<Task> =
        withContext(Dispatchers.IO){
            val taskList = ArrayList<Task>()
            val t1 = Task(1,"Ödevlerini yap")
            val t2 = Task(2,"Film izle")
            val t3 = Task(3,"Spor yap")
            taskList.add(t1)
            taskList.add(t2)
            taskList.add(t3)
            return@withContext taskList
        }

    suspend fun search(searchWord: String) : List<Task> =
        withContext(Dispatchers.IO){
            val taskList = ArrayList<Task>()
            val t1 = Task(1,"Ödevlerini yap")
            taskList.add(t1)
            return@withContext taskList
        }

    suspend fun save(task_name:String) {
        Log.e("To-do record","$task_name")
    }

    suspend fun update(task_id:Int,task_name:String) {
        Log.e("To-do Detail","$task_id - $task_name")
    }

    suspend fun delete(task_id:Int) {
        Log.e("Task Delete",task_id.toString())
    }
}