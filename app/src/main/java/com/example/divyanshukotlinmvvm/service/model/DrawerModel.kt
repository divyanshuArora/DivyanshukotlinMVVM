package com.example.divyanshukotlinmvvm.service.model

class DrawerModel
{
    var drawerItemId: String = ""
    var drawerItemImage: String = ""
    var drawerItemName: String = ""

    constructor(itemId: String,drawerItemImage: String, drawerItemName: String)
    {
        this.drawerItemId =itemId
        this.drawerItemImage = drawerItemImage
        this.drawerItemName = drawerItemName
    }
}