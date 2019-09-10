package com.example.divyanshukotlinmvvm.view.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.UserItemBinding
import com.example.divyanshukotlinmvvm.viewmodel.UserViewModel


class UserAdapter(private  var listener: OnUserClickListner): RecyclerView.Adapter<RecyclerView.ViewHolder>()
{


    val userList = ArrayList<UserViewModel>()

    fun setuserRecycle(user: ArrayList<UserViewModel>)
    {
        userList.addAll(user)
        notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        val userBinding : UserItemBinding
        val layoutInflater = LayoutInflater.from(parent.context)
        userBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.user_item,parent,false)
 //       val userItemBinding = UserItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerHolderCatIcon(userBinding)


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val userInfo =  userList[position]

        (holder as UserAdapter.RecyclerHolderCatIcon).bind(userInfo,listener)


    }


    override fun getItemCount(): Int {

        Log.d("UserAdapter","list size"+userList.size.toString())
        return  userList.size
    }


    inner class     RecyclerHolderCatIcon(var userBinding: UserItemBinding?): RecyclerView.ViewHolder(userBinding!!.root) {
        fun bind(user: UserViewModel, listener: OnUserClickListner)
        {
            userBinding!!.userModel = user
        }

    }

    interface OnUserClickListner
    {
            fun onUserClick(position: Int)

    }


}


