package com.example.divyanshukotlinmvvm.viewmodel

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.service.model.DrawerModel


class Drawer_viewmodel: ViewModel
{

    constructor(): super()

    var itemId: String = ""
    var item_image: String = ""
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

        var home ="https://img.icons8.com/cotton/2x/home--v1.png"
        var login ="https://png.pngtree.com/svg/20161229/e7a5cf5c9e.svg"
        var register ="http://cdn.onlinewebfonts.com/svg/img_349207.png"
        var sqlite ="https://icon-library.net/images/db-icon/db-icon-1.jpg"
        var country ="https://listimg.pinclipart.com/picdir/s/171-1719847_country-icon-png-clip-art-free-stock-country.png"
        var retrofit ="https://icon-library.net/images/rest-api-icon/rest-api-icon-8.jpg"


        val drawerModel =   DrawerModel("0",register,"Login With Sqllite")
        val drawerModel1 =   DrawerModel("1",register,"Register With Sqlite")
        val drawerModel2 =   DrawerModel("2",sqlite,"RecyclerView With Sqlite")
        val drawerModel3 =   DrawerModel("3",country,"Country API Parse")
        val drawerModel4 =   DrawerModel("4",retrofit,"Show Data As Per User ID")
        val drawerModel5 =   DrawerModel("5",retrofit,"Fake User List")
        val drawerModel6 =   DrawerModel("6",home,"Fragment")
        val drawerModel7 =   DrawerModel("7",home,"Tab Layout")
        val drawerModel8 =   DrawerModel("8",home,"Simple Navigation Drawer")

        val drawerViewmodel = Drawer_viewmodel(drawerModel)
        val drawerViewmodel1 = Drawer_viewmodel(drawerModel1)
        val drawerViewmodel2 = Drawer_viewmodel(drawerModel2)
        val drawerViewmodel3 = Drawer_viewmodel(drawerModel3)
        val drawerViewmodel4 = Drawer_viewmodel(drawerModel4)
        val drawerViewmodel5 = Drawer_viewmodel(drawerModel5)
        val drawerViewmodel6 = Drawer_viewmodel(drawerModel6)
        val drawerViewmodel7 = Drawer_viewmodel(drawerModel7)
        val drawerViewmodel8 = Drawer_viewmodel(drawerModel8)

        arrayList.add(drawerViewmodel)
        arrayList.add(drawerViewmodel1)
        arrayList.add(drawerViewmodel2)
        arrayList.add(drawerViewmodel3)
        arrayList.add(drawerViewmodel4)
        arrayList.add(drawerViewmodel5)
        arrayList.add(drawerViewmodel6)
        arrayList.add(drawerViewmodel7)
        arrayList.add(drawerViewmodel8)

        arrayMutableList.value = arrayList
        return arrayMutableList
    }







}