package com.sametersoyoglu.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sametersoyoglu.todoapp.data.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDataBase : RoomDatabase(){

    abstract fun getTaskDao() : TaskDao
}