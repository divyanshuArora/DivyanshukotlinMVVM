package com.example.divyanshukotlinmvvm.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class CountryModel
{
    @SerializedName("country_id")
    @Expose
    private var countryId: Int? = null
    @SerializedName("country")
    @Expose
    private var country: String? = null
    @SerializedName("code")
    @Expose
    private var code: String? = null
    @SerializedName("flag")
    @Expose
    private var flag: String? = null

    fun getCountryId(): Int? {
        return countryId
    }

    fun setCountryId(countryId: Int?) {
        this.countryId = countryId
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String) {
        this.country = country
    }

    fun getCode(): String? {
        return code
    }

    fun setCode(code: String) {
        this.code = code
    }

    fun getFlag(): String? {
        return flag
    }

    fun setFlag(flag: String) {
        this.flag = flag
    }
}