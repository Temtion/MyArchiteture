package com.temption.myarchitecture.server.api

import com.temption.myarchitecture.server.dto.DouBanResp
import retrofit2.http.GET

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/30 10:45
 */
interface DouBanApiService {

    /**
     * 测试
     */
    @GET("v2/group/husttgeek/topics")
    suspend fun getTopics(): DouBanResp?


}