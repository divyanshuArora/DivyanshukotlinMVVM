package com.example.divyanshukotlinmvvm.view.Ui

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.ActivityCountryListBinding
import com.example.divyanshukotlinmvvm.service.model.CountryModel
import com.example.divyanshukotlinmvvm.service.model.CountryResponse
import com.example.divyanshukotlinmvvm.view.Adapters.CountryListAdapter
import com.example.divyanshukotlinmvvm.viewmodel.CountryViewModel
import java.lang.Exception

class CountryListActivity : AppCompatActivity() {


        private  var activityCountryListBinding : ActivityCountryListBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_country_list)

        activityCountryListBinding =   DataBindingUtil.setContentView(this, R.layout.activity_country_list)
        val countryViewModel: CountryViewModel   = ViewModelProviders.of(this).get(CountryViewModel::class.java)

        loadCountry(countryViewModel)
    }


    private  fun loadCountry(countryViewModel: CountryViewModel)
    {

        var progressdialog = ProgressDialog(this)
        progressdialog.setTitle("country")
        progressdialog.setMessage("Loading...")
        progressdialog.show()

        try {

            ////////////calling get country with observing data it 'it'
            countryViewModel!!.getCountryData().observe(this, Observer {
                activityCountryListBinding!!.setVariable(BR.data, it)

                //// calling adapter with data from 'it' as list
                val adapter: CountryListAdapter = CountryListAdapter(it.getData() as List<CountryModel>,this)


                //// set adapter on recycle with binding
                activityCountryListBinding!!.countryRecycle.adapter = adapter

                ///////// set layoutManager on recycle with binding
                activityCountryListBinding!!.countryRecycle.layoutManager =LinearLayoutManager(applicationContext,RecyclerView.VERTICAL,false)
                progressdialog.dismiss()

            })
        }
        catch (e: Exception)
        {
            Log.d("CountryActivity",""+e)
            progressdialog.dismiss()
        }











    }
}





