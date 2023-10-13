package com.sametersoyoglu.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.sametersoyoglu.todoapp.R
import com.sametersoyoglu.todoapp.databinding.FragmentTaskDetailBinding

class TaskDetailFragment : Fragment() {

    private lateinit var binding: FragmentTaskDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarDetail.title = "To-do Detail"

        val bundle: TaskDetailFragmentArgs by navArgs()
        val receivedTask = bundle.task

        binding.editTextTask.setText(receivedTask.task_description)

        binding.buttonUpdate.setOnClickListener {
            val task_name = binding.editTextTask.text.toString()
            update(receivedTask.task_id,task_name)
        }
    }

    fun update(task_id:Int,task_name:String) {
        Log.e("To-do Detail","$task_id - $task_name")
    }

}