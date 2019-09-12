package com.example.divyanshukotlinmvvm.interfaces
import com.example.divyanshukotlinmvvm.service.model.CountryResponse
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable

interface ApiInterfaces {


    @GET("/v1/country_list")
    fun getCountry(): Observable<List<CountryResponse>>





    companion object Factory {
        fun create(): ApiInterfaces
        {
                val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://18.220.67.113/api/")
                .build()


            return retrofit.create(ApiInterfaces::class.java)
        }
    }
}