package com.xiaoma.kotlindemo.ui

import android.app.Application
import com.xiaoma.kotlindemo.ui.utils.DelegatesExt

/**
 * Created by shixinghua on 08/06/2017.
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}


