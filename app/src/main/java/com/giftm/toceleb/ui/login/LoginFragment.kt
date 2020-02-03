package com.giftm.toceleb.ui.login

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.giftm.toceleb.R
import com.giftm.toceleb.databinding.FragmentLoginBinding
import com.giftm.toceleb.di.ViewModelProviderFactory
import com.giftm.toceleb.ui.base.BaseFragment
import com.giftm.toceleb.util.hideKeyBoard
import com.giftm.toceleb.util.loginViewModelFactory
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModelFactory: ViewModelProviderFactory<LoginViewModel> by inject(
        named(
            loginViewModelFactory
        )
    )
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(viewModelStore, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun isAdjustActivity(): Boolean = true

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun initBindingData() {
        with(dataBinding) {
            fragment = this@LoginFragment
            loginViewModel = viewModel

            viewModel.run {

                isClick?.observe(this@LoginFragment, Observer { isClick ->
                    if (isClick) context?.hideKeyBoard(loginPwEdtxt)
                })

                errorMsg?.observe(this@LoginFragment , Observer {
                    showToast(it)
                })

                loginBegin?.observe(this@LoginFragment , Observer {
                    startNavigation(R.id.action_loginFragment_to_mainFragment)
                })

            }


        }
    }
}
