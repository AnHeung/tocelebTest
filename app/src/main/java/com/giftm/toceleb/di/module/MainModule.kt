package com.giftm.toceleb.di.module

import com.giftm.toceleb.di.ViewModelProviderFactory
import com.giftm.toceleb.ui.main.MainViewModel
import com.giftm.toceleb.util.dataManger
import com.giftm.toceleb.util.mainViewModelFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module

var mainModule = module {

    factory {
        MainViewModel(get(named(dataManger)))
    }

    factory (named(mainViewModelFactory)){
        ViewModelProviderFactory<MainViewModel>(get())
    }
}