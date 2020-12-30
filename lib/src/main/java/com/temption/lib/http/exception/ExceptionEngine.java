package com.temption.lib.http.exception;


import android.net.ParseException;
import android.util.MalformedJsonException;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

public class ExceptionEngine {
    //客户端报错
    public static final int UN_KNOWN_ERROR = 9000;//未知错误
    public static final int ANALYTIC_SERVER_DATA_ERROR = 9001;//解析(服务器)数据错误
    public static final int ANALYTIC_CLIENT_DATA_ERROR = 9002;//解析(客户端)数据错误
    public static final int CONNECT_ERROR = 9003;//网络连接错误
    public static final int TIME_OUT_ERROR = 9004;//网络连接超时
    public static final int UNKNOWNHOSTEXCEPTION = 9005;//网络连接超时

    public static ApiException handleException(Throwable e) {
        e.printStackTrace();
        ApiException ex;
        if (e instanceof HttpException) {             //HTTP错误
            HttpException httpExc = (HttpException) e;
            ex = new ApiException(e, httpExc.code());
            ex.setMessage("网络错误，请稍后再试");  //均视为网络错误
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException || e instanceof MalformedJsonException) {  //解析数据错误
            ex = new ApiException(e, ANALYTIC_SERVER_DATA_ERROR);

            e.printStackTrace();
            ex.setMessage("解析失败，请稍后再试");
            return ex;
        } else if (e instanceof ConnectException) {//连接网络错误
            ex = new ApiException(e, CONNECT_ERROR);
            ex.setMessage("网络连接错误，请稍后再试");
            return ex;
        } else if (e instanceof SocketTimeoutException) {//网络超时
            ex = new ApiException(e, TIME_OUT_ERROR);
            ex.setMessage("网络连接超时，请稍后再试");
            return ex;
        } else if (e instanceof UnknownHostException) {//网络异常
            ex = new ApiException(e, UNKNOWNHOSTEXCEPTION);
            ex.setMessage("网络异常，请检查您的网络连接");
            return ex;
        }else {  //未知错误
            ex = new ApiException(e, UN_KNOWN_ERROR);
            ex.setMessage("未知错误," + e.getMessage());
            return ex;
        }
    }

}