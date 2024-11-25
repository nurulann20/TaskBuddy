package com.example.taskbuddy2

import androidx.lifecycle.LiveData

class TaskRepository(private val taskLocalSource: TaskLocalSource) {
    val allTask : LiveData<List<Task>> = taskLocalSource.getAllTask()

    fun insertTask(task: Task) {
        taskLocalSource.insert(task)
    }

    suspend fun updateTask(task: Task){
        taskLocalSource.update(task)
    }
}