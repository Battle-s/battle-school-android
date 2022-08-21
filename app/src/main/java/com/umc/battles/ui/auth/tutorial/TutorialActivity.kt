package com.umc.battles.ui.auth.tutorial

import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.umc.battles.databinding.ActivityTutorialBinding
import com.umc.battles.ui.BaseActivity
import com.umc.battles.ui.auth.tutorial.adapter.RVTutorialAdapter
import com.umc.battles.ui.main.MainActivity

class TutorialActivity : BaseActivity<ActivityTutorialBinding>(ActivityTutorialBinding::inflate) {

    override fun initAfterBinding() {
        initRVAdapter()
    }

    private fun initRVAdapter() {
        val adapter = RVTutorialAdapter(dumpList)
        binding.rvTutorial.adapter = adapter

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(binding.rvTutorial)

        binding.ci2PopularityContestImage.attachToRecyclerView(
            binding.rvTutorial,
            pagerSnapHelper
        )
        binding.ci2PopularityContestImage.adapterDataObserver.onChanged()
        binding.rvTutorial.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val ll = recyclerView.layoutManager as LinearLayoutManager
                val count = ll.itemCount
                val lastVisible = ll.findLastCompletelyVisibleItemPosition()
                if (lastVisible >= count - 1) lastImageCallBack()
            }
        })

        adapter.registerAdapterDataObserver(binding.ci2PopularityContestImage.adapterDataObserver)
    }

    private fun lastImageCallBack() {
        binding.btnBegin.isVisible = true
        binding.btnBegin.setOnClickListener { startActivityWithClear(MainActivity::class.java) }
    }

    private val dumpList = listOf(
        "https://img.freepik.com/free-vector/blue-technology-digital-banner-design_1017-32257.jpg?w=2000",
        "https://cdn.pixabay.com/photo/2015/10/29/14/38/web-1012467__340.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT94eF8n0RNHFzs2frZzUZDBSDZDBbX2I3bmQ&usqp=CAU"
    )
}