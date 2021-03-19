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

package com.missionchurchcooljc.mcc.feature_highlights.mvvm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.missionchurchcooljc.common.ui.BaseFragment
import com.missionchurchcooljc.data_android.WebsiteHighlight
import com.missionchurchcooljc.mcc.databinding.FragmentAboutUsBinding
import com.missionchurchcooljc.mcc.di.AppController
import com.missionchurchcooljc.mcc.feature_highlights.AboutUsAdapter
import javax.inject.Inject

class HighlightsFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

//    private val viewModel: AboutUsViewModel by viewModels{ viewModelFactory }

    private lateinit var viewModel: AboutUsViewModel

    override fun onInitDependencyInjection() {
        val applicationComponent =
            (requireActivity().application as AppController).component
        applicationComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onInitDependencyInjection()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAboutUsBinding.inflate(inflater, container, false)
//        return binding.root
        context ?: return binding.root
        val adapter = AboutUsAdapter()

        viewModel = ViewModelProvider(this, viewModelFactory).get(AboutUsViewModel::class.java)

        binding.highlightsRv.adapter = adapter
        subscribeUi(adapter)

//        return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root

    }

    private fun subscribeUi(adapter: AboutUsAdapter) {
        viewModel.highlights.observe(viewLifecycleOwner) { wh: List<WebsiteHighlight> ->
            adapter.submitList(wh)
            Log.d(TAG, "WebsiteHighlight List Count ${wh.size}")

        }
        viewModel.retrieveHighlights()
//        viewModel.highlights.observe(viewLifecycleOwner) { highlihgt ->
//            adapter.submitList(highlihgt)
//        }
    }

    companion object {
        private const val TAG = "WHdebug"

    }

    init {
        Log.d("LIFECYCLE", "{${this.javaClass.simpleName}} Class Created")
    }
}