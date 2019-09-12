package com.example.divyanshukotlinmvvm.view.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.CountryBinding
import com.example.divyanshukotlinmvvm.viewmodel.CountryViewModel

class CountryListAdapter(private val context: Context,private val countryArrayList: ArrayList<CountryViewModel>) : RecyclerView.Adapter<CountryListAdapter.ItemViewHolder>()
{

    val countryList = countryArrayList

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
        val userInfo =  countryArrayList[position]

        holder.bind(userInfo)
    }

    class ItemViewHolder(var countryBinding: CountryBinding) : RecyclerView.ViewHolder(countryBinding!!.root)
    {
        fun bind(countryViewModel: CountryViewModel)
        {
            this.countryBinding!!.countryModel = countryViewModel
        }

    }





}