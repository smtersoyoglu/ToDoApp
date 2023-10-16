package com.sametersoyoglu.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sametersoyoglu.todoapp.data.entity.Task
import com.sametersoyoglu.todoapp.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var taskRepository : TaskRepository) : ViewModel() {
    var taskList = MutableLiveData<List<Task>>()

    // init HomeViewModel'in oluşturulduğu anda çalış demek.
    init {// HomeViewModel ilk çalıştığı anda loadTaskList() fonksiyonunu çalıştırsın ve bana verileri getirsin demek.
        // init kullanırız. bunu yapmazsak uygulama ilk açıldığında veri getirmez. uygulama ilk açıldığında otomatik olarak verileri çekmek istediğimizden bunu yaparız.
        loadTasksList()
    }
    fun delete(task_id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            taskRepository.delete(task_id)
            loadTasksList()
        }
    }

    fun loadTasksList() {
        CoroutineScope(Dispatchers.Main).launch {
            taskList.value = taskRepository.loadTasksList()
        }
    }

    fun search(searchWord: String) {
        CoroutineScope(Dispatchers.Main).launch {
            taskList.value = taskRepository.search(searchWord)
        }
    }
}