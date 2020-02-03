package com.giftm.toceleb.data.remote

import com.giftm.toceleb.data.model.api.LoginContent
import io.reactivex.Observable

interface ApiHelper{
    fun login(id : String , pw: String) : Observable<LoginContent>
}