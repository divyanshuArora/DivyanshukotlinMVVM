package com.example.divyanshukotlinmvvm.view.Ui.Fragments

import android.content.Context
import android.database.DatabaseUtils
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.FragmentThirdBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentThird : Fragment() {

    var fragmentThirdBinding : FragmentThirdBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        fragmentThirdBinding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_third,container,false)
        var view: View = fragmentThirdBinding!!.root

        return view
    }


    override fun onDetach() {
        super.onDetach()



    }


    




    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentThird().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
