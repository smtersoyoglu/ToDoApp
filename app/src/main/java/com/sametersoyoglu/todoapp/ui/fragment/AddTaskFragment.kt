package com.sametersoyoglu.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sametersoyoglu.todoapp.R
import com.sametersoyoglu.todoapp.databinding.FragmentAddTaskBinding

class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarAddTask.title = "To-do Record"

        binding.buttonSave.setOnClickListener {
            val task_name = binding.editTextTask.text.toString()
            save(task_name)
        }
    }

    fun save(task_name:String) {
        Log.e("To-do record","$task_name")
    }
}