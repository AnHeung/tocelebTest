package com.giftm.toceleb.ui.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.giftm.toceleb.util.getParentActivity
import com.rengwuxian.materialedittext.MaterialEditText
import com.rengwuxian.materialedittext.validation.METValidator


@BindingAdapter("mutableText")
fun setMutableText(txtView: TextView, content: MutableLiveData<String>?) {

    val parentActivity = txtView.getParentActivity()

    if (parentActivity != null && content != null) {
        content.observe(parentActivity, Observer { txtView.text = it ?: "" })
    }
}

@BindingAdapter("content")
fun setContent(txtView: TextView, content: MutableLiveData<String>?) {
    content?.value?.let {
        if (txtView.text.toString() != content.value) {
            txtView.text = content.value
        }
    }
}

@InverseBindingAdapter(attribute = "content", event = "contentAttrChanged")
fun getContent(txtView: TextView): String {
    return txtView.text?.toString() ?: ""
}

@BindingAdapter("contentAttrChanged")
fun setTextWacher(txtView: TextView, inverseBindingListener: InverseBindingListener?) {

    txtView.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            inverseBindingListener?.onChange()
        }
    })
}


@BindingAdapter("visibility")
fun setVisibility(view: View, isVisible: MutableLiveData<Boolean>?) {

    val parentActivity = view.getParentActivity()

    if (parentActivity != null && isVisible != null) {
        isVisible.observe(parentActivity, Observer {
            view.visibility = when (it) {
                true -> View.VISIBLE
                else -> View.GONE
            }
        })
    }
}

@BindingAdapter("isProgress")
fun setProgress(view: View, isProgress: MutableLiveData<Boolean>?) {

    val parentActivity = view.getParentActivity()

    if (parentActivity != null && isProgress != null) {
        isProgress.observe(parentActivity, Observer {
            view.visibility = when (it) {
                true -> View.VISIBLE
                else -> View.GONE
            }
        })
    }
}

@BindingAdapter("validator")
fun setValidator(txtView: MaterialEditText?, validator: METValidator?) {
    validator?.let {
        txtView?.addValidator(it)
    }
}

@BindingAdapter("bind_adapter")
fun <VH : RecyclerView.ViewHolder> setBindAdapter(view: View, adapter: RecyclerView.Adapter<VH>) {
    if (view::class.java.isAssignableFrom(ViewPager2::class.java)) {
        (view as ViewPager2).adapter = adapter
    } else if (view::class.java.isAssignableFrom(RecyclerView::class.java)) {
        (view as RecyclerView).adapter = adapter
    }
}

@BindingAdapter("bind_adapter_items")
inline  fun<T , reified > setBindAdapterItems(view: RecyclerView , items:List<T>?){

    items.let {

    }
}
