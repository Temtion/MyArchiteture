package com.temption.lib.http.intercepter;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetInterceptor implements Interceptor {

    private static final String JSONPARAMS = "JSONPARAMS";

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request oldRequest = chain.request();
        Headers oldHeader = oldRequest.headers();
        String newHeader = oldHeader.get(JSONPARAMS);
        if (TextUtils.isEmpty(newHeader)) {
            newHeader ="new HEADER";
        }
        Request request = oldRequest.newBuilder()
                .addHeader("Connection", "close")
                .removeHeader(JSONPARAMS)
                .addHeader(JSONPARAMS, newHeader)
                .build();
//        LogUtils.e("head:"+newHeader);
        return chain.proceed(request);
    }
}
