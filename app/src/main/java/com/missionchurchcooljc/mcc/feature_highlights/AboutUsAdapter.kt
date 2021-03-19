/*
 * Copyright (c) 2021 Kevin Phillips, Mission Church of Our Lord Jesus Christ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.missionchurchcooljc.mcc.feature_highlights

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.missionchurchcooljc.data_android.WebsiteHighlight
import com.missionchurchcooljc.mcc.databinding.ListItemAboutUsBinding

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
        init {
            binding.setClickListener { view ->
                binding.websiteHighlight?.let { wh ->
                    if (wh.followUrl != null) {
                        val uri = Uri.parse(wh.followUrl)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        view.context.startActivity(intent)
                    }
                }
            }
        }

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