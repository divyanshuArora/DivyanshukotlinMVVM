package com.example.divyanshukotlinmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.divyanshukotlinmvvm.service.model.CountryResponse
import com.example.divyanshukotlinmvvm.service.repository.CountryRepository

class CountryViewModel(application: Application): AndroidViewModel(application)
{
    fun getCountryData(): MutableLiveData<List<CountryResponse>>
    {
        return  CountryRepository.getInstance().getCountryList()
    }







}