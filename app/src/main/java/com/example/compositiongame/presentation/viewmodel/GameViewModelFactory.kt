package com.example.compositiongame.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.compositiongame.domain.entities.Level

/** Used to send params into ViewModel's primary constructor */
class GameViewModelFactory(
    private val application: Application,
    private val level: Level
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java))
            return GameViewModel(application, level) as T
        else
            throw RuntimeException("Unknown ViewModel class $modelClass")
    }

}