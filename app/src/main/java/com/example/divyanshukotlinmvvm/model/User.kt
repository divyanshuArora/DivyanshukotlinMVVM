package com.example.divyanshukotlinmvvm.model

class User
{

    var userName: String = ""
    var userEmail: String = ""
    var userNumber: String = ""
    var userPassword: String = ""

    constructor(userName: String, userEmail: String, userNumber: String, userPassword: String)
    {
        this.userName = userName
        this.userEmail = userEmail
        this.userNumber = userNumber
        this.userPassword = userPassword
    }
}