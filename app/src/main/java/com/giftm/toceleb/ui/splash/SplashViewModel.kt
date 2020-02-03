package com.giftm.toceleb.ui.splash

import com.giftm.toceleb.data.DataManager
import com.giftm.toceleb.ui.base.BaseViewModel

class SplashViewModel(private val dataManager: DataManager) : BaseViewModel(){

    fun getFirstLaunch() = dataManager.getFistLaunch()

}