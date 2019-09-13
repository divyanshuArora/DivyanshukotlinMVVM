package com.example.divyanshukotlinmvvm.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CountryResponse
{


    @SerializedName("error")
    @Expose
    private var error: Boolean? = null
    @SerializedName("data")
    @Expose
    private var data: List<CountryModel> ?= null

    fun getError(): Boolean? {
        return error
    }

    fun setError(error: Boolean?) {
        this.error = error
    }

    fun getData(): List<CountryModel>?
    {
        return data
    }

    fun setData(data: List<CountryModel>) {
        this.data = data
    }









}
















