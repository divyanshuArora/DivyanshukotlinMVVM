package com.example.divyanshukotlinmvvm.view.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.ActivityHomeBinding
import com.example.divyanshukotlinmvvm.view.Ui.Fragments.Fragment_one
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity()
{

    private var activityHomeBinding: ActivityHomeBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        activityHomeBinding!!.loginSqlite.setOnClickListener {
            startActivity<Login>()
        }

        activityHomeBinding!!.registerSqlite.setOnClickListener {
            startActivity<MainActivity>()
        }

        activityHomeBinding!!.SqliteRecycle.setOnClickListener {
            startActivity<Dashboard>()
        }

        activityHomeBinding!!.countryApiParse.setOnClickListener {
            startActivity<CountryListActivity>()
        }

        activityHomeBinding!!.asPerUser.setOnClickListener {
            startActivity<UserSelectionActivity>()
        }

        activityHomeBinding!!.FakeUserList.setOnClickListener {
            startActivity<FakeUsersActivity>()
        }


        activityHomeBinding!!.fragment.setOnClickListener {
            startActivity<FragmentActivity>()
        }


        activityHomeBinding!!.tabActivity.setOnClickListener {
            startActivity<TabActivity>()
        }




    }
}
