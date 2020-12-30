package com.temption.lib.http.exception

/**
 * 服务器返回的错误
 */
class ServerException(// 错误码
    var status: Int, // 错误信息
    override var message: String?
) : RuntimeException()