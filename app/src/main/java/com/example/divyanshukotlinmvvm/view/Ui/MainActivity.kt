package com.example.divyanshukotlinmvvm.view.Ui

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.Utils.SharedPreferences
import com.example.divyanshukotlinmvvm.databinding.ActivityMainBinding
import com.example.divyanshukotlinmvvm.service.model.Users
import com.example.divyanshukotlinmvvm.interfaces.Presenter
import com.example.divyanshukotlinmvvm.viewmodel.UserViewModel
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {
    /////////////Sqlite DataBase Managed
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = SharedPreferences(this@MainActivity)

//        if (sharedPreferences!!.getLoginSession()) {
//            var intent = Intent(applicationContext, Dashboard::class.java)
//            startActivity(intent)
//        }

        var activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        var viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        activityMainBinding!!.register = object : Presenter {
            override fun registerClick() {
                Toast.makeText(applicationContext, "hello", Toast.LENGTH_SHORT).show()

                var name: String = activityMainBinding.edName.text.toString()
                var email: String = activityMainBinding.edEmail.text.toString()
                var number: String = activityMainBinding.edContact.text.toString()
                var password: String = activityMainBinding.edPassword.text.toString()

                if (name.isEmpty()) {
                    activityMainBinding.edName.setError("Enter your Name")
                    return
                } else if (email.isEmpty()) {
                    activityMainBinding.edEmail.setError("Enter your Email")
                    return
                } else if (number.isEmpty()) {
                    activityMainBinding.edContact.setError("Enter your Number")
                    return
                } else if (password.isEmpty()) {
                    activityMainBinding.edPassword.setError("Enter your Password")
                    return
                }
                var user = Users(name, email, number, password
                )
                viewModel.registerData(user, this@MainActivity)
            }
        }



        activityMainBinding.txtLogin.setOnClickListener {

//            var intent = Intent(applicationContext, Login::class.java)
//            startActivity(intent)


            startActivity<Login>()

        }


    }
}