package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.repository.StudentRepositoryOne

class RateRestaurantViewModelFactory(private val repository: StudentRepositoryOne) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StudentViewModel(repository) as T
    }
}