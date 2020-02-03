package com.giftm.toceleb.ui.splashviewpager

import androidx.lifecycle.MutableLiveData
import com.giftm.toceleb.ui.base.BaseViewModel

class SplashViewPagerViewModel : BaseViewModel() {

    val nextClickListener: MutableLiveData<Int> = MutableLiveData(0)
    val skipClickListener: MutableLiveData<Int> = MutableLiveData(0)

}