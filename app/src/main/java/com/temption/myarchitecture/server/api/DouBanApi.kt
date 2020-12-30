package com.temption.myarchitecture.server.api

import com.temption.lib.http.RetrofitServiceManager
import com.temption.myarchitecture.server.dto.DouBanResp

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/30 10:45
 */
class DouBanApi {

    companion object {

        private val douBanApiService: DouBanApiService
            get() = RetrofitServiceManager.create(
                DouBanApiService::class.java,
                "https://api.douban.com/"
            )

        suspend fun getTopics(): DouBanResp? {
            return douBanApiService.getTopics()
        }

    }


}