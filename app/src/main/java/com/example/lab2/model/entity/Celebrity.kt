package com.example.lab2.model.entity

import com.google.gson.annotations.SerializedName

data class Celebrity(
    val name: String,
    @SerializedName("net_worth")
    val netWorth: Int,
    val age: Int,
)