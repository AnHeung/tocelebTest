package com.giftm.toceleb.di.module

import com.androidnetworking.gsonparserfactory.GsonParserFactory
import com.giftm.toceleb.data.remote.ApiHelper
import com.giftm.toceleb.data.remote.AppApiHelper
import com.giftm.toceleb.util.apiHelper
import com.giftm.toceleb.util.gson
import com.google.gson.GsonBuilder
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val apiModule: Module = module {


    single(named(apiHelper)){
        AppApiHelper() as ApiHelper
    }

    //gson 빌더
    single(named(gson)) {
        GsonBuilder()
            .setLenient()
            .create()
    }

    //gsonFactory
    single {
        GsonParserFactory(get(named(gson)))
    }


}