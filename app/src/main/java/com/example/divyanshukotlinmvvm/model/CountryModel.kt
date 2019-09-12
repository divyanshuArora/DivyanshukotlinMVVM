package com.example.divyanshukotlinmvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import android.R.attr.data

open class CountryModel
{

    @SerializedName("error")
    @Expose
    private var error: Boolean ?= null
    @SerializedName("data")
    @Expose
    private var data: List<country>  ?= null


    fun getError(): Boolean? {
        return error
    }

    fun setError(error: Boolean?) {
        this.error = error
    }

    fun getData(): List<country>? {
        return data
    }

    fun setData(data: List<country>) {
        this.data = data
    }


    inner class country {

        @SerializedName("country_id")
        @Expose
        var countryId: Int? = null
        @SerializedName("country")
        @Expose
        var country: String? = null
        @SerializedName("code")
        @Expose
        var code: String? = null
        @SerializedName("flag")
        @Expose
        var flag: String? = null

    }
















}