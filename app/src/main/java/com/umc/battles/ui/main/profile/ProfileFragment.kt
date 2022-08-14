package com.umc.battles.ui.main.profile

import com.umc.battles.databinding.FragmentProfileBinding
import com.umc.battles.ui.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {}
}