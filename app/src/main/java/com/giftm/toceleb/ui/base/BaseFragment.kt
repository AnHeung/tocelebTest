package com.giftm.toceleb.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.giftm.toceleb.util.getSoftInputMode

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    protected lateinit var dataBinding: T

    private lateinit var navController: NavController

    private var originalMode: Int? = null

    abstract fun getLayoutId(): Int

    abstract fun initBindingData()

    abstract fun isAdjustActivity(): Boolean

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return with(dataBinding) {
            lifecycleOwner = this@BaseFragment
            initBindingData()
            executePendingBindings()
            dataBinding.root
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isAdjustActivity()) {
            originalMode = activity?.window?.getSoftInputMode()
            activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    fun startNavigation(@IdRes navigationId: Int?) {
        navigationId?.let {
            navController.navigate(navigationId)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        originalMode?.let { activity?.window?.setSoftInputMode(it) }
    }

    fun showToast(msg: String?) {
        msg?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }
}