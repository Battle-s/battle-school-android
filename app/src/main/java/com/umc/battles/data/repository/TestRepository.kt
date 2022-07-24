package com.umc.battles.data.repository

import androidx.lifecycle.LiveData
import com.umc.battles.data.NetworkState
import com.umc.battles.data.remote.auth.AuthNetworkDataSource

class TestRepository : Repository {
    private val authNetworkDataSource = AuthNetworkDataSource()

    override var data: LiveData<*> = authNetworkDataSource.downloadAuthResponse

    override var networkState: LiveData<NetworkState> = authNetworkDataSource.networkState

    override fun fetchData() = authNetworkDataSource.autoLogin()
}