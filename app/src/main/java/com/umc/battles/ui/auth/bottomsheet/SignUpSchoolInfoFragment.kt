package com.umc.battles.ui.auth.bottomsheet

import com.umc.battles.databinding.FragmentSignUpSchoolInfoBinding
import com.umc.battles.ui.BaseFragment

class SignUpSchoolInfoFragment :
    BaseFragment<FragmentSignUpSchoolInfoBinding>(FragmentSignUpSchoolInfoBinding::inflate) {
    var onClickButton: (String) -> Unit = {}

    override fun initAfterBinding() {
        binding.btnNext.setOnClickListener { onClickButton(TAG) }
    }

    companion object {
        const val TAG = "SignUpSchoolInfoFragment"
    }
}