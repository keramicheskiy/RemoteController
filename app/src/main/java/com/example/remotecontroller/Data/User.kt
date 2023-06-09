package com.example.remotecontroller.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val login: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val id: String = "",
) : Parcelable
