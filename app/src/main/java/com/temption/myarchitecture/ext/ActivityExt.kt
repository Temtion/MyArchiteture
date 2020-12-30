package com.temption.myarchitecture.ext

import androidx.appcompat.app.AppCompatActivity
import com.temption.myarchitecture.ViewModelFactory

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/29 13:28
 */
fun AppCompatActivity.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory(this)
}

