package com.example.insta_clone

class UserInfo
{
    var FullName:String?=null
    var Password:String?=null
    var Email:String?=null
    var Gender:String?=null
    constructor(FullName:String,Email:String,Password:String,Gender:String)
    {
        this.FullName = FullName
        this.Email = Email
        this.Password = Password
        this.Gender = Gender
    }

}