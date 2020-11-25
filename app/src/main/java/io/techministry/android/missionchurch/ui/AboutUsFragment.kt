package io.techministry.android.missionchurch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import io.techministry.android.missionchurch.adapters.AboutUsAdapter
import io.techministry.android.missionchurch.databinding.FragmentAboutUsBinding
import io.techministry.android.missionchurch.viewmodel.AboutUsViewModel
import kotlinx.coroutines.Job

class AboutUsFragment : Fragment() {
    private val adapter = AboutUsAdapter()
//    private val args: GalleryFragmentArgs by navArgs()
//    private var searchJob: Job? = null
//    private val viewModel: AboutUsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAboutUsBinding.inflate(inflater, container, false)
//        return binding.root
        context ?: return binding.root

        binding.photoList.adapter = adapter
        subscribeUi(adapter)

//        return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root

    }

    private fun subscribeUi(adapter: AboutUsAdapter) {
//        viewModel.plants.observe(viewLifecycleOwner) { plants ->
//            adapter.submitList(plants)
    }
}


