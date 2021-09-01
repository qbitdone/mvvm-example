package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Student
import com.example.myapplication.model.StudentDatabase
import com.example.myapplication.repository.StudentRepositoryOne
import com.example.myapplication.viewmodel.RateRestaurantViewModelFactory
import com.example.myapplication.viewmodel.StudentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = StudentRepositoryOne(StudentDatabase(context = this))
        val viewModelFactory = RateRestaurantViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(StudentViewModel::class.java)

        val studentAdapter = StudentAdapter()

        binding.apply {
            recyclerViewStudents.apply {
                adapter = studentAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

        viewModel.getAllStudents()

        viewModel.studentList.observe(this,{ students ->
            studentAdapter.submitList(students)
            Log.d("Student", students.toString())
        })
        binding.buttonInsert.setOnClickListener {
            var insertStudent = Student(binding.editTextTextStudentName.text.toString(), binding.editTextStudentSurname.text.toString(), 55)
            viewModel.insertStudent(insertStudent)
            viewModel.getAllStudents()
        }
    }
}


