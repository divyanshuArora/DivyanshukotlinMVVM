package com.example.divyanshukotlinmvvm.service.model

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class CountryModel
{
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

    fun getCountry_Id(): Int? {
        return countryId
    }

    fun setCountry_Id(countryId: Int?) {
        this.countryId = countryId
    }

    fun get_Country(): String? {
        return country
    }

    fun set_Country(country: String?) {
        this.country = country
    }

    fun get_Code(): String? {
        return code
    }

    fun set_Code(code: String?) {
        this.code = code
    }

    fun get_Flag(): String? {
        return flag
    }

    fun set_Flag(flag: String?) {
        this.flag = flag
    }







}