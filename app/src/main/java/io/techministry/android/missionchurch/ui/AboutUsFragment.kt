package io.techministry.android.missionchurch.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import dagger.hilt.android.AndroidEntryPoint
import io.techministry.android.missionchurch.adapters.AboutUsAdapter
import com.missionchurchcooljc.data_android.WebsiteHighlight
import io.techministry.android.missionchurch.databinding.FragmentAboutUsBinding
import io.techministry.android.missionchurch.viewmodel.AboutUsViewModel

@AndroidEntryPoint
class AboutUsFragment : Fragment() {

    //    private val args: GalleryFragmentArgs by navArgs()
//    private var searchJob: Job? = null
    private val viewModel: AboutUsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAboutUsBinding.inflate(inflater, container, false)
//        return binding.root
        context ?: return binding.root
        val adapter = AboutUsAdapter()

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


