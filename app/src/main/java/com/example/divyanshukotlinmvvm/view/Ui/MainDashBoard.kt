package com.example.divyanshukotlinmvvm.view.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.ActivityMainDashBoardBinding
import com.example.divyanshukotlinmvvm.databinding.ActivityTabBinding
import kotlinx.android.synthetic.main.activity_main_dash_board.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.drawerLayout

class MainDashBoard : AppCompatActivity() {

    var activityMainDashBoardBinding: ActivityMainDashBoardBinding ?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        activityMainDashBoardBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_dash_board)
        setSupportActionBar(activityMainDashBoardBinding!!.toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Kotlin Tutorial"

        setDrawer()
    }

    private fun setDrawer()
    {
            val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close)
            {

                override fun onDrawerOpened(drawerView: View) {
                    super.onDrawerOpened(drawerView)
                }

                override fun onDrawerClosed(drawerView: View) {
                    super.onDrawerClosed(drawerView)
                }


            }


        drawerToggle.isDrawerIndicatorEnabled = true
        activityMainDashBoardBinding!!.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()


        navigation_view.setNavigationItemSelectedListener {

            when(it.itemId)
            {

                R.id.action_Login ->
                {
                    startActivity<Login>()

                }

                R.id.action_Register->
                {
                    startActivity<MainActivity>()
                }

                R.id.action_CountryApi->
                {
                    startActivity<CountryListActivity>()
                }

                R.id.action_FakeUser->
                {
                    startActivity<FakeUsersActivity>()
                }

                R.id.action_ShowData->
                {
                    startActivity<UserSelectionActivity>()
                }
                R.id.action_SqliteRecycle->
                {
                    startActivity<Dashboard>()
                }

                R.id.action_Fragment->
                {
                    startActivity<FragmentActivity>()
                }



                R.id.action_TabLayout->
                {
                    startActivity<TabActivity>()
                }





            }
            activityMainDashBoardBinding!!.drawerLayout.closeDrawer(GravityCompat.START)
            true



        }














    }








}
