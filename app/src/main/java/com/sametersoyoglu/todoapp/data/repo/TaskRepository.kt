package com.sametersoyoglu.todoapp.data.repo

import com.sametersoyoglu.todoapp.data.datasource.TaskDataSource
import com.sametersoyoglu.todoapp.data.entity.Task

class TaskRepository (var taskDataSource : TaskDataSource){

    suspend fun save(task_name:String) = taskDataSource.save(task_name)

    suspend fun update(task_id:Int,task_name:String) = taskDataSource.update(task_id,task_name)

    suspend fun delete(task_id:Int) = taskDataSource.delete(task_id)

    suspend fun loadTasksList() : List<Task> = taskDataSource.loadTasksList()

    suspend fun search(searchWord: String) : List<Task> = taskDataSource.search(searchWord)
}