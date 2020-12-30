package com.temption.myarchitecture.ext


import com.temption.lib.http.exception.ApiException
import com.temption.lib.http.exception.ExceptionEngine
import com.temption.lib.http.exception.ServerException
import com.yf.library.base.server.dto.BaseResp
import com.yf.library.base.server.dto.ResponseStatus.Companion.SUCCESS

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/30 14:03
 */
suspend fun <T> handleResp(
    action: suspend () -> BaseResp<T>
): BaseResp<T> {
    try {
        val response = action()
        if (response.code == SUCCESS) {
            return response
            //逻辑异常
        } else {
            val errorDto = getErrorDto<T>(
                ExceptionEngine.handleException(
                    ServerException(
                        response.code,
                        response.msg
                    )
                )
            )
            return errorDto
        }
        //Api异常(包括Server异常)
    } catch (e: Exception) {
        val errorDto = getErrorDto<T>(ExceptionEngine.handleException(e))
        return errorDto
    }
}

private fun <T> getErrorDto(ex: ApiException): BaseResp<T> {
    return BaseResp(ex.status, ex.message)
}
