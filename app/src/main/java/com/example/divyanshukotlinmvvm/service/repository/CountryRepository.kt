package com.example.divyanshukotlinmvvm.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.divyanshukotlinmvvm.interfaces.ApiInterfaces
import com.example.divyanshukotlinmvvm.service.model.CountryResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class CountryRepository {

    companion object Factory {
        fun getInstance(): CountryRepository {
            return CountryRepository()
        }
    }

    fun getCountryList(): LiveData<CountryResponse> {
        var data = MutableLiveData<CountryResponse>()

        ApiInterfaces.create().getCountry().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                data.value = it
            }
        return data
    }

}