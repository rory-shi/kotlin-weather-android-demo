package com.xiaoma.kotlindemo.domain.commands

/**
 * Created by shixinghua on 05/06/2017.
 */
interface Command<T> {
    fun execute(): T
}