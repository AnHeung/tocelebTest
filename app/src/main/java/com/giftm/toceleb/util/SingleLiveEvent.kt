package com.giftm.toceleb.util

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

open class SingleLiveEvent<T> : MutableLiveData<T>(){

    private val mPending = AtomicBoolean(false)

    private val TAG by lazy { SingleLiveEvent::class.java.simpleName }

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

        if(hasActiveObservers()){
            Log.w(TAG , "여러개의 Observer가 등록되있지만 단 한개만 알려지고 변합니다.")
        }

        super.observe(owner, Observer {
            if(mPending.compareAndSet(true , false)){
                observer.onChanged(it)
            }
        })
    }

    @MainThread
    override fun setValue(value: T?) {
        mPending.set(true)
        super.setValue(value)
    }

    @MainThread
    fun call(){
        value = null
    }
}