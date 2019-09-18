package com.example.divyanshukotlinmvvm.interfaces

import com.example.divyanshukotlinmvvm.service.model.UserSelectionModel
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SelectedUserApiInterface {


    @GET("posts?")
    fun getSelectedUser(
        @Query("userId") userId: String
    ): Observable<List<UserSelectionModel>>


    companion object Factory {
        fun createUserSelection(): SelectedUserApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()


            return retrofit.create(SelectedUserApiInterface::class.java)
        }
    }
}