package com.sametersoyoglu.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sametersoyoglu.todoapp.R
import com.sametersoyoglu.todoapp.databinding.FragmentHomeBinding
import com.sametersoyoglu.todoapp.ui.adapter.TaskListAdapter
import com.sametersoyoglu.todoapp.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewModeli bağlama - onCreate içersinde olur bu işlem
        val tempViewModel : HomeViewModel by viewModels() // gecici bir viewmodele atayıp ordan bizim viewmodelimize bağlarız.
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeFragment = this
        binding.homeToolbarTitle= "To Do List"


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean { //harf girdikçe harf sildikce sonuç getirir.
                viewModel.search(newText)
                return true
            }
            override fun onQueryTextSubmit(query: String): Boolean { // arama iconuna bastığımız zaman sonuç getirir.
                viewModel.search(query)
                return true
            }
        })

        // LiveData yapısı
        viewModel.taskList.observe(viewLifecycleOwner) {
            val taskListAdapter = TaskListAdapter(requireContext(),it,viewModel)
            binding.taskListAdapter = taskListAdapter
        }

    }
    fun fabClick(it:View) {
        Navigation.findNavController(it).navigate(R.id.homeFragmentToaddTaskFragment)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTasksList()
    }
}