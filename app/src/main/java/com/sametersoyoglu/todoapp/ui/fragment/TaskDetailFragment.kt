package com.sametersoyoglu.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sametersoyoglu.todoapp.R
import com.sametersoyoglu.todoapp.databinding.FragmentTaskDetailBinding
import com.sametersoyoglu.todoapp.ui.viewmodel.TaskDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class TaskDetailFragment : Fragment() {

    private lateinit var binding: FragmentTaskDetailBinding
    private lateinit var viewModel: TaskDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewModeli bağlama - onCreate içersinde olur bu işlem
        val tempViewModel : TaskDetailViewModel by viewModels() // gecici bir viewmodele atayıp ordan bizim viewmodelimize bağlarız.
        viewModel = tempViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_task_detail,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailTaskFragment = this
        binding.detailTaskToolbarTitle = "To-do Detail"

        val bundle: TaskDetailFragmentArgs by navArgs()
        val receivedTask = bundle.task
        binding.taskObject = receivedTask

    }

    fun buttonUpdate(task_id:Int,task_name:String) {
        viewModel.update(task_id,task_name)
    }

}