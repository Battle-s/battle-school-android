package com.umc.battles.ui.main.profile.editprofile

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.umc.battles.databinding.ActivityEditProfileBinding
import com.umc.battles.ui.BaseActivity

class EditProfileActivity :
    BaseActivity<ActivityEditProfileBinding>(ActivityEditProfileBinding::inflate) {

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            try {
                Glide.with(this).load(uri).into(binding.ivProfileImage)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    private val OPEN_GALLERY = 1
    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {
        initButton()
    }

    private fun initButton() {
        binding.ivCameraIcon.setOnClickListener {
            getContent.launch("image/*")
        }
    }
}

