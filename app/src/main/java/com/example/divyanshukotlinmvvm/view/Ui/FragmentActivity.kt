package com.example.divyanshukotlinmvvm.view.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.view.Ui.Fragments.Fragment_one

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        replaceFrameWithFragment()


    }

    private fun replaceFrameWithFragment()
    {
        var fragment = Fragment_one()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameActivity,fragment)
        transaction.commit()
    }
}
