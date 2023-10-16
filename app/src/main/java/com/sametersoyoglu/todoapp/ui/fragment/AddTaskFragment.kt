package com.sametersoyoglu.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.sametersoyoglu.todoapp.R
import com.sametersoyoglu.todoapp.databinding.FragmentAddTaskBinding
import com.sametersoyoglu.todoapp.ui.viewmodel.AddTaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar

@AndroidEntryPoint
class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private lateinit var viewModel: AddTaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewModeli bağlama - onCreate içersinde olur bu işlem
        val tempViewModel : AddTaskViewModel by viewModels() // gecici bir viewmodele atayıp ordan bizim viewmodelimize bağlarız.
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_task,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addTaskFragment = this
        binding.addTaskToolbarTitle = "To-do Record"
    }

    fun buttonSave(task_title:String,task_description:String,task_date:String) {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd-MM-yyyy | HH:mm ")
        val taskCreatedTime = formatter.format(time)

        viewModel.save(task_title,task_description,task_date)
    }
}