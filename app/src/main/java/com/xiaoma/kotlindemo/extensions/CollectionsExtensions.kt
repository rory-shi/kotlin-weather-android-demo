package com.xiaoma.kotlindemo.extensions

/**
 * Created by shixinghua on 09/06/2017.
 */

fun <K, V : Any> Map<K, V?>.toVaraargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()