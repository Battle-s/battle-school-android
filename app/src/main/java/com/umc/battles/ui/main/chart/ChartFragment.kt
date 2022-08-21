package com.umc.battles.ui.main.chart

import com.umc.battles.databinding.FragmentChartBinding
import com.umc.battles.ui.BaseFragment

class ChartFragment : BaseFragment<FragmentChartBinding>(FragmentChartBinding::inflate) {

    private val categoryTagList = listOf("운동", "e-sports", "보드게임", "학술")

    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {
        initTabLayout()
    }

    private fun initTabLayout() {

        with(binding.tlCategory) {
            categoryTagList.forEach { this.addTab(this.newTab().setText(it)) }
        }
    }
}