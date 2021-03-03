package com.temption.myarchitecture.logic.rx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.temption.myarchitecture.databinding.RxFragmentBinding
import com.temption.myarchitecture.ext.getViewModelFactory
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class RxFragment : Fragment() {


    private val viewModel by viewModels<RxViewModel> { getViewModelFactory() }

    private lateinit var binding: RxFragmentBinding

    private val searchContent = PublishSubject.create<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = RxFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribe()
        testFlowable()
    }

    private fun testFlowable() {

        Observable.just(123).toFlowable(BackpressureStrategy.BUFFER).subscribe()
        Flowable.just(123).subscribe()






    }

    /**
     * 防抖操作符 debounce :对于连续动作(动作间的时间间隔小于t)，以最后一次为准
     * 避免每次都去server查询
     *
     *
     */
    private fun subscribe() {
        val subscribe = searchContent
            .throttleFirst(1000, TimeUnit.MILLISECONDS)
            .subscribe {
                binding.textViewRealSearch.text = it
            }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.edtSearch.doAfterTextChanged {
            searchContent.onNext(it.toString())
        }

    }

}