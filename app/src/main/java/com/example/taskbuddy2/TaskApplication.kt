package com.example.taskbuddy2

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class TaskApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val dataBase by lazy { TaskDatabase.getDatabase(this) }
    private val taskLocalSource by lazy { TaskLocalSource(dataBase.taskDao()) }
    val taskRepository by lazy { TaskRepository(taskLocalSource) }
}