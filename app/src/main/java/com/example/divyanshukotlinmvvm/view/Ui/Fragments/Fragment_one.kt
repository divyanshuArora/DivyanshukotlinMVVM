package com.example.divyanshukotlinmvvm.view.Ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.FragmentOneBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment_one : Fragment() {

    var fragmentOneBinding : FragmentOneBinding ?= null


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentOneBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_one,container,false)

        var view: View = fragmentOneBinding!!.root

        fragmentOneBinding!!.button1.setOnClickListener {

            /*var frameLay: FrameLayout = view.findViewById(R.id.fragmentOne)
            frameLay.removeAllViews()*/

            var fragmentManager:FragmentManager = this!!.fragmentManager!!

            var fragmSec:FragmentSecond= FragmentSecond()

            val fm = getFragmentManager()
            val ft = fm!!.beginTransaction()
            ft.replace(R.id.fragmentOne, fragmSec)
            ft.addToBackStack(null)
            ft.commit()
        }
        fragmentOneBinding!!.button2.setOnClickListener {
            /*var frameLay: FrameLayout = view.findViewById(R.id.fragmentOne)
            frameLay.removeAllViews()*/

            var fragmentManager:FragmentManager = this!!.fragmentManager!!
            val fm = getFragmentManager()
            val ft = fm!!.beginTransaction()
            ft.replace(R.id.fragmentOne, FragmentThird())
            ft.addToBackStack(null)
            ft.commit()

        }

        return view
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_one().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
