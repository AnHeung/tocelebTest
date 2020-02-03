package com.giftm.toceleb.ui.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<B : ViewDataBinding , T > (val binding: B) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item : T , position : Int , vararg clickListeners : Pair<String, View.OnClickListener>)
}