package com.giftm.toceleb.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.giftm.toceleb.R
import com.giftm.toceleb.databinding.FragmentSplashBinding
import com.giftm.toceleb.di.ViewModelProviderFactory
import com.giftm.toceleb.ui.base.BaseFragment
import com.giftm.toceleb.util.splashViewModelFactory
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private val splashFactory: ViewModelProviderFactory<SplashViewModel> by inject(named( splashViewModelFactory ))

    private val SPLASHTIME = 2000L

    private val splashViewModel by lazy {
        ViewModelProvider(viewModelStore, splashFactory).get(SplashViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun initBindingData() {
        with(dataBinding) {
            splashViewModel = splashViewModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            startNavigation(
                when (splashViewModel.getFirstLaunch()) {
                    true -> R.id.action_splashFragment_to_splashViewPagerFragment
                    false -> R.id.action_splashFragment_to_loginFragment
                }
            )
        }, SPLASHTIME)
    }

    override fun isAdjustActivity(): Boolean  = false
}
