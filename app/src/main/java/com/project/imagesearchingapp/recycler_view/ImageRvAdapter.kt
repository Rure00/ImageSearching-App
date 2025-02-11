package com.project.imagesearchingapp.recycler_view

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.project.imagesearchingapp.R
import com.project.imagesearchingapp.data.ImageData
import com.project.imagesearchingapp.databinding.ImageRecyclerItemBinding

class ImageRvAdapter(private val itemList: List<ImageData>,
                     private val showHeart: Boolean,
                     private val onClick: (ImageData) -> Unit): RecyclerView.Adapter<ImageRvAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(private val binding: ImageRecyclerItemBinding): ViewHolder(binding.root) {
        fun bind(item: ImageData) {
            Glide.with(binding.root)
                .load(item.imageUrl)
                .into(binding.image)
            with(binding) {
                fromText.text = item.from
                timeText.text = item.time
                favorite.visibility = if(showHeart) View.VISIBLE
                                    else View.INVISIBLE

                root.setOnClickListener {
                    favorite.visibility = if(favorite.visibility == View.VISIBLE) View.INVISIBLE
                                        else View.VISIBLE
                    onClick(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_recycler_item, parent, false)
        return ImageViewHolder(ImageRecyclerItemBinding.bind(view))
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}