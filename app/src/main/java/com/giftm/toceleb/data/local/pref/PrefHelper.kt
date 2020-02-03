package com.giftm.toceleb.data.local.pref

interface PrefHelper {

    fun setFirstLaunch(isFirst: Boolean)

    fun getFistLaunch(): Boolean
}