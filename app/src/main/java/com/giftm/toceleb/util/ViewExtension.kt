package com.giftm.toceleb.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

fun View.getParentActivity(): AppCompatActivity? {

    val context = this.context

    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
    }
    return null
}

fun Window.getSoftInputMode() = attributes.softInputMode

fun Context.hideKeyBoard(view: View){
    val imm : InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}