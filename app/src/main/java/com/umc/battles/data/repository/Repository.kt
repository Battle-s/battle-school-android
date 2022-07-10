package com.umc.battles.data.repository

import androidx.lifecycle.LiveData
import com.umc.battles.data.NetworkState

interface Repository {
    val data: LiveData<*>
    val networkState: LiveData<NetworkState>

    fun fetchData()
}