package com.giftm.toceleb.ui.main

import androidx.lifecycle.ViewModelProvider
import com.giftm.toceleb.R
import com.giftm.toceleb.databinding.FragmentMainBinding
import com.giftm.toceleb.di.ViewModelProviderFactory
import com.giftm.toceleb.ui.base.BaseFragment
import com.giftm.toceleb.util.mainViewModelFactory
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModelFactory: ViewModelProviderFactory<MainViewModel> by inject(named (mainViewModelFactory) )

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(
            viewModelStore,
            viewModelFactory
        ).get(MainViewModel::class.java)


    }

    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun initBindingData() {
        dataBinding.viewModel = mainViewModel
    }

    override fun isAdjustActivity(): Boolean = false

}