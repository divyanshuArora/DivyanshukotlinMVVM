package com.example.divyanshukotlinmvvm.view.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.ActivityRecyclerDrawerBinding
import com.example.divyanshukotlinmvvm.view.Adapters.DrawerRecyclerAdapter
import com.example.divyanshukotlinmvvm.viewmodel.Drawer_viewmodel
import kotlinx.android.synthetic.main.activity_main_dash_board.*
import kotlinx.android.synthetic.main.activity_recycler_drawer.*

class RecyclerDrawer : AppCompatActivity()
{

    var activityRecyclerDrawerBinding: ActivityRecyclerDrawerBinding ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityRecyclerDrawerBinding = DataBindingUtil.setContentView(this,R.layout.activity_recycler_drawer)
        val viewModelDrawer = ViewModelProviders.of(this).get(Drawer_viewmodel::class.java)

        setSupportActionBar(activityRecyclerDrawerBinding!!.toolbarRecycler)
        val actionBar = supportActionBar
        actionBar?.title = "Kotlin Tutorial"

        setDrawer()
        getDrawerList(viewModelDrawer)
    }

    private fun setDrawer()
    {

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(this,drawerRecyclerLayout,toolbarRecycler,R.string.drawer_open,R.string.drawer_close)
        {

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }


        }

        drawerToggle.isDrawerIndicatorEnabled = true
        activityRecyclerDrawerBinding!!.drawerRecyclerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()



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
