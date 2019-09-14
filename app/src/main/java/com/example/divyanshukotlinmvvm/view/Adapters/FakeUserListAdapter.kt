package com.example.divyanshukotlinmvvm.view.Adapters

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.CountryBinding
import com.example.divyanshukotlinmvvm.databinding.FakeUserBinding
import com.example.divyanshukotlinmvvm.service.model.CountryModel
import com.example.divyanshukotlinmvvm.service.model.FakeUserModel
import com.example.divyanshukotlinmvvm.view.Ui.CountryListActivity
import com.example.divyanshukotlinmvvm.viewmodel.CountryViewModel
import org.jetbrains.anko.image
import java.lang.reflect.Array

class FakeUserListAdapter(private val fakeUsers: List<FakeUserModel>, var context: Context) : RecyclerView.Adapter<FakeUserListAdapter.ItemViewHolder>()
{
    val FakeUserList = fakeUsers


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
    {
        val fakeUserBinding : FakeUserBinding
        fakeUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.fake_user_item,parent,false)
        return ItemViewHolder(fakeUserBinding)
    }

    override fun getItemCount(): Int
    {
        Log.d("FakeUserListSize",FakeUserList.size.toString())
        return FakeUserList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {
       // val userInfo =  countryArrayList[position]

        holder.bind(FakeUserList.get(position),position)
        //var imageView= holder.countryBinding.flagImg


    }

    class ItemViewHolder(val fakeUserBinding: FakeUserBinding) : RecyclerView.ViewHolder(fakeUserBinding.root)
    {
        fun bind( item: FakeUserModel,position: Int)
        {

            fakeUserBinding.fakeUserModel= item
            fakeUserBinding.executePendingBindings()
        }

    }





}