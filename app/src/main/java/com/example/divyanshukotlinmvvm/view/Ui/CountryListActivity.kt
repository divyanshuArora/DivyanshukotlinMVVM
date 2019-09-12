package com.example.divyanshukotlinmvvm.view.Ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.ActivityCountryListBinding
import com.example.divyanshukotlinmvvm.service.model.CountryResponse
import com.example.divyanshukotlinmvvm.view.Adapters.CountryListAdapter
import com.example.divyanshukotlinmvvm.viewmodel.CountryViewModel

class CountryListActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView ?= null


    //private  var countryViewModel: CountryViewModel ?= null
    private  var activityCountryListBinding : ActivityCountryListBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_country_list)

        activityCountryListBinding = DataBindingUtil.setContentView(this,R.layout.activity_country_list)
        var countryViewModel: CountryViewModel  = ViewModelProviders.of(this).get(CountryViewModel::class.java)


        recyclerView = findViewById(R.id.countryRecycle) as RecyclerView

        loadCountry(countryViewModel)

    }

    private  fun loadCountry(viewModel: CountryViewModel)
    {
        var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)

       // activityCountryListBinding!!.countryRecycle.layoutManager = linearLayoutManager
        recyclerView!!.layoutManager = linearLayoutManager

//        val result: CountryResponse = countryViewModel!!.getCountryData() as CountryResponse

        val result: CountryResponse = viewModel?.getCountryData() as CountryResponse

       val countryListAdapter  = result.getData()?.let { CountryListAdapter(this, it )}
        //activityCountryListBinding!!.countryRecycle.adapter = countryListAdapter
        recyclerView!!.adapter = countryListAdapter



    }
}





