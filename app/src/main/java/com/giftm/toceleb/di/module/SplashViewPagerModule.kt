package com.giftm.toceleb.di.module

import com.giftm.toceleb.R
import com.giftm.toceleb.di.ViewModelProviderFactory
import com.giftm.toceleb.ui.adapter.PagerRecyclerAdapter
import com.giftm.toceleb.ui.adapter.PagerViewHolder
import com.giftm.toceleb.ui.splashviewpager.SplashViewPagerViewModel
import com.giftm.toceleb.util.splashViewPagerViewModelFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module

val splashViewPagerModule = module {

    factory {
        SplashViewPagerViewModel()
    }

    factory (named(splashViewPagerViewModelFactory)){
        ViewModelProviderFactory<SplashViewPagerViewModel>(get())
    }

    single {
        PagerRecyclerAdapter(listOf(R.drawable.image_1, R.drawable.image_2, R.drawable.image_3) , PagerViewHolder::class.java , R.layout.item_splash_viewpager)
    }
}