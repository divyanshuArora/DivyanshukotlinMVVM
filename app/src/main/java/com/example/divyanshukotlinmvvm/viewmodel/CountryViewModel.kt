package com.example.divyanshukotlinmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.divyanshukotlinmvvm.model.CountryModel

class CountryViewModel : CountryModel
{


    var countryId: String ?= null
    var countryName: String ?= null
    var countryCode: String ?= null
    var countryFlag: String ?= null

    constructor(): super()


    var countryViewModel = CountryViewModel()

    var model = countryViewModel.country()

    constructor(countryModel: country)
    {
        this.countryId = countryModel.countryId.toString()
        this.countryName = countryModel.country
        this.countryFlag = countryModel.flag
        this.countryCode = countryModel.code
    }



    var arrayMutableList = MutableLiveData<ArrayList<CountryViewModel>>()
    var arrayList = ArrayList<CountryViewModel>()


            fun getCountryData()
            {

            }







}