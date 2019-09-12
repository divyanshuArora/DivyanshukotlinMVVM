package com.example.divyanshukotlinmvvm.viewmodel

import android.app.Activity
import android.app.Application
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


class UserViewModel : ViewModel
{
    var id = " "
    var name = ""
    var email = ""
    var number = ""

    constructor():super()

    constructor(user: User) : super()
    {
        this.name = user.userName
        this.email = user.userEmail
        this.number = user.userNumber
    }


    var arrayMutableList = MutableLiveData<ArrayList<UserViewModel>>()
    var arrayList = ArrayList<UserViewModel>()

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



    fun getArrayList(activity: Activity): MutableLiveData<ArrayList<UserViewModel>> {
        arrayList = ArrayList()

        ////////////static values
//        val user1 = User("Divyanshu Arora","divyanshu.arora8@gmail.com","7737729400")
//        val user2 = User("ABCD","abcd@gmail.com","1234567890")
//
//
//        val userViewModel1: UserViewModel = UserViewModel(user1)
//        val userViewModel2: UserViewModel = UserViewModel(user2)
//
//        arrayList!!.add(userViewModel1)
//        arrayList!!.add(userViewModel2)

        //var  databaseHandler = DatabaseHandler


        var databaseHandler = DatabaseHandler(activity)
        var sqLiteDatabase: SQLiteDatabase


        sqLiteDatabase = databaseHandler.readableDatabase

        var getDtaQry = "SELECT * FROM users"

        var cursor: Cursor = sqLiteDatabase.rawQuery(getDtaQry, null)

        var cursorCount = cursor.count

        if (cursorCount>0) {
            if (cursor.moveToFirst()) {

                do {

                    var userId = cursor.getString(cursor.getColumnIndex("id"))
                    var userName = cursor.getString(cursor.getColumnIndex("user_name"))
                    var userEmal = cursor.getString(cursor.getColumnIndex("user_email"))
                    var userNumber = cursor.getString(cursor.getColumnIndex("user_number"))


                    var user = User(userName,userEmal,userNumber)

                    var userViewModel = UserViewModel(user)
                    arrayList.add(userViewModel)




                   } while (cursor.moveToNext())
            }
        }
        arrayMutableList.value = arrayList

        return arrayMutableList
    }





}








