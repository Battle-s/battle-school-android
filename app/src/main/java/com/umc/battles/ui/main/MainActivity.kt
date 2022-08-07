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
                R.id.fragment_battle -> binding.fabBattle.isSelected = true
                else -> binding.fabBattle.isSelected = false
            }
        }

        binding.bnvMain.setupWithNavController(navController)

        binding.fabBattle.setOnClickListener {
            binding.bnvMain.selectedItemId = R.id.fragment_battle
        }
    }
}