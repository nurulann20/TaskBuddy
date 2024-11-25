package com.example.taskbuddy2

import androidx.lifecycle.LiveData

class TaskLocalSource(private val taskDao: TaskDao) {

    fun getAllTask(): LiveData<List<Task>> {
        return taskDao.getAllTasks()
    }

    fun insert(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun update(task: Task){
        taskDao.updateTask(task)
    }
}