package com.example.divyanshukotlinmvvm.view.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.Utils.SharedPreferences
import com.example.divyanshukotlinmvvm.view.Adapters.UserAdapter
import com.example.divyanshukotlinmvvm.viewmodel.UserViewModel

class Dashboard : AppCompatActivity(),UserAdapter.itemClick {

    /////////////Sqlite DataBase Managed


    override fun clickItem(name: String) {
        Toast.makeText(applicationContext,"userName: "+name,Toast.LENGTH_SHORT).show()
    }

    private var recyclerView : RecyclerView ?= null
    private var userAdapter: UserAdapter ?= null
    private var logout: TextView ?= null
    private var sharedPreferences : SharedPreferences ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        sharedPreferences = SharedPreferences(this)

        recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        logout = findViewById(R.id.logout)

        logout!!.setOnClickListener {
            sharedPreferences!!.clearSharedPreference()
            var intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            finish() }
        getData()
    }

    fun getData()
    {
        var userViewModel: UserViewModel= ViewModelProviders.of(this).get(UserViewModel::class.java)

        userViewModel.getArrayList(this@Dashboard).observe(this, Observer {UserViewModel->

            userAdapter = UserAdapter(this@Dashboard,UserViewModel,this)

            var linearLayoutManager : LinearLayoutManager ?= LinearLayoutManager(this)
            recyclerView?.layoutManager = linearLayoutManager
            recyclerView?.adapter = userAdapter


        })

    }



}
