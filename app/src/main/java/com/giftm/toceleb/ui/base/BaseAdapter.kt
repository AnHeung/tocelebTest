package com.giftm.toceleb.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder, VM : BaseViewModel>(
    private val clazz: Class<VH>,
    @LayoutRes private val layoutId: Int
) : RecyclerView.Adapter<VH>() {

    lateinit var baseViewModel: VM

    fun setViewModel(viewModel: VM) {
        this.baseViewModel = viewModel
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val view: ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)

        lateinit var viewHolder: VH

        val constructors = clazz.declaredConstructors

        try {
            for (i in constructors.indices) {
                for (j in constructors[i].genericParameterTypes.indices) {
                    val parameterClass = constructors[i].parameterTypes[j]

                    if (parameterClass?.superclass!!.isAssignableFrom(ViewDataBinding::class.java)) {
                        viewHolder = constructors[i].newInstance(view) as VH
                        break
                    }
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return viewHolder
    }

    abstract fun getItem(position: Int): T?

    abstract fun createOnClickListener(item : T) : Array<Pair<String, View.OnClickListener>>

}