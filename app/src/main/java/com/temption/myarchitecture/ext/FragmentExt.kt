package com.temption.myarchitecture.ext;

/**
 * Extension functions for Fragment.
 */

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.temption.myarchitecture.ViewModelFactory


fun Fragment.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory(this)
}

fun Fragment.findNavController(): NavController =
    NavHostFragment.findNavController(this)


fun Fragment.showToolBar(showBackIcon: Boolean, toolbar: Toolbar) {
    setHasOptionsMenu(true);
    val host = activity as AppCompatActivity
    host.setSupportActionBar(toolbar)
    host.supportActionBar?.let {
        it.title = ""
        it.setHomeButtonEnabled(true)
        it.setDisplayHomeAsUpEnabled(showBackIcon)
    }
}

