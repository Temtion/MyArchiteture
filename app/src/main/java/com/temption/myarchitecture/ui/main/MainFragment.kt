package com.temption.myarchitecture.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.temption.myarchitecture.R
import com.temption.myarchitecture.databinding.MainFragmentBinding
import com.temption.myarchitecture.ext.findNavController
import com.temption.myarchitecture.ext.getViewModelFactory
import com.temption.myarchitecture.ext.showToolBar


class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding


    private val viewModel by viewModels<MainViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // use viewModelb
//           viewModel.login(LoginReq("123","123")).observe(viewLifecycleOwner,
//                Observer {
//
//                })
//
//            viewModel.testDouBan().observe(viewLifecycleOwner,
//                Observer {
//                    it?.let {
//                    }
//                }
//            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnConstraintLayout.setOnClickListener {
            val action =
                MainFragmentDirections.actionMainFragmentToConstraintLayoutFragment()
            findNavController().navigate(action)
        }
    }





}