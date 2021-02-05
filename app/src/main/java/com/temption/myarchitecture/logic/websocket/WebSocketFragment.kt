package com.temption.myarchitecture.logic.websocket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.temption.lib.http.RetrofitServiceManager
import com.temption.myarchitecture.R
import com.temption.myarchitecture.databinding.TransformationFragmentBinding
import com.temption.myarchitecture.databinding.WebSocketFragmentBinding
import com.temption.myarchitecture.ext.getViewModelFactory
import com.temption.myarchitecture.logic.main.MainViewModel

class WebSocketFragment : Fragment() {

    private lateinit var binding: WebSocketFragmentBinding
    private val viewModel by viewModels<WebSocketViewModel> { getViewModelFactory() }

    companion object {
        fun newInstance() = WebSocketFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WebSocketFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
            binding.btnStartConnect.setOnClickListener {
                val socket = WebSocketManager.connect("10.191.84.172", 39541);
            }
    }




}