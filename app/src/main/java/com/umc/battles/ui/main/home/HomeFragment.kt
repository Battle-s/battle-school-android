package com.umc.battles.ui.main.home

import androidx.recyclerview.widget.PagerSnapHelper
import com.umc.battles.databinding.FragmentHomeBinding
import com.umc.battles.ui.BaseFragment
import com.umc.battles.ui.main.home.adapter.RVImageAdapter
import kotlinx.coroutines.*


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var rvImageAdapter: RVImageAdapter
    private val autoScrollDelayTime = 3000L
    private var job: Job? = null

    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {
        initRVAdapter()
    }

    private fun initRVAdapter() {
        rvImageAdapter = RVImageAdapter(dumpList)
        binding.rvPopularityContestImage.adapter = rvImageAdapter

        val pagerSnapHelper = PagerSnapHelper().apply {

        }
        pagerSnapHelper.attachToRecyclerView(binding.rvPopularityContestImage)

        binding.ci2PopularityContestImage.attachToRecyclerView(
            binding.rvPopularityContestImage,
            pagerSnapHelper
        )
        rvImageAdapter.registerAdapterDataObserver(binding.ci2PopularityContestImage.adapterDataObserver)

        job = CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                delay(autoScrollDelayTime)
                val size = binding.rvPopularityContestImage.adapter!!.itemCount

                val currentIdx = pagerSnapHelper.findTargetSnapPosition(
                    binding.rvPopularityContestImage.layoutManager!!,
                    0,
                    0
                )
                binding.rvPopularityContestImage.smoothScrollToPosition((currentIdx + 1) % size)
            }
        }
    }

    override fun onDestroyView() {
        job?.cancel()
        super.onDestroyView()
    }

    private val dumpList = listOf(
        "https://img.freepik.com/free-vector/blue-technology-digital-banner-design_1017-32257.jpg?w=2000",
        "https://cdn.pixabay.com/photo/2015/10/29/14/38/web-1012467__340.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT94eF8n0RNHFzs2frZzUZDBSDZDBbX2I3bmQ&usqp=CAU"
    )
}