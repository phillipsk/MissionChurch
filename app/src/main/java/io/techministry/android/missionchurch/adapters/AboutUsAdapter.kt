package io.techministry.android.missionchurch.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.techministry.android.missionchurch.data.WebsiteHighlight
import io.techministry.android.missionchurch.databinding.ListItemAboutUsBinding

class AboutUsAdapter : ListAdapter<WebsiteHighlight, RecyclerView.ViewHolder>(PlantDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AboutUsViewHolder(
            ListItemAboutUsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plant = getItem(position)
        (holder as AboutUsViewHolder).bind(plant)
    }

    class AboutUsViewHolder(
        private val binding: ListItemAboutUsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.websiteHighlight?.let { wbh ->
                    navigateToHighlightDetails(wbh, it)
                }
            }
        }

        private fun navigateToHighlightDetails(
            websiteHighlight: WebsiteHighlight,
            view: View
        ) {
//            val direction =
//                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(
//                    websiteHighlight.websiteHighlightId
//                )
//            view.findNavController().navigate(direction)
        }

        fun bind(item: WebsiteHighlight) {
            binding.apply {
                websiteHighlight = item
                executePendingBindings()
            }
        }
    }
}

private class PlantDiffCallback : DiffUtil.ItemCallback<WebsiteHighlight>() {

    override fun areItemsTheSame(oldItem: WebsiteHighlight, newItem: WebsiteHighlight): Boolean {
        return oldItem.websiteHighlightId == newItem.websiteHighlightId
    }

    override fun areContentsTheSame(oldItem: WebsiteHighlight, newItem: WebsiteHighlight): Boolean {
        return oldItem == newItem
    }

}