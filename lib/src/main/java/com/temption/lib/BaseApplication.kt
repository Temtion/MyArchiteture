package com.temption.lib

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.temption.lib.util.DensityUtil

/**
 * @Description:    对activity进行适配
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/29 15:22
 */
abstract class BaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object :ActivityLifecycleCallbacks{
            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                DensityUtil.setDensity(this@BaseApplication,activity)
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }
        })
    }

}