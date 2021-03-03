package com.temption.myarchitecture.ext;

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast

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

fun Context.showToast(stringResId: Int,duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, stringResId, duration).show()
}
fun Context.showToast(content:String,duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, content, duration).show()
}





