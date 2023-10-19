package com.sametersoyoglu.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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

        // Enable the back button (home button) in the Toolbar
        val toolbar = binding.toolbarDetail
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Handle the back button press
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

    }
    fun buttonUpdate(task_id:Int,task_title:String,task_description:String) {
        if (task_title.isBlank() || task_description.isBlank()) {
            Toast.makeText(requireContext(),"Task title and description cannot be empty!", Toast.LENGTH_SHORT).show()
        }else{
            viewModel.update(task_id,task_title,task_description)
            val action = TaskDetailFragmentDirections.taskDetailFragmentTohomeFragment()
            findNavController().navigate(action)
        }
    }
}