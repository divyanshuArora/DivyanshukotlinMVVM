package com.example.divyanshukotlinmvvm.viewmodel

import android.app.Activity
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.divyanshukotlinmvvm.Utils.DatabaseHandler
import com.example.divyanshukotlinmvvm.service.model.Users


class UserViewModel : ViewModel
{
    var id = " "
    var name = ""
    var email = ""
    var number = ""


    constructor():super()


    constructor(users: Users) : super()
    {
        this.name = users.userName
        this.email = users.userEmail
        this.number = users.userNumber
    }


    var arrayMutableList = MutableLiveData<ArrayList<UserViewModel>>()
    var arrayList = ArrayList<UserViewModel>()

    fun registerData(users: Users, activity: Activity)
    {

        Log.d("userViewModel",users.userName)
        Log.d("userViewModel",users.userEmail)
        Log.d("userViewModel",users.userNumber)
        Log.d("userViewModel",users.userPassword)


       var user = Users(
           users.userName,
           users.userEmail,
           users.userNumber,
           users.userPassword
       )

        var databasehandler = DatabaseHandler(activity)
        databasehandler.addUser(user)
    }




    ///////////////////////////////

    fun getArrayList(activity: Activity): MutableLiveData<ArrayList<UserViewModel>> {
        arrayList = ArrayList()

        ////////////static values
//        val user1 = Users("Divyanshu Arora","divyanshu.arora8@gmail.com","7737729400")
//        val user2 = Users("ABCD","abcd@gmail.com","1234567890")
//
//
//        val userViewModel1: UserViewModel = UserViewModel(user1)
//        val userViewModel2: UserViewModel = UserViewModel(user2)
//
//        arrayList!!.add(userViewModel1)
//        arrayList!!.add(userViewModel2)




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


                    var user = Users(
                        userName,
                        userEmal,
                        userNumber
                    )

                    var userViewModel = UserViewModel(user)
                    arrayList.add(userViewModel)




                   } while (cursor.moveToNext())
            }
        }
        arrayMutableList.value = arrayList

        return arrayMutableList
    }





}








