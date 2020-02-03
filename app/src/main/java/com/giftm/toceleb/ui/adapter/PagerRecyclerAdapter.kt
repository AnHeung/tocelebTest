package com.giftm.toceleb.ui.adapter

import android.view.View
import com.giftm.toceleb.databinding.ItemSplashViewpagerBinding
import com.giftm.toceleb.ui.base.BaseAdapter
import com.giftm.toceleb.ui.base.BaseViewHolder
import com.giftm.toceleb.ui.splashviewpager.SplashViewPagerViewModel

class PagerRecyclerAdapter(
    private val splashImgs: List<Int>,
    clazz: Class<PagerViewHolder>,
    layoutId: Int
) : BaseAdapter<Int, PagerViewHolder, SplashViewPagerViewModel>(clazz, layoutId) {

    override fun getItemCount(): Int = splashImgs.count()

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        getItem(position)?.let {
            with(holder) {
                bind(it, position, *createOnClickListener(position))
            }
        }
    }

    override fun getItem(position: Int): Int? = splashImgs[position]

    override fun createOnClickListener(item: Int): Array<Pair<String, View.OnClickListener>> {

        return with(baseViewModel) {
            arrayOf("skip" to View.OnClickListener { skipClickListener.postValue(2) },
                "next" to View.OnClickListener { nextClickListener.postValue(item + 1) })
        }
    }

}


class PagerViewHolder(
    binding: ItemSplashViewpagerBinding
) : BaseViewHolder<ItemSplashViewpagerBinding, Int>(binding) {

    override fun bind(
        item: Int,
        position: Int,
        vararg clickListeners: Pair<String, View.OnClickListener>
    ) {

        binding.apply {

            clickListeners.forEach {
                when (it.first) {
                    "skip" -> binding.skipClickListener = it.second
                    "next" -> binding.nextClickListener = it.second
                }
            }

            when (position) {
                2 -> {
                    splashViewpagerSkipTxt.visibility = View.GONE
                    splashViewpagerNextBtn.text = "Start"
                }
                else -> splashViewpagerSkipTxt.visibility = View.VISIBLE
            }
            itemSplashViewpagerCenterImg.setImageResource(item)
            executePendingBindings()
        }
    }
}