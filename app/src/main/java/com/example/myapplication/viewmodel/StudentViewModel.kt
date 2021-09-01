package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Student
import com.example.myapplication.repository.StudentRepositoryOne
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: StudentRepositoryOne): ViewModel() {

    val studentList = MutableLiveData<List<Student>>()

    fun getAllStudents(){
        viewModelScope.launch {
            studentList.value = repository.getAlLlStudents()
        }
    }

    fun deleteStudent(student: Student){
        viewModelScope.launch {
            repository.deleteStudent(student)
        }
    }

    fun insertStudent(student: Student){
        viewModelScope.launch {
            repository.insertStudent(student)
        }
    }


}