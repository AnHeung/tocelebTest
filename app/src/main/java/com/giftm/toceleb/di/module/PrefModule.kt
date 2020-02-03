package com.giftm.toceleb.di.module

import com.giftm.toceleb.data.local.pref.AppPrefHelper
import com.giftm.toceleb.data.local.pref.PrefHelper
import com.giftm.toceleb.util.PREFNAME
import com.giftm.toceleb.util.prefHelper
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val prefModule: Module = module {

    single(named(prefHelper)) {
        AppPrefHelper(get(), get(named(PREFNAME))) as PrefHelper
    }

    single(named(PREFNAME)) {
        PREFNAME
    }
}