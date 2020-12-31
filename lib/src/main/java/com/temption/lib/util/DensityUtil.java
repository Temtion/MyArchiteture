package com.temption.lib.util;


import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * 1.放在BaseAcitivity的setContentView之前
 * 2.放在Application 对Activity注册的LifeCycle 回调方法 onActivityCreated中
 * 3.width修改为ui图参考的宽度，布局里面直接写dp
 */

public class DensityUtil {
    public static final float WIDTH = 375;
    private static float appDensity;
    private static float appScaleDenstity;

    public static void setDensity(final Application application, Activity activity) {
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (appDensity == 0) {
            appDensity = displayMetrics.density;
            appScaleDenstity = displayMetrics.scaledDensity;
            //添加字体大小变化监听的回调
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0){
                        appScaleDenstity = 	application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }
                @Override
                public void onLowMemory() {

                }
            });
        }
        float targetDensity = displayMetrics.widthPixels / WIDTH;
        float targetScaleDensity = targetDensity * (appScaleDenstity / appDensity);
        int targetDensityDpi = (int) (targetDensity * 160);
        //进行替换
        DisplayMetrics dm = activity.getResources().getDisplayMetrics();
        dm.density = targetDensity;
        dm.scaledDensity =targetScaleDensity;
        dm.densityDpi = targetDensityDpi;
    }
}
