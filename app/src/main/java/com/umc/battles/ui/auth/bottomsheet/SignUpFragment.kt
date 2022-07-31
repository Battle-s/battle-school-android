package com.umc.battles.ui.auth.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.umc.battles.databinding.FragmentSignUpBinding
import com.umc.battles.ui.BaseActivity
import com.umc.battles.ui.auth.bottomsheet.adapter.SignUpContentVPAdapter
import com.umc.battles.ui.main.MainActivity


class SignUpFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val adapter = SignUpContentVPAdapter(this)
            .apply { onClickButton = this@SignUpFragment::onClickButton }
        binding.vpSignupContent.adapter = adapter

        binding.vpSignupContent.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                val tag = adapter.getFragmentTag(position)

                binding.tvSignupTitle.text =
                    if (tag == SignUpSchoolInfoFragment.TAG) "학교정보" else "사용자 정보"
                binding.btnBack.setOnClickListener {
                    if (tag == SignUpSchoolInfoFragment.TAG) {
                    } else {
                        val size = binding.vpSignupContent.adapter!!.itemCount
                        val currentIdx = binding.vpSignupContent.currentItem
                        binding.vpSignupContent.currentItem = (currentIdx - 1)
                    }
                }
            }
        })
    }

    private fun onClickButton(tag: String) {
        if (tag == SignUpSchoolInfoFragment.TAG) {
            val size = binding.vpSignupContent.adapter!!.itemCount
            val currentIdx = binding.vpSignupContent.currentItem
            binding.vpSignupContent.currentItem = (currentIdx + 1)
        } else {
            (requireActivity() as BaseActivity<*>).startActivityWithClear(MainActivity::class.java)
        }
    }
}