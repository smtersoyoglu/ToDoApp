package com.sametersoyoglu.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sametersoyoglu.todoapp.data.entity.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    suspend fun loadTasksList() : List<Task>

    @Insert
    suspend fun save(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM task WHERE task_title like '½' || :searchWord || '½'")
    suspend fun search(searchWord:String) : List<Task>
}