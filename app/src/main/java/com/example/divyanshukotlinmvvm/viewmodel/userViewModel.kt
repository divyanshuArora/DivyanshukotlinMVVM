package com.example.divyanshukotlinmvvm.viewmodel

import android.app.Activity
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.divyanshukotlinmvvm.Utils.DatabaseHandler
import com.example.divyanshukotlinmvvm.model.User


class userViewModel : ViewModel
{

//
//    var name = ObservableField<String>("")
//    var email = ObservableField<String>("")
//    var number = ObservableField<String>("")
//    var password = ObservableField<String>("")
//
//    var resultData = MutableLiveData<String>()


    constructor() : super()



    fun registerData(user: User,activity: Activity)
    {

        Log.d("userViewModel",user.userName)
        Log.d("userViewModel",user.userEmail)
        Log.d("userViewModel",user.userNumber)
        Log.d("userViewModel",user.userPassword)


       var user = User(user.userName,user.userEmail,user.userNumber,user.userPassword)

        var databasehandler = DatabaseHandler(activity)
        databasehandler.addUser(user)
    }



//    fun getRegisterUser():MutableLiveData<String>
//    {
//        return resultData
//    }



}