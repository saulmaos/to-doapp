package com.recodigo.todoapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.recodigo.todoapp.MainViewModel
import com.recodigo.todoapp.data.repository.Repository

/**
 * Created by SAUL on 28/09/2020.
 */
class ViewModelProviderFactory(
    private val repository: Repository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}