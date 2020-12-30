package com.temption.myarchitecture.ext;

/**
 * Extension functions for Fragment.
 */

import androidx.fragment.app.Fragment
import com.temption.myarchitecture.ViewModelFactory


fun Fragment.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory(this)
}





