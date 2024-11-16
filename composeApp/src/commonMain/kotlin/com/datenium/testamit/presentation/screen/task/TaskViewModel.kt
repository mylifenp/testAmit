package com.datenium.testamit.presentation.screen.task

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.datenium.testamit.data.MongoDB
import com.datenium.testamit.domain.TaskAction
import com.datenium.testamit.domain.ToDoTask
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class TaskViewModel(private val mongoDB: MongoDB):ScreenModel {
    fun setAction(action: TaskAction) {
        when (action) {
            is TaskAction.Add -> {
                addTask(action.task)
            }
            is TaskAction.Update -> {
                updateTask(action.task)
            }
            else -> {}
        }
    }

    private fun addTask(task: ToDoTask) {
        screenModelScope.launch(Dispatchers.IO) {
            mongoDB.addTask(task)
        }
    }

    private fun updateTask(task: ToDoTask) {
        screenModelScope.launch(Dispatchers.IO) {
            mongoDB.updateTask(task)
        }
    }
}