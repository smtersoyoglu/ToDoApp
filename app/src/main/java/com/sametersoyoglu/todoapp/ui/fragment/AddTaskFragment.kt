package com.sametersoyoglu.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sametersoyoglu.todoapp.R
import com.sametersoyoglu.todoapp.data.entity.Task
import com.sametersoyoglu.todoapp.databinding.FragmentAddTaskBinding
import com.sametersoyoglu.todoapp.ui.viewmodel.AddTaskViewModel
import dagger.hilt.android.AndroidEntryPoint


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

        // Enable the back button (home button) in the Toolbar
        val toolbar = binding.toolbarAddTask
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Handle the back button press
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }




    fun buttonSave(task_title:String,task_description:String) {
        if (task_title.isBlank() || task_description.isBlank()) {
            Toast.makeText(requireContext(),"Task title and description cannot be empty!",Toast.LENGTH_SHORT).show()
        }else{
            viewModel.save(task_title,task_description)
            val action = AddTaskFragmentDirections.addTaskFragmentTohomeFragment()
            findNavController().navigate(action)
        }
    }
}