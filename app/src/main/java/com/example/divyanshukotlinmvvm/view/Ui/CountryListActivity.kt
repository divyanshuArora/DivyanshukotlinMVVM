package com.example.divyanshukotlinmvvm.view.Ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.view.Adapters.CountryListAdapter
import com.example.divyanshukotlinmvvm.viewmodel.CountryViewModel

class CountryListActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView ?= null
    private var countryListAdapter : CountryListAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_list)

        recyclerView = findViewById(R.id.countryRecycle)

        loadCountry()
    }

    private fun loadCountry()
    {

        //val countryViewModel : CountryViewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)



    }
}

