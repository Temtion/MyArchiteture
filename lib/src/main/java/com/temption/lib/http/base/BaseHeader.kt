package com.temption.lib.http.base

import com.google.gson.annotations.SerializedName

/**
 * 获取手机验证码请求
 * Created by lianpengcheng on 2020/8/31.
 */
data class BaseHeader (
    /**
     * 手机号
     */
    @SerializedName("phone") val phone: String,

    /**
     * 图形验证码 header 里 is_verify_code  为 1 时 必填
     */
    @SerializedName("img_code") val imgCode: String?,

    /**
     * 获取图片验证码返回的sign header 里 is_verify_code  为 1 时 必填
     */
    @SerializedName("img_sign") val imgSign: String?
)