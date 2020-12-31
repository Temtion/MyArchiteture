package com.temption.myarchitecture.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.temption.myarchitecture.R
import com.temption.myarchitecture.ext.getViewModelFactory
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel> { getViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       // use viewModelb
//           viewModel.login(LoginReq("123","123")).observe(viewLifecycleOwner,
//                Observer {
//
//                })

            viewModel.testDouBan().observe(viewLifecycleOwner,
                Observer {
                    it?.let {
                        message.text = it.toString()
                    }
                }
            )

    }

}