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

//import dagger.hilt.android.AndroidEntryPoint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.missionchurchcooljc.common.ui.BaseFragment
import com.missionchurchcooljc.data_android.WebsiteHighlight
import com.missionchurchcooljc.mcc.databinding.FragmentAboutUsBinding
import com.missionchurchcooljc.mcc.di.AppController
import javax.inject.Inject

//@AndroidEntryPoint
class AboutUsFragment : BaseFragment(), AboutUsMVP.View {
//class AboutUsFragment@Inject constructor(private val presenter: AboutUsMVP.Presenter) : BaseFragment() {

    //    private val args: GalleryFragmentArgs by navArgs()
//    private var searchJob: Job? = null
//    lateinit var websiteRepository: WebsiteRepository
//    private val viewModel = AboutUsViewModel(websiteRepository)
//    private val viewModel: AboutUsViewModel by viewModels()

    @Inject
    lateinit var presenter: AboutUsMVP.Presenter

    private val adapter = AboutUsAdapter()

//    @Inject
//    lateinit var websiteRepository: WebsiteRepository

    @Inject
    lateinit var dummyDependency: DummyDependency


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

        binding.highlightsRv.adapter = adapter
        subscribeUi(adapter)
        binding.dummy.text = "@ActivityScope dummyDependency: ${dummyDependency.hashCode()}\n"

//        findViewById<TextView>(R.id.dummy).text =
//            "@ActivityScope dummyDependency: ${dummyDependency.hashCode()}\n" +


//        return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root

    }

    private fun subscribeUi(adapter: AboutUsAdapter) {
        // TODO: This does nothing, highlights data sourced
//          from database seeding, not API yet, with Kotlin MVVN - API works
//        presenter.fetchPosts(websiteRepository)

//        val referenceValue = Integer.toHexString(System.identityHashCode(presenter))
//        val className = presenter.javaClass.canonicalName
//        val result = "$className@$referenceValue"
//        Log.d("reference",result)

//        viewModel.highlights.observe(viewLifecycleOwner) { wh: List<WebsiteHighlight> ->
//            adapter.submitList(wh)
//            Log.d(TAG, "WebsiteHighlight List Count ${wh.size}")
//        }

    }

    override fun displayPosts(
        highlights:
        MutableList<WebsiteHighlight>?
    ) {
        adapter.submitList(highlights)
    }

    companion object {
        private const val TAG = "WHdebug"

    }

    init {
        Log.d("LIFECYCLE", "{${this.javaClass.simpleName}} Class Created")
    }


}



