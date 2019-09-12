package com.example.divyanshukotlinmvvm.service.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.divyanshukotlinmvvm.interfaces.ApiInterfaces
import com.example.divyanshukotlinmvvm.service.model.CountryModel
import com.example.divyanshukotlinmvvm.service.model.CountryResponse
import retrofit2.Response
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.io.IOException

class CountryRepository {

    companion object Factory
    {
        fun getInstance(): CountryRepository {
            return CountryRepository()
        }
    }

    fun getCountryList():MutableLiveData<List<CountryResponse>>
        {
            var data = MutableLiveData<List<CountryResponse>>()

                ApiInterfaces.create().getCountry().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    data.value = it
                }
          return data
        }


//    suspend fun getCountryList(): List<CountryModel>?
//    {
//
//        val countryResponse = safeApiCall(
//            call  = {ApiInterfaces.create().getCountry().await()},errorMessage = "Data Fatching")
//
//        return countryResponse?.getData()
//
//
//    }
//
//
//     suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {
//
//        val result : Result<T> = safeApiResult(call,errorMessage)
//        var data : T? = null
//
//        when(result) {
//            is Result.Success ->
//                data = result.data
//            is Result.Error -> {
//                Log.d("1.DataRepository", "$errorMessage & Exception - ${result.exception}")
//            }
//        }
//
//
//        return data
//
//    }
//
//
//    private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>, errorMessage: String) : Result<T>{
//        val response = call.invoke()
//        if(response.isSuccessful) return Result.Success(response.body()!!)
//
//        return Result.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
//    }
//
//    sealed class Result<out T: Any> {
//        data class Success<out T : Any>(val data: T) : Result<T>()
//        data class Error(val exception: Exception) : Result<Nothing>()
//    }
}
