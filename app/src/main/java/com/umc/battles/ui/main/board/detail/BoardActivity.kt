package com.umc.battles.ui.main.board.detail

import com.umc.battles.databinding.ActivityBoardBinding
import com.umc.battles.ui.BaseActivity
import com.umc.battles.ui.main.board.BoardFragment.Companion.board_all
import com.umc.battles.ui.main.board.BoardFragment.Companion.board_hot
import com.umc.battles.ui.main.board.BoardFragment.Companion.board_school
import com.umc.battles.ui.main.board.BoardFragment.Companion.board_tag
import com.umc.battles.ui.main.board.WritingActivity

class BoardActivity : BaseActivity<ActivityBoardBinding>(ActivityBoardBinding::inflate) {

    private val tag: String by lazy { intent.getStringExtra(board_tag) ?: "Invalid Tag" }

    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {
        initButton()
        binding.tvBoardTitle.text = when (tag) {
            board_all -> "전체게시판"
            board_school -> "인하대게시판"
            board_hot -> "HOT 게시물"
            else -> {
                finish()
                ""
            }
        }
    }
    private fun initButton(){
        binding.fabNewBulletin.setOnClickListener{
            startNextActivity(WritingActivity::class.java)
        }
    }
}