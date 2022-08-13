package com.umc.battles.ui.main.board

import android.content.Intent
import com.umc.battles.databinding.FragmentBoardBinding
import com.umc.battles.ui.BaseActivity
import com.umc.battles.ui.BaseFragment
import com.umc.battles.ui.main.board.detail.BoardActivity

class BoardFragment : BaseFragment<FragmentBoardBinding>(FragmentBoardBinding::inflate) {

    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {
        binding.layoutAllBoard.tvTitle.text = "전체게시판"
        binding.layoutSchoolBoard.tvTitle.text = "인하대게시판"
        binding.layoutHotBoard.tvTitle.text = "HOT 게시물"

        buttonSetting()
    }

    private fun buttonSetting() {
        binding.layoutAllBoard.btnMore.setOnClickListener { startActivity(board_all) }
        binding.layoutSchoolBoard.btnMore.setOnClickListener { startActivity(board_school) }
        binding.layoutHotBoard.btnMore.setOnClickListener { startActivity(board_hot) }
    }

    private fun startActivity(tag: String) {
        val intent = Intent(requireContext(), BoardActivity::class.java)
        intent.putExtra(board_tag, tag)
        (requireActivity() as BaseActivity<*>).startNextActivityWithIntent(intent)
    }

    companion object {
        const val board_tag = "board_tag"
        const val board_all = "board_all"
        const val board_school = "board_school"
        const val board_hot = "board_hot"
    }
}