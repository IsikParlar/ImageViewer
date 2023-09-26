package com.example.imageviewer.model

import com.google.gson.annotations.SerializedName

data class Member(
    @SerializedName("avatar_url")
    val avatarUrl: String
)