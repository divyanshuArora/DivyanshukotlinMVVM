package com.example.divyanshukotlinmvvm.view.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.ActivityUserSelectionBinding
import com.example.divyanshukotlinmvvm.service.model.UserSelectionModel
import com.example.divyanshukotlinmvvm.view.Adapters.SeletctedUserAdapter
import com.example.divyanshukotlinmvvm.viewmodel.UserSelectionViewModel
import okhttp3.ResponseBody
import java.lang.Exception

@Suppress("UNCHECKED_CAST")
class UserSelectionActivity : AppCompatActivity() {

   var activityUserSelectionActivity: ActivityUserSelectionBinding ?= null
   //var userSelectionModelView: UserSelectionViewModel ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityUserSelectionActivity = DataBindingUtil.setContentView(this,R.layout.activity_user_selection)
       var userSelectionModelView:UserSelectionViewModel = ViewModelProviders.of(this).get(UserSelectionViewModel::class.java)

        activityUserSelectionActivity!!.button.setOnClickListener {

            var userId =    activityUserSelectionActivity!!.editText.text.toString()
            Log.d("UserSelectionActivity","userId: "+userId)

            callSelectedUsers(userId,userSelectionModelView)
        }
    }

    private fun callSelectedUsers(userId: String,userSelectionModelView:UserSelectionViewModel)
    {
        try {
            userSelectionModelView.getSelectedUser(userId).observe(this, Observer {
                   // activityUserSelectionActivity!!.setVariable(BR.selectStudentItemBind, it)

                    val selectedUserAdapter = SeletctedUserAdapter(this, it as List<UserSelectionModel>)
                    activityUserSelectionActivity!!.recyclerSelectedUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                activityUserSelectionActivity!!.recyclerSelectedUser.adapter = selectedUserAdapter
            })
        }
        catch (e: Exception)
        {
            Log.d("SelectedUserActivity","Exception "+e)
        }
    }
}
