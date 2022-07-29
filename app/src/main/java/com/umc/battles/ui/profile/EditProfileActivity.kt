package com.umc.battles.ui.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.umc.battles.R
import com.umc.battles.databinding.ActivityEditProfileBinding


class EditProfileActivity : AppCompatActivity() {

    private val OPEN_GALLERY = 1
    lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_edit_profile)
        binding.cameraBackground.setOnClickListener{openGallery()}
        }

    private fun openGallery(){
        val intent:Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent,OPEN_GALLERY)
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLERY){
                var currentImageUrl : Uri? = data?.data
                try{
                    Glide.with(this).load(currentImageUrl).into(binding.ivProfile)
                    //val bitmap = MediaStore.Images.Media.getBitmap(contentResolver,currentImageUrl)
                    //binding.ivProfile.setImageBitmap(bitmap)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }else{
            Log.d("ActivityResult","somthing wrong")
        }
    }

}

