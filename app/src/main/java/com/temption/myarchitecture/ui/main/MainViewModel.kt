package com.temption.myarchitecture.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import com.temption.myarchitecture.server.repository.AccountRepository
import com.temption.myarchitecture.server.dto.DouBanResp
import com.temption.myarchitecture.server.dto.LoginReq
import com.temption.myarchitecture.server.dto.LoginResp
import com.yf.library.base.server.dto.BaseResp

class MainViewModel(private val savedStateHandle: SavedStateHandle, application: Application) :
    AndroidViewModel(application) {
    private val mRepository = AccountRepository()

    init {
        // Set initial state
        selectPosition(getLatestSelectPosition().ordinal)
    }

    fun selectPosition(page: Int) {
        savedStateHandle.set(KEY_LAST_PAGE_POSITION, PAGES.values()[page])
    }

    private fun getLatestSelectPosition(): PAGES {
        return savedStateHandle.get<PAGES>(KEY_LAST_PAGE_POSITION) ?: PAGES.MAIN
    }

    enum class PAGES {
        /**
         * Do not filter tasks.
         */
        MAIN,

        /**
         * Filters only the active (not completed yet) tasks.
         */
        MINE,

        /**
         * Filters only the completed tasks.
         */
        OTHER
    }

    fun login(req: LoginReq): LiveData<BaseResp<LoginResp>> {
        return liveData { emit(mRepository.login(req)) }
    }

    fun testDouBan(): LiveData<DouBanResp?> {
        return liveData { emit(mRepository.testDouBan()) }
    }


}

const val KEY_LAST_PAGE_POSITION = "KEY_LAST_PAGE_POSITION"
