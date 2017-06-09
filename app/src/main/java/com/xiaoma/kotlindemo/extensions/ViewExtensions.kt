package com.xiaoma.kotlindemo.extensions

/**
 * Created by shixinghua on 08/06/2017.
 */
import android.content.Context
import android.view.View

val View.ctx: Context
    get() = context