package com.example.divyanshukotlinmvvm.view.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.ActivityHomeBinding
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity()
{

    private var activityHomeBinding: ActivityHomeBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_home)

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



    }
}
