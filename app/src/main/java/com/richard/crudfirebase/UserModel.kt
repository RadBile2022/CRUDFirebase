package com.richard.crudfirebase

class UserModel (
    var result: ArrayList<Result>
        ){

    data class Result (
        val name : String? =null,
        val email : String?=null)
}