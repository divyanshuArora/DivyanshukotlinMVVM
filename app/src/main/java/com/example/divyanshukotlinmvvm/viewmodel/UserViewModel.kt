package com.example.divyanshukotlinmvvm.viewmodel

import android.app.Activity
import android.database.Cursor
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.divyanshukotlinmvvm.Utils.DatabaseHandler
import com.example.divyanshukotlinmvvm.model.User


class UserViewModel() : ViewModel(), Parcelable {
    var arratListMutableLiveData : MutableLiveData<ArrayList<UserViewModel>> ?=  null
    var arrayList : ArrayList<UserViewModel> ?= null

    //var id = " "
    var name = ""
    var email = ""

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        email = parcel.readString()
    }
    //  var number = ""


    constructor(name:String,email:String) : this() {
        this.name = name
        this.email = email
    }



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

//    fun getData(user:User)
//    {
//        this.name = user.userName
//        this.email = user.userEmail
//
//    }

    fun getArrayList(): MutableLiveData<ArrayList<UserViewModel>>?
    {
        arrayList = ArrayList()

        var user = User("Divyanshu Arora","divyanshu.arora8@gmail.com")


      //  var userViewModel = UserViewModel(user)


        return arratListMutableLiveData
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserViewModel> {
        override fun createFromParcel(parcel: Parcel): UserViewModel {
            return UserViewModel(parcel)
        }

        override fun newArray(size: Int): Array<UserViewModel?> {
            return arrayOfNulls(size)
        }
    }


}








