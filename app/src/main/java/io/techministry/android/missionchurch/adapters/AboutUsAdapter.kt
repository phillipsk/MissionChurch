package io.techministry.android.missionchurch.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.missionchurchcooljc.data_android.WebsiteHighlight
import io.techministry.android.missionchurch.databinding.ListItemAboutUsBinding

class AboutUsAdapter : ListAdapter<WebsiteHighlight, AboutUsAdapter.ViewHolder>(DiffCallback()) {
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        implemented internal class ViewHolder vs. RecyclerView.ViewHolder
//    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemAboutUsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WebsiteHighlight) {

            if (item.title == null) binding.highlightTitle.visibility = View.GONE
            binding.websiteHighlight = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemAboutUsBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


internal class DiffCallback : DiffUtil.ItemCallback<WebsiteHighlight>() {

    override fun areItemsTheSame(oldItem: WebsiteHighlight, newItem: WebsiteHighlight): Boolean {
        return oldItem.highlightId == newItem.highlightId
    }

    override fun areContentsTheSame(oldItem: WebsiteHighlight, newItem: WebsiteHighlight): Boolean {
        return oldItem == newItem
    }

    init {
        Log.d("LIFECYCLE", "{${this.javaClass.simpleName}} Class Created")
    }

}