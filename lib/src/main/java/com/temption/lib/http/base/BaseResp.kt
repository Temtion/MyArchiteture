package com.yf.library.base.server.dto

/**
 * 服务器返回数据传输对象
 * Created by lianpengcheng on 2020/8/31.
 */


data class BaseResp<T>(
    var code:Int,
    var msg: String? = "",
    var `data`: T? = null
)

interface ResponseStatus {
    companion object {
        /**
         * 请求成功
         */
        const val SUCCESS = 200
        /**
         *黑名单提示
         */
        const val ERROR_FORBIDDEN = 1227

    }
}