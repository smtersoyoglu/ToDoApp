package com.sametersoyoglu.todoapp.data.entity

import java.io.Serializable

data class Task (var task_id : Int,
                 var task_description:String) : Serializable {
}