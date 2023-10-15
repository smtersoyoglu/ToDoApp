package com.sametersoyoglu.todoapp.data.repo

import com.sametersoyoglu.todoapp.data.datasource.TaskDataSource

class TaskRepository {
    var taskDataSource = TaskDataSource()

    suspend fun save(task_name:String) = taskDataSource.save(task_name)

    suspend fun update(task_id:Int,task_name:String) = taskDataSource.update(task_id,task_name)
}