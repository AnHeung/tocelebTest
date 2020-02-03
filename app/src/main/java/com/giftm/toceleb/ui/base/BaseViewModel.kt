package com.giftm.toceleb.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val isProgress: MutableLiveData<Boolean>? = MutableLiveData()
    val isVisible: MutableLiveData<Boolean>? = MutableLiveData()
    val loginText: MutableLiveData<String>? = MutableLiveData()
    val errorMsg: MutableLiveData<String>? = MutableLiveData()


    operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) compositeDisposable.clear()
    }
}