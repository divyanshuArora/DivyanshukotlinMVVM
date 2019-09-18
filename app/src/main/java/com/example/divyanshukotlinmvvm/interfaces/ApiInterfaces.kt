package com.example.divyanshukotlinmvvm.interfaces

import com.example.divyanshukotlinmvvm.service.model.CountryResponse
import com.example.divyanshukotlinmvvm.service.model.FakeUsersResponse
import io.reactivex.Observable

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterfaces {

    @GET("country_list")
    fun getCountry(): Observable<CountryResponse>


    @GET("users")
    fun getFakeUsers(
        @Query("page") page: String): Observable<FakeUsersResponse>



    companion object Factory {
        fun create(): ApiInterfaces {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://18.220.67.113/api/v1/")
                .build()


            return retrofit.create(ApiInterfaces::class.java)
        }

        fun create2(): ApiInterfaces {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://reqres.in/api/")
                .build()

            return retrofit.create(ApiInterfaces::class.java)
        }





    }

//    companion object Factory2 {
//        fun create(): ApiInterfaces {
//
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl("https://reqres.in/api/")
//                .build()
//
//            return retrofit.create(ApiInterfaces::class.java)
//        }
//    }







}


