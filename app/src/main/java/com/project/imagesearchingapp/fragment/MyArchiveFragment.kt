package com.project.imagesearchingapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.imagesearchingapp.R
import com.project.imagesearchingapp.data.ImageData
import com.project.imagesearchingapp.databinding.FragmentMyArchiveBinding
import com.project.imagesearchingapp.recycler_view.ImageRvAdapter

class MyArchiveFragment : Fragment() {
    private var _binding: FragmentMyArchiveBinding? = null
    private val binding get() = _binding!!

    private val imageList = mutableListOf<ImageData>()
    private val imageRvAdapter = ImageRvAdapter(imageList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyArchiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.archiveRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = imageRvAdapter.apply { notifyItemRangeInserted(0, imageList.size) }
        }
    }
}