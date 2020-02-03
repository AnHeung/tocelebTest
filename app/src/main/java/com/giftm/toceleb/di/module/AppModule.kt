package com.giftm.toceleb.di.module

import com.giftm.toceleb.data.AppDataManager
import com.giftm.toceleb.data.DataManager
import com.giftm.toceleb.util.apiHelper
import com.giftm.toceleb.util.dataManger
import com.giftm.toceleb.util.prefHelper
import org.koin.core.qualifier.named
import org.koin.dsl.module

val commonModule = module {
    single(named(dataManger)) {
        AppDataManager(get(named(apiHelper)) , get(named(prefHelper))) as DataManager
    }
}

val appModule = listOf(apiModule, prefModule, commonModule , loginModule
    , splashModule, splashViewPagerModule , mainModule)