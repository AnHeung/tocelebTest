package com.giftm.toceleb.di.module

import com.giftm.toceleb.ui.splash.SplashViewModel
import com.giftm.toceleb.di.ViewModelProviderFactory
import com.giftm.toceleb.util.dataManger
import com.giftm.toceleb.util.splashViewModelFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module

val splashModule = module {

    factory {
        SplashViewModel(get(named(dataManger)))
    }

    factory (named(splashViewModelFactory)){
        ViewModelProviderFactory<SplashViewModel>(get())
    }
}