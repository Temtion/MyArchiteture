package com.temption.myarchitecture.server.repository

import com.temption.myarchitecture.ext.handleResp
import com.temption.myarchitecture.server.api.AccountApi
import com.temption.myarchitecture.server.api.DouBanApi
import com.temption.myarchitecture.server.dto.LoginReq
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/29 19:07
 */
class AccountRepository : IAccountRepository {

    suspend fun login(req: LoginReq) = withContext(Dispatchers.IO){
        handleResp {
            AccountApi.login(req)
        }
    }

    suspend fun testDouBan() = withContext(Dispatchers.IO){
        return@withContext DouBanApi.getTopics()
    }

}