package com.umc.battles.ui.main.board

import com.umc.battles.databinding.FragmentBoardBinding
import com.umc.battles.ui.BaseFragment

class BoardFragment : BaseFragment<FragmentBoardBinding>(FragmentBoardBinding::inflate) {

    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {
        binding.layoutAllBoard.tvTitle.text = "전체게시판"
        binding.layoutSchoolBoard.tvTitle.text = "인하대게시판"
        binding.layoutHotBoard.tvTitle.text = "HOT 게시물"
    }
}