package com.example.divyanshukotlinmvvm.view

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.Utils.DatabaseHandler
import com.example.divyanshukotlinmvvm.databinding.ActivityLoginBinding
import com.example.divyanshukotlinmvvm.presenter.LoginClick

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var activityLoginBinding = DataBindingUtil.setContentView<ActivityLoginBinding>(this,R.layout.activity_login)
        activityLoginBinding!!.onloginClick = object : LoginClick
        {
            override fun loginClick()
            {


                val user_email = activityLoginBinding.loginEmail.text.toString()
                val user_pass = activityLoginBinding.loginPass.text.toString()


                var databaseHandler = DatabaseHandler(this@Login)

                val sqLiteDatabase: SQLiteDatabase

                sqLiteDatabase = databaseHandler.readableDatabase


                val loginQry = "SELECT * FROM users WHERE user_email= " + "'"+user_email+"'" + " AND user_password= " + "'"+user_pass+"'"
                Log.d("LoginActivity",loginQry)
                val cursor: Cursor =   sqLiteDatabase.rawQuery(loginQry, null)

                val cursorCount =cursor.count

                if (cursorCount>0)
                {
                    if (cursor.moveToFirst())
                    {
                        do
                            {
                                val user_id = cursor.getString(cursor.getColumnIndex("id"))

                                Log.d("LoginActivity","user_id: $user_id ")
                                Toast.makeText(applicationContext,"LoggedIn",Toast.LENGTH_SHORT).show()


                            }
                            while (cursor.moveToNext())

                    }
                }
                else
                {
                    Log.d("LoginActivity","not found")
                }













            }


        }





    }
}
