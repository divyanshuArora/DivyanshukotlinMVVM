package com.example.divyanshukotlinmvvm.view.Adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.UserBinding
import com.example.divyanshukotlinmvvm.view.Ui.CountryListActivity
import com.example.divyanshukotlinmvvm.viewmodel.UserViewModel
import org.jetbrains.anko.startActivity


class UserAdapter(private val context:Context, private val arrayList: ArrayList<UserViewModel>,val listner:itemClick): RecyclerView.Adapter<UserAdapter.ItemViewHolder>()
{

    val userList = arrayList

    companion object {
        var mClickListener: itemClick? = null
    }
    interface itemClick
    {
        fun clickItem(name: String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemViewHolder {
        val userBinding : UserBinding
        userBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.user_item,parent,false)
        return ItemViewHolder(userBinding)
     }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {
        val userInfo =  userList[position]
        mClickListener = listner
        holder.bind(userInfo)

        holder.itemView.setOnClickListener {

            mClickListener?.clickItem(userList[position].name)

            //context.startActivity(Intent(CountryListActivity))
            context.startActivity<CountryListActivity>()
            //Toast.makeText(context,"name: "+userList[position].name,Toast.LENGTH_SHORT).show()
        }
    }


    override fun getItemCount(): Int {

        Log.d("UserAdapter","list size"+userList.size.toString())
        return  userList.size
    }


   // inner
    class ItemViewHolder(var userBinding: UserBinding?): RecyclerView.ViewHolder(userBinding!!.root) {
        fun bind(userViewModel: UserViewModel)
       {
           this.userBinding!!.userModel = userViewModel
       }

   }




}


