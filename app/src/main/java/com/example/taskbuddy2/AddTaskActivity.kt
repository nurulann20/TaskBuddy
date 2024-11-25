package com.example.taskbuddy2

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.taskbuddy2.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTaskBinding
    private val viewModel: TaskViewModel by viewModels {
        TaskViewModelFactory((application as TaskApplication).taskRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate binding
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup save button click listener
        setupSaveButton()
    }

    private fun setupSaveButton() {
        binding.saveButton.setOnClickListener {
            val title = binding.taskTitleInput.text.toString().trim()
            val description = binding.taskDescriptionInput.text.toString().trim()

            when {
                title.isBlank() -> {
                    showToast("Kamu belum memasukkan tugas.")
                }
                else -> {
                    val newTask = Task(
                        title = title,
                        description = description
                    )

                    // Add task
                    viewModel.insertTask(newTask)

                    // Show success message
                    showToast("Tugas telah ditambahkan!")

                    // Close activity
                    finish()
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}