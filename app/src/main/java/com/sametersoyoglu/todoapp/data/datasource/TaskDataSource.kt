package com.sametersoyoglu.todoapp.data.datasource

import android.util.Log
import com.sametersoyoglu.todoapp.data.entity.Task
import com.sametersoyoglu.todoapp.room.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar

class TaskDataSource(var taskDao: TaskDao){

    suspend fun loadTasksList() : List<Task> =
        withContext(Dispatchers.IO){
            return@withContext taskDao.loadTasksList()
        }

    suspend fun search(searchWord: String) : List<Task> =
        withContext(Dispatchers.IO){
            return@withContext taskDao.search(searchWord)
        }

    suspend fun save(task_title:String,task_description:String) {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd-MM-yyyy | HH:mm")
        val taskDate = formatter.format(time)

        val newTask = Task(0,task_title,task_description,taskDate)
        taskDao.save(newTask)
    }

    suspend fun update(task_id:Int,task_title:String,task_description:String) {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd-MM-yyyy | HH:mm")
        val taskDate = formatter.format(time)

        val updateTask = Task(task_id,task_title,task_description,taskDate)
        taskDao.update(updateTask)
    }

    suspend fun delete(task_id:Int) {
        val deleteTask = Task(task_id,"","","")
        taskDao.delete(deleteTask)
    }
}