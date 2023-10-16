package com.sametersoyoglu.todoapp.data.datasource

import android.util.Log
import com.sametersoyoglu.todoapp.data.entity.Task
import com.sametersoyoglu.todoapp.room.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskDataSource(var taskDao: TaskDao){

    suspend fun loadTasksList() : List<Task> =
        withContext(Dispatchers.IO){
            return@withContext taskDao.loadTasksList()
        }

    suspend fun search(searchWord: String) : List<Task> =
        withContext(Dispatchers.IO){
            return@withContext taskDao.search(searchWord)
        }

    suspend fun save(task_title:String,task_description:String,task_date:String) {
        val newTask = Task(0,task_title,task_description,task_date)
        taskDao.save(newTask)
    }

    suspend fun update(task_id:Int,task_title:String,task_description:String,task_date:String) {
        val updateTask = Task(task_id,task_title,task_description,task_date)
        taskDao.update(updateTask)
    }

    suspend fun delete(task_id:Int) {
        val deleteTask = Task(task_id,"","","")
        taskDao.delete(deleteTask)
    }
}