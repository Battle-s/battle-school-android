package com.umc.battles.ui.main

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.umc.battles.R
import com.umc.battles.databinding.ActivityMainBinding
import com.umc.battles.ui.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun initAfterBinding() {
        buttonSetting()
    }

    private fun buttonSetting() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_content) as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragment_battle -> {
                    binding.tvMenuTitle.text = "BATTLE'S"
                    binding.fabBattle.isSelected = true
                }
                R.id.fragment_chart -> {
                    binding.tvMenuTitle.text = "랭킹"
                    binding.fabBattle.isSelected = false
                }
                R.id.fragment_board -> {
                    binding.tvMenuTitle.text = "게시판"
                    binding.fabBattle.isSelected = false
                }
                R.id.fragment_profile -> {
                    binding.tvMenuTitle.text = "마이프로필"
                    binding.fabBattle.isSelected = false
                }
                else -> {
                    binding.tvMenuTitle.text = "BATTLE'S"
                    binding.fabBattle.isSelected = false
                }
            }
        }

        binding.bnvMain.setupWithNavController(navController)

        binding.fabBattle.setOnClickListener {
            binding.bnvMain.selectedItemId = R.id.fragment_battle
        }
    }
}