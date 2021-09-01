package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    val ime: String,
    val prezime: String,
    val godine: Int,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
