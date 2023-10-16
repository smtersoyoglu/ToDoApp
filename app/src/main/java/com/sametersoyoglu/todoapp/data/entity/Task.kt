package com.sametersoyoglu.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "task")
data class Task (@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name = "task_id") var task_id : Int,
                 @ColumnInfo(name = "task_title") var task_title:String,
                 @ColumnInfo(name = "task_description") var task_description:String,
                 @ColumnInfo(name = "task_date") var task_date:String) : Serializable
