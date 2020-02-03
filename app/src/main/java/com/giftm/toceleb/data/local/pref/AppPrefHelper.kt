package com.giftm.toceleb.data.local.pref

import android.content.Context
import android.content.SharedPreferences

class AppPrefHelper(private val context: Context, private val prefName: String) : PrefHelper {

    private val IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH"

    private val mpref: SharedPreferences by lazy {
        context.getSharedPreferences(
            prefName,
            Context.MODE_PRIVATE
        )
    }

    override fun setFirstLaunch(isFirst: Boolean) {
        mpref.edit().putBoolean(IS_FIRST_LAUNCH, isFirst).apply()
    }

    override fun getFistLaunch(): Boolean = mpref.getBoolean(IS_FIRST_LAUNCH, true)
}
