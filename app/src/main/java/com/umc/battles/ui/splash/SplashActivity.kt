package com.umc.battles.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.umc.battles.data.NetworkState
import com.umc.battles.databinding.ActivitySplashBinding
import com.umc.battles.ui.BaseActivity
import com.umc.battles.viewmodel.AuthViewModel


class SplashActivity: BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate){

    lateinit var authViewModel: AuthViewModel

    override fun initAfterBinding() {
        viewModelSetting()
        observerSetting()

        Handler(Looper.getMainLooper()).postDelayed({
            authViewModel.autoLogin()
        }, 2000)
    }

    private fun viewModelSetting() {
        authViewModel = ViewModelProvider(this)
            .get(AuthViewModel::class.java)
    }
    private fun observerSetting(){
        authViewModel.networkState.observe(this, Observer {
            when(it){
                NetworkState.ERROR -> {
                    showToast("네트워크에 문제가 발생했습니다.")
                    finish()
                }
                NetworkState.LOADED -> {}
                NetworkState.LOADING -> {}
            }
        })
        authViewModel.authResponse.observe(this, Observer {
            when(it.code){
            }
        })
    }
}