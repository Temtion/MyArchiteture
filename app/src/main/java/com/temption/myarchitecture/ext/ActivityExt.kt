package com.temption.myarchitecture.ext

import android.app.Activity
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.temption.myarchitecture.ViewModelFactory

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/29 13:28
 */
fun AppCompatActivity.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory(this)
}

fun Activity.findNavController(@IdRes viewId: Int): NavController =
    Navigation.findNavController(this, viewId)
