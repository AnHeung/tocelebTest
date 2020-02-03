package com.giftm.toceleb.ui.splashviewpager

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.giftm.toceleb.R
import com.giftm.toceleb.databinding.FragmentSplashViewPagerBinding
import com.giftm.toceleb.di.ViewModelProviderFactory
import com.giftm.toceleb.ui.adapter.PagerRecyclerAdapter
import com.giftm.toceleb.ui.base.BaseFragment
import com.giftm.toceleb.util.splashViewPagerViewModelFactory
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class SplashViewPagerFragment : BaseFragment<FragmentSplashViewPagerBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_splash_view_pager

    private val pagerAdapter: PagerRecyclerAdapter by inject()

    private val viewModelFactory: ViewModelProviderFactory<SplashViewPagerViewModel> by inject(named(splashViewPagerViewModelFactory))

    private val splashViewPagerViewModel by lazy {
        ViewModelProvider(
            viewModelStore,
            viewModelFactory
        ).get(SplashViewPagerViewModel::class.java)
    }


    override fun initBindingData() {
        with(dataBinding) {
            fragment = this@SplashViewPagerFragment
            viewmodel = splashViewPagerViewModel
            pagerAdapter.setViewModel(splashViewPagerViewModel)
            viewpagerAdapter = pagerAdapter

            splashViewPagerViewModel.nextClickListener.observe(
                this@SplashViewPagerFragment,
                Observer {
                    when (it) {
                        3 -> startNavigation(R.id.action_splashViewPagerFragment_to_loginFragment)
                        else -> splashViewpager.currentItem = it
                    }
                })

            splashViewPagerViewModel.skipClickListener.observe(
                this@SplashViewPagerFragment,
                Observer {
                    splashViewpager.currentItem = it
                })
        }
    }

    override fun isAdjustActivity(): Boolean = false

}
