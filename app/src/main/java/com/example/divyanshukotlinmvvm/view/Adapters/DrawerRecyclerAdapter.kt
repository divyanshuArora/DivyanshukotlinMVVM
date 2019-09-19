package com.example.divyanshukotlinmvvm.view.Adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.DrawerModelBind
import com.example.divyanshukotlinmvvm.view.Ui.*
import com.example.divyanshukotlinmvvm.viewmodel.Drawer_viewmodel
import org.jetbrains.anko.startActivity


class DrawerRecyclerAdapter(var context: Context,var list:ArrayList<Drawer_viewmodel>) :RecyclerView.Adapter<DrawerRecyclerAdapter.ItemViewHolder>()
{

    val code=10

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
    {
    var drawerModelBind: DrawerModelBind= DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_demo_item,parent,false)
        return ItemViewHolder(drawerModelBind)
    }

    override fun getItemCount(): Int
    {
      return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {
        holder.drawerModelBinding(list[position],position)

        holder.drawerModelBind.itemDrawerRecycler.setOnClickListener{

                var pos = list[position].itemId

            Log.d("DrawerRecyclerAdapter","Position: $pos")


            when(pos)
            {
                "0" ->
                {
                    context.startActivity<Login>()
                }

                "1" ->
                {
                    context.startActivity<MainActivity>()
                }

                "2" ->
                {
                    context.startActivity<Dashboard>()
                }

                "3" ->
                {
                    context.startActivity<CountryListActivity>()
                }
                "4" ->
                {
                    context.startActivity<UserSelectionActivity>()
                }

                "5" ->
                {
                    context.startActivity<FakeUsersActivity>()
                }

                "6" ->
                {
                    context.startActivity<FragmentActivity>()

                }

                "7" ->
                {
                    context.startActivity<TabActivity>()
                }

                "8" ->
                {
                    context.startActivity<MainDashBoard>()
                }



            }




        }


    }

    class ItemViewHolder( val drawerModelBind: DrawerModelBind) : RecyclerView.ViewHolder(drawerModelBind.root)
    {
        fun drawerModelBinding(item:Drawer_viewmodel,position: Int)
        {
            drawerModelBind.drawerViewModel = item
            drawerModelBind.executePendingBindings()
        }

    }

}