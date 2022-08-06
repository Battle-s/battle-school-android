package com.umc.battles.ui.auth.bottomsheet.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.umc.battles.ui.auth.bottomsheet.SignUpSchoolInfoFragment
import com.umc.battles.ui.auth.bottomsheet.SignUpUserInfoFragment

class SignUpContentVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val schoolInfoFragment = SignUpSchoolInfoFragment().apply {
        onClickButton = { this@SignUpContentVPAdapter.onClickButton(it) }
    }
    private val userInfoFragment = SignUpUserInfoFragment().apply {
        onClickButton = { this@SignUpContentVPAdapter.onClickButton(it) }
    }

    var onClickButton: (String) -> Unit = {}

    private val fragmentList: ArrayList<Fragment> =
        arrayListOf(schoolInfoFragment, userInfoFragment)

    private val tagList: ArrayList<String> =
        arrayListOf(SignUpSchoolInfoFragment.Companion.TAG, SignUpUserInfoFragment.Companion.TAG)

    override fun getItemCount(): Int = fragmentList.size
    override fun createFragment(position: Int): Fragment = fragmentList[position]

    fun getFragmentTag(position: Int): String = tagList[position]
}