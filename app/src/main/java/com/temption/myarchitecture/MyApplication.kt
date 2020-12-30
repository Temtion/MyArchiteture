package com.temption.myarchitecture

import com.temption.lib.BaseApplication
import kotlin.properties.Delegates

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/29 14:43
 */
class MyApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private var instance: MyApplication by Delegates.notNull()
        fun instance() = instance
    }

}
