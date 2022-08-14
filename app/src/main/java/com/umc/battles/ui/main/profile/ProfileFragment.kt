package com.umc.battles.ui.main.profile

import com.umc.battles.databinding.FragmentProfileBinding
import com.umc.battles.ui.BaseActivity
import com.umc.battles.ui.BaseFragment
import com.umc.battles.ui.main.profile.editprofile.EditProfileActivity

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {
        initButton()
    }

    private fun initButton() {
        binding.itemProfile.layoutProfile.setOnClickListener {
            (requireActivity() as BaseActivity<*>).startNextActivity(EditProfileActivity::class.java)
        }
    }
}