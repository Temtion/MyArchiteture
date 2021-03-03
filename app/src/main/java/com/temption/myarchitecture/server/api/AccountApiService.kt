package com.temption.myarchitecture.server.api

import com.temption.myarchitecture.server.dto.LoginResp
import com.yf.library.base.server.dto.BaseResp
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * 账号信息请求接口
 * Created by lianpengcheng on 2020/8/31.
 */
interface AccountApiService {

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(@FieldMap map: Map<String, String>): BaseResp<LoginResp>

}