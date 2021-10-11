package com.fingermidia.mvvmproject2.models

import java.io.Serializable

data class Store(
    var name: String,
    var fantasyName: String,
    var document: String,
    var number: Int,
    var typeAddress: String,
    var address: String,
    var neighborhood: String,
    var city: String,
    var state: String,
    var category: String,
    var email: String
) : Serializable