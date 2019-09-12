package com.example.divyanshukotlinmvvm.view.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.CountryBinding
import com.example.divyanshukotlinmvvm.service.model.CountryModel
import com.example.divyanshukotlinmvvm.view.Ui.CountryListActivity
import com.example.divyanshukotlinmvvm.viewmodel.CountryViewModel
import java.lang.reflect.Array

class CountryListAdapter(private val context: Context, private val countryResponse: List<CountryModel>) : RecyclerView.Adapter<CountryListAdapter.ItemViewHolder>()
{


    val countryList = countryResponse

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
    {
        val countryBinding : CountryBinding
        countryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.country_list_item,parent,false)
        return ItemViewHolder(countryBinding)
    }

    override fun getItemCount(): Int
    {
        Log.d("CountryAdapter",countryList.size.toString())
        return countryList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {
       // val userInfo =  countryArrayList[position]

        holder.bind(countryList.get(position),position)
    }

    class ItemViewHolder(var countryBinding: CountryBinding) : RecyclerView.ViewHolder(countryBinding!!.root)
    {
        fun bind(item: CountryModel,position: Int)
        {
            //this.countryBinding!!.countryModel = countryViewModel
            countryBinding.executePendingBindings()
        }

    }





}