package com.giftm.toceleb.data.remote

import com.giftm.toceleb.data.model.api.LoginContent
import com.giftm.toceleb.util.apiUrl
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable

class AppApiHelper : ApiHelper {


    override fun login(id: String, pw : String): Observable<LoginContent> =
        Rx2AndroidNetworking.get(apiUrl)
            .build()
            .getObjectObservable(LoginContent::class.java)
}