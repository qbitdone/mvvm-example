package com.example.myapplication.repository

import com.example.myapplication.model.Student
import com.example.myapplication.model.StudentDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StudentRepositoryOne(val db: StudentDatabase){
    suspend fun getAlLlStudents(): List<Student> {
        return withContext(Dispatchers.IO){
            db.userDao().getAllStudents()
        }
    }

    suspend fun insertStudent(student: Student) {
        withContext(Dispatchers.IO){
            db.userDao().insertStudent(student)
        }
    }

    suspend fun deleteStudent(student: Student) {
        withContext(Dispatchers.IO){
            db.userDao().deleteStudent(student)
        }
    }
}