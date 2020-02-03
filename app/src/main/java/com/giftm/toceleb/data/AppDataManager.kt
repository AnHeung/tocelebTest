package com.giftm.toceleb.data

import com.giftm.toceleb.data.local.pref.PrefHelper
import com.giftm.toceleb.data.model.api.LoginContent
import com.giftm.toceleb.data.remote.ApiHelper
import io.reactivex.Observable

class AppDataManager(private val apiHelper: ApiHelper, private val prefHelper: PrefHelper) :
    DataManager {

    override fun login(id: String, pw: String): Observable<LoginContent> = apiHelper.login(id, pw)

    override fun setFirstLaunch(isFirst: Boolean) {
        prefHelper.setFirstLaunch(isFirst)
    }

    override fun getFistLaunch(): Boolean = prefHelper.getFistLaunch()

}