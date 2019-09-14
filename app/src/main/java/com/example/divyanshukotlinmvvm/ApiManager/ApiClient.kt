package com.example.divyanshukotlinmvvm.ApiManager

import com.example.divyanshukotlinmvvm.interfaces.ApiInterfaces
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiClient
{

    fun <S>  createService(serviceClass: Class<S>, baseUrl: String): S {

        var baseUrl = baseUrl
        if (baseUrl.trim { it <= ' ' }.length < 2) {
            baseUrl = ApiConfig.base_url
        }
        val interceptor =
            HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(190, TimeUnit.SECONDS)
            .writeTimeout(200, TimeUnit.SECONDS)
            .readTimeout(190, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(interceptor).build()
        val gson: Gson? = GsonBuilder()
            .setLenient()
            .create()
        val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        val retrofit: Retrofit = builder.build()

        return retrofit.create(serviceClass)
    }


//    companion object Client
//    {
//        fun CreateClient():ApiClient
//        {
//            return ApiClient()
//        }
//    }







}