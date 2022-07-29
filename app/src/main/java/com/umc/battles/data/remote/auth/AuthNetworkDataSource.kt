package com.umc.battles.data.remote.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.umc.battles.ApplicationClass.Companion.retrofit
import com.umc.battles.data.NetworkState
import com.umc.battles.data.local.entities.User
import com.umc.battles.data.remote.auth.vo.AuthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthNetworkDataSource {
    private val _networkState = MutableLiveData<NetworkState>()
    private val _downloadAuthResponse = MutableLiveData<AuthResponse>()

    val networkState: LiveData<NetworkState> get() = _networkState
    val downloadAuthResponse: LiveData<AuthResponse> get() = _downloadAuthResponse

    private val authService = retrofit.create(AuthRetrofitInterface::class.java)

    fun login(user: User) {
        val loginCall = authService.login(user)
        _networkState.postValue(NetworkState.LOADING)

        loginCall.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                _downloadAuthResponse.postValue(response.body() as AuthResponse)
                _networkState.postValue(NetworkState.LOADED)
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                t.printStackTrace()
                _networkState.postValue(NetworkState.ERROR)
            }
        })
    }

    fun autoLogin() {
        val autoLoginCall = authService.autoLogin()
        _networkState.postValue(NetworkState.LOADING)

        autoLoginCall.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                _downloadAuthResponse.postValue(response.body() as AuthResponse)
                _networkState.postValue(NetworkState.LOADED)
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                t.printStackTrace()
                _networkState.postValue(NetworkState.ERROR)
            }
        })
    }

    fun signUp(user: User) {
        val signUpCall = authService.signUp(user)
        _networkState.postValue(NetworkState.LOADING)

        signUpCall.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                _downloadAuthResponse.postValue(response.body() as AuthResponse)
                _networkState.postValue(NetworkState.LOADED)
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                t.printStackTrace()
                _networkState.postValue(NetworkState.ERROR)
            }
        })
    }
}