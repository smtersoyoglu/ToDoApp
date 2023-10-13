package com.sametersoyoglu.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sametersoyoglu.todoapp.R
import com.sametersoyoglu.todoapp.data.entity.Task
import com.sametersoyoglu.todoapp.databinding.FragmentHomeBinding
import com.sametersoyoglu.todoapp.ui.adapter.TaskListAdapter


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarHome.title = "To Do List"

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val taskList = ArrayList<Task>()
        val t1 = Task(1,"Ödevlerini yap")
        val t2 = Task(2,"Film izle")
        val t3 = Task(3,"Spor yap")
        taskList.add(t1)
        taskList.add(t2)
        taskList.add(t3)

        val taskListAdapter = TaskListAdapter(requireContext(),taskList)
        binding.recyclerView.adapter = taskListAdapter


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean { // arama iconuna bastığımız zaman sonuç getirir.
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean { //harf girdikçe harf sildikce sonuç getirir.
                search(newText)
                return true
            }

        })


        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.homeFragmentToaddTaskFragment)
        }

    }

    fun search(searchWord: String) {
        Log.e("Task search", searchWord)

    }

}