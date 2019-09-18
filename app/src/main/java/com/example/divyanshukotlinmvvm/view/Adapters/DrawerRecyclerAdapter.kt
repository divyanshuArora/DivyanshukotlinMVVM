package com.example.divyanshukotlinmvvm.view.Adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.service.model.DrawerModel
import com.example.divyanshukotlinmvvm.viewmodel.Drawer_viewmodel

class DrawerRecyclerAdapter(context: Context,list:ArrayList<Drawer_viewmodel>) :RecyclerView.Adapter<DrawerRecyclerAdapter.ItemViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawerRecyclerAdapter.ItemViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: DrawerRecyclerAdapter.ItemViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }





}