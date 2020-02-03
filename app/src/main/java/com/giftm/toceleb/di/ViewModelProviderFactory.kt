package com.giftm.toceleb.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelProviderFactory<V : ViewModel>(private val viewModel: V) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(viewModel::class.java)){
            return viewModel as T
        }
        throw IllegalArgumentException("클래스 이름 없음")
    }
}