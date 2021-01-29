package com.temption.lib.http

import com.temption.lib.http.intercepter.NetInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2020/12/29 19:26
 */
object RetrofitServiceManager {

    private const val mDefaultUrl: String = "www.baidu.com"
    private const val DEFAULT_TIME_OUT = 5
    private const val DEFAULT_READ_TIME_OUT = 15

    private val mDefaultRetrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
    }

    private val mDefaultOkHttpClientBuilder: OkHttpClient.Builder by lazy  {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .addInterceptor(NetInterceptor())
            .connectTimeout(
                DEFAULT_TIME_OUT.toLong(),
                TimeUnit.SECONDS
            )
            .readTimeout(
                DEFAULT_READ_TIME_OUT.toLong(),
                TimeUnit.SECONDS
            )
            .writeTimeout(
                DEFAULT_READ_TIME_OUT.toLong(),
                TimeUnit.SECONDS
            )
            .retryOnConnectionFailure(false).run {
                try {
                    // 自定义一个信任所有证书的TrustManager，添加SSLSocketFactory的时候要用到
                    val trustAllCert: X509TrustManager = object : X509TrustManager {
                        @Throws(CertificateException::class)
                        override fun checkClientTrusted(
                            chain: Array<X509Certificate>,
                            authType: String
                        ) {
                        }

                        @Throws(CertificateException::class)
                        override fun checkServerTrusted(
                            chain: Array<X509Certificate>,
                            authType: String
                        ) {
                        }

                        override fun getAcceptedIssuers(): Array<X509Certificate> {
                            return arrayOf()
                        }
                    }
                    val sslSocketFactory: SSLSocketFactory =
                        SSLSocketFactoryCompat(
                            trustAllCert
                        )
                    sslSocketFactory(sslSocketFactory, trustAllCert)
                } catch (e: Exception) {
                    throw RuntimeException(e)
                }
            }
    }


    /**
     * 重置baseUrl
     *
     * @param baseUrl API base URL
     * @param service Service 的 class
     * @param <T>
     * @return
    </T> */
    fun <T> create(
        service: Class<T>,
        baseUrl: String = mDefaultUrl,
        clientBuilder: OkHttpClient.Builder = mDefaultOkHttpClientBuilder
    ): T {
        return mDefaultRetrofitBuilder
            .client(clientBuilder.build())
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(service)
    }


}