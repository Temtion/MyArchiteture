package com.temption.myarchitecture.logic.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.temption.myarchitecture.databinding.MainFragmentBinding
import com.temption.myarchitecture.ext.findNavController
import com.temption.myarchitecture.ext.getViewModelFactory
import com.temption.myarchitecture.ext.showToast
import kotlin.random.Random


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
        val nextBoolean = Random(1).nextBoolean()
        if (nextBoolean){
            viewModel.testDouBan().observe(viewLifecycleOwner, {
                it?.let {
                    binding.tvResponse.text = it.toString()
                    activity?.showToast(1)
                }
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnConstraintLayout.setOnClickListener {
            val action =
                MainFragmentDirections.actionMainFragmentToConstraintLayoutFragment()
            findNavController().navigate(action)
        }

        binding.btnTransformation.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToTransformationFragment()
            findNavController().navigate(action)
        }
    }





}