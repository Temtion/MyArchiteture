package com.temption.myarchitecture.server.api

import com.temption.lib.http.RetrofitServiceManager
import com.temption.lib.http.serializeToMap
import com.temption.myarchitecture.server.dto.LoginReq
import com.temption.myarchitecture.server.dto.LoginResp
import com.yf.library.base.server.dto.BaseResp

/**
 * 账号信息请求
 * Created by lianpengcheng on 2020/8/31.
 */
class AccountApi {

    companion object {

        private val loginApiService: AccountApiService
            get() = RetrofitServiceManager.create(AccountApiService::class.java);

        /**
         * 登录
         */
        suspend fun login(req: LoginReq): BaseResp<LoginResp> {
            return loginApiService.login(req.serializeToMap())
        }

    }
}