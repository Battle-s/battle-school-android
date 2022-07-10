package com.umc.battles.data.remote.auth.vo

import com.google.gson.annotations.SerializedName

data class Auth(@SerializedName("jwt") val jwt: String)
