package com.temption.myarchitecture.ext;

import android.content.res.Resources
import android.util.TypedValue

/**
 * @Description:
 * @Author: haoshuaihui
 * @CreateDate: 2021/1/28 14:42
 */
val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )


