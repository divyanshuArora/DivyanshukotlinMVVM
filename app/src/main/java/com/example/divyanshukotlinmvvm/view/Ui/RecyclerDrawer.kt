package com.example.divyanshukotlinmvvm.view.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.ActivityRecyclerDrawerBinding
import com.example.divyanshukotlinmvvm.view.Adapters.DrawerRecyclerAdapter
import com.example.divyanshukotlinmvvm.viewmodel.Drawer_viewmodel

class RecyclerDrawer : AppCompatActivity()
{

    var activityRecyclerDrawerBinding: ActivityRecyclerDrawerBinding ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityRecyclerDrawerBinding = DataBindingUtil.setContentView(this,R.layout.activity_recycler_drawer)
        val viewModelDrawer = ViewModelProviders.of(this).get(Drawer_viewmodel::class.java)


        getDrawerList(viewModelDrawer)



    }

    private fun getDrawerList(viewModelDrawer: Drawer_viewmodel)
    {

        viewModelDrawer.getDrawerItem().observe(this,androidx.lifecycle.Observer {Drawer_viewmodel->
            val drawerAdapter = DrawerRecyclerAdapter(this,Drawer_viewmodel)
            activityRecyclerDrawerBinding!!.drawerRecylerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            activityRecyclerDrawerBinding!!.drawerRecylerView.adapter = drawerAdapter
        })
    }
}
