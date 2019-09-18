package com.example.divyanshukotlinmvvm.service.model

class DrawerModel
{
    var drawerItemId: String = ""
    var drawerItemImage: Int ?= null
    var drawerItemName: String = ""

    constructor(itemId: String,drawerItemImage: Int?, drawerItemName: String)
    {
        this.drawerItemId =itemId
        this.drawerItemImage = drawerItemImage
        this.drawerItemName = drawerItemName
    }
}