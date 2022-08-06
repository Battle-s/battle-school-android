package com.umc.battles.ui.auth.bottomsheet

import com.umc.battles.databinding.FragmentSignUpUserInfoBinding
import com.umc.battles.ui.BaseFragment

class SignUpUserInfoFragment :
    BaseFragment<FragmentSignUpUserInfoBinding>(FragmentSignUpUserInfoBinding::inflate) {
    var onClickButton: (String) -> Unit = {}

    override fun initAfterBinding() {
        binding.btnNext.setOnClickListener { onClickButton(SignUpSchoolInfoFragment.TAG) }
    }

    companion object {
        const val TAG = "SignUpUserInfoFragment"
    }
}