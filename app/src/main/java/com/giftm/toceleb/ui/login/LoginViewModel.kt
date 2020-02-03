package com.giftm.toceleb.ui.login

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import com.giftm.toceleb.data.DataManager
import com.giftm.toceleb.ui.base.BaseViewModel
import com.giftm.toceleb.util.SingleLiveEvent
import com.rengwuxian.materialedittext.validation.METValidator
import com.rengwuxian.materialedittext.validation.RegexpValidator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.regex.Pattern

class LoginViewModel(private val dataManager: DataManager) : BaseViewModel() {

    val isClick: MutableLiveData<Boolean>? = MutableLiveData(false)
    val loginId: MutableLiveData<String>? = MutableLiveData("")
    val loginPw: MutableLiveData<String>? = MutableLiveData("")
    val loginBegin : SingleLiveEvent<Any>? = SingleLiveEvent()

    fun getEamilValidator(): METValidator? = RegexpValidator("올바른 포맷이 아닙니다.", Patterns.EMAIL_ADDRESS.pattern())

    fun getPwValidator(): METValidator? =
        RegexpValidator("비밀번호는 4~12자 사이로 입력하세요.", Pattern.compile("^[\\w\\W]{4,12}$").pattern())

    fun login(id: String, pw: String) {

        isClick?.value = true

        println("로그인 한 $id  비밀번호 $pw")

        isVisible?.value = false

        compositeDisposable += dataManager
            .login(id, pw)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { isProgress?.postValue(true) }
            .doOnTerminate {
                isProgress?.postValue(false)
                isClick?.postValue(false)
            }
            .map { "박주갓은 ${it.parkjugod} 성공코드는 ${it.status}" }
            .doOnNext { println("들어온 값 $it") }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                println("subscribe $it")
                isVisible?.value = true
                loginText?.value = it
                loginBegin?.call()
            }, {
                println(" throwable 발생  : ${it.message}")
                isProgress?.postValue(false)
            })
    }
}