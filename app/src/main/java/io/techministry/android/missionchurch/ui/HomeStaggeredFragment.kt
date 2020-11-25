package io.techministry.android.missionchurch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import io.techministry.android.missionchurch.R
import io.techministry.android.missionchurch.databinding.FragmentBlankBinding

class HomeStaggeredFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBlankBinding.inflate(inflater, container, false)

//        val binding = dataBinding!!  //.inflate(inflater, container, false)
//        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        return binding.root
//        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
//class HomeStaggeredFragment : BaseDataBindingFragment<FragmentPostListStaggeredBinding>() {
//
//
//    override fun getLayoutRes(): Int = R.layout.fragment_post_list_staggered
//
//    private val viewModel by viewModels<PostsCoroutineViewModel>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        viewModel.getPosts()
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        bindViews()
//    }
//
//    private fun bindViews() {
//
//        val binding = dataBinding!!
//
//
//        // Set lifecycle for data binding
//        binding.lifecycleOwner = viewLifecycleOwner
//
//        binding.viewModel = viewModel
//
//        binding.recyclerView.apply {
//
//            // Set Layout manager
//            this.layoutManager =
//                StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
//
//            // Set RecyclerViewAdapter
//            this.adapter =
//                PostListAdapter(R.layout.row_post_staggered, viewModel::onClick)
//        }
//
//        subscribeGoToDetailScreen()
//
//
//    }
//
//    private fun subscribeGoToDetailScreen() {
//
//        viewModel.goToDetailScreen.observe(viewLifecycleOwner, Observer {
//
//            it.getContentIfNotHandled()?.let { post ->
//                val bundle = bundleOf("post" to post)
//
//                /*
//         This is navController we get from findNavController not the one required
//         for navigating nested fragments
//      */
//                requireActivity().findNavController(R.id.main_nav_host_fragment)
//                    .navigate(R.id.action_mainFragment_to_postDetailFragment, bundle)
//
////                val mainNavController =
////                    Navigation.findNavController(requireActivity(), R.id.main_nav_host_fragment)
////                mainNavController.navigate(R.id.action_mainFragment_to_postDetailFragment, bundle)
//            }
//        })
//
//    }
//
//
//}