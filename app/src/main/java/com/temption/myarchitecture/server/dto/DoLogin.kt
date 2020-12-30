package com.temption.myarchitecture.server.dto

import com.google.gson.annotations.SerializedName

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/29 19:13
 */

data class LoginReq(@SerializedName("phone") val phone: String,@SerializedName("psw") val code: String)

data class LoginResp (
    @SerializedName("token") val token: String?,
    @SerializedName("server_time") val serverTime: Int?,
    @SerializedName("exp_time") val expTime: Int?,
    @SerializedName("avatar") val avatar: String?,
    @SerializedName("mobile") val mobile: String?,
    @SerializedName("u_name") val name: String?,
    @SerializedName("u_type") val type: Int?,
    @SerializedName("id") val id: Int?,
    @SerializedName("open_id") val openId: String?,
    @SerializedName("new_package") val newPackage: Int?
)