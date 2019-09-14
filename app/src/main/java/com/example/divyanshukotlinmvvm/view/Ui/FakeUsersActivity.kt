package com.example.divyanshukotlinmvvm.view.Ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.ActivityFakeUsersBinding
import com.example.divyanshukotlinmvvm.databinding.FakeUserBinding
import com.example.divyanshukotlinmvvm.service.model.FakeUserModel
import com.example.divyanshukotlinmvvm.view.Adapters.FakeUserListAdapter
import com.example.divyanshukotlinmvvm.viewmodel.FakeUserViewModel

class FakeUsersActivity : AppCompatActivity()
{

    var fakeUserActivityBinding: ActivityFakeUsersBinding ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fakeUserActivityBinding = DataBindingUtil.setContentView(this,R.layout.activity_fake_users)
        val fakeUserViewUserModel = ViewModelProviders.of(this).get(FakeUserViewModel::class.java)

      //  getFakeUserList(fakeUserViewUserModel)

        fakeUserActivityBinding!!.search.setOnClickListener {

            getFakeUserList(fakeUserViewUserModel)

        }



    }


    fun getFakeUserList(viewModel: FakeUserViewModel)
    {

        var page =  fakeUserActivityBinding!!.fakeEdit.text.toString()

        viewModel.getSelectedFakeUser(page,applicationContext).observe(this, Observer {

            fakeUserActivityBinding!!.setVariable(BR.fakeData,it)

            val adapter = FakeUserListAdapter(it.getData() as List<FakeUserModel>,this)
            fakeUserActivityBinding!!.fakeUsersRecycle.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
            fakeUserActivityBinding!!.fakeUsersRecycle.adapter = adapter

        })
    }



}
