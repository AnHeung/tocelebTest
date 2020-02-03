package com.giftm.toceleb.di.module

import com.giftm.toceleb.di.ViewModelProviderFactory
import com.giftm.toceleb.ui.login.LoginViewModel
import com.giftm.toceleb.util.dataManger
import com.giftm.toceleb.util.loginViewModelFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module

val loginModule = module {

    factory {
        LoginViewModel(get(named(dataManger)))
    }

    factory(named(loginViewModelFactory)) {
        ViewModelProviderFactory<LoginViewModel>(get())
    }
}