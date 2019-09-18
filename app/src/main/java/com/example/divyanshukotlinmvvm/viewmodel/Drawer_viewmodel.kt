package com.example.divyanshukotlinmvvm.viewmodel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.service.model.DrawerModel

class Drawer_viewmodel: ViewModel
{

    constructor(): super()

    var itemId: String = ""
    var item_image: Int ?= null
    var item_name: String = ""

    constructor(drawerModel: DrawerModel) : super()
    {
        this.itemId = drawerModel.drawerItemId
        this.item_image = drawerModel.drawerItemImage
        this.item_name = drawerModel.drawerItemName
    }

    var arrayMutableList = MutableLiveData<ArrayList<Drawer_viewmodel>>()
    var arrayList = ArrayList<Drawer_viewmodel>()


    fun getDrawerItem(): MutableLiveData<ArrayList<Drawer_viewmodel>>
    {

        arrayList = ArrayList()

        val drawerModel =   DrawerModel("0",R.drawable.home,"home")
        val drawerModel1 =   DrawerModel("1",R.drawable.home,"home")
        val drawerModel2 =   DrawerModel("2",R.drawable.home,"home")
        val drawerModel3 =   DrawerModel("3",R.drawable.home,"home")
        val drawerModel4 =   DrawerModel("4",R.drawable.home,"home")
        val drawerModel5 =   DrawerModel("5",R.drawable.home,"home")
        val drawerModel6 =   DrawerModel("6",R.drawable.home,"home")


        val drawerViewmodel = Drawer_viewmodel(drawerModel)
        val drawerViewmodel1 = Drawer_viewmodel(drawerModel1)
        val drawerViewmodel2 = Drawer_viewmodel(drawerModel2)
        val drawerViewmodel3 = Drawer_viewmodel(drawerModel3)
        val drawerViewmodel4 = Drawer_viewmodel(drawerModel4)
        val drawerViewmodel5 = Drawer_viewmodel(drawerModel5)
        val drawerViewmodel6 = Drawer_viewmodel(drawerModel6)


        arrayList.add(drawerViewmodel)
        arrayList.add(drawerViewmodel1)
        arrayList.add(drawerViewmodel2)
        arrayList.add(drawerViewmodel3)
        arrayList.add(drawerViewmodel4)
        arrayList.add(drawerViewmodel5)
        arrayList.add(drawerViewmodel6)



        arrayMutableList.value = arrayList
        return arrayMutableList
    }







}