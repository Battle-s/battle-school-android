package com.umc.battles.ui.main.battle

import com.google.android.material.tabs.TabLayoutMediator
import com.umc.battles.databinding.FragmentBattleBinding
import com.umc.battles.ui.BaseFragment
import com.umc.battles.ui.main.battle.adapter.BattleVPAdapter

class BattleFragment : BaseFragment<FragmentBattleBinding>(FragmentBattleBinding::inflate) {

    private val contentTagList = listOf("경기 참여", "동아리 가입")
    private val categoryTagList = listOf("인기", "운동", "e-sports", "보드게임", "학술")

    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        with(binding.tlBattleCategory) {
            categoryTagList.forEach { this.addTab(this.newTab().setText(it)) }
        }
    }

    private fun initViewPager() {
        binding.vpBattleContent.adapter = BattleVPAdapter(this)
        TabLayoutMediator(binding.tlContent, binding.vpBattleContent) { tab, position ->
            tab.text = contentTagList[position]
        }.attach()
    }
}