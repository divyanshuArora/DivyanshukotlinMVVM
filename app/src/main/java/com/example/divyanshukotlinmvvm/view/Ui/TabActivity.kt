package com.example.divyanshukotlinmvvm.view.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.ActivityTabBinding
import com.example.divyanshukotlinmvvm.view.Adapters.TabAdapter
import com.example.divyanshukotlinmvvm.view.Ui.Fragments.FragmentSecond
import com.example.divyanshukotlinmvvm.view.Ui.Fragments.FragmentThird
import com.example.divyanshukotlinmvvm.view.Ui.Fragments.Fragment_one
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab.*
import org.jetbrains.anko.toolbar

class TabActivity : AppCompatActivity()
{

    var activityTabBinding:  ActivityTabBinding ?= null
//    var tabLayout: TabLayout ?= null
//    var viewPager: ViewPager ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityTabBinding = DataBindingUtil.setContentView(this,R.layout.activity_tab)

        val adapter = TabAdapter(supportFragmentManager)
        adapter.addFragment(Fragment_one(), "First")
        adapter.addFragment(FragmentSecond(), "Second")
        adapter.addFragment(FragmentThird(), "Third")
        activityTabBinding!!.viewPager.adapter = adapter
        activityTabBinding!!.tabLayout.setupWithViewPager(viewPager)


    }
}
