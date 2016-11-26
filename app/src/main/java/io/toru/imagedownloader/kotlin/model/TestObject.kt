package io.toru.imagedownloader.kotlin.model

import android.util.Log

/**
 * Created by wonyoung on 2016. 11. 27..
 */

// object 는 Kotlin 에서 singleton 이다.
object TestObject {
    fun testObject(){
        Log.w("TORU", "testObject")
    }

    fun sum(a:Int, b:Int):Int = a+b
}