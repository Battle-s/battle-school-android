package com.umc.battles.ui.main.battle.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.umc.battles.ui.main.battle.battle.BattleJoinFragment
import com.umc.battles.ui.main.battle.club.ClubJoinFragment

class BattleVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> BattleJoinFragment()
        else -> ClubJoinFragment()
    }
}