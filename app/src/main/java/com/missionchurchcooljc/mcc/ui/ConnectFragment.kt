package com.missionchurchcooljc.mcc.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import dagger.hilt.android.AndroidEntryPoint
import io.fmc.R
import io.fmc.R2
import io.fmc.data.models.AnnouncementPost
import io.fmc.ui.posts.PostAdapter
import io.fmc.ui.posts.PostFragmentPresenter
import io.fmc.ui.posts.PostMVP
import io.fmc.ui.posts.PostModel

@AndroidEntryPoint
class ConnectFragment : Fragment(), PostMVP.View {
//class ConnectFragment : Fragment(), PostMVPkt.View {

    //    public PostsFragment(RecyclerView recyclerView, PostAdapter postAdapter, List<AnnouncementPost> posts, PostMVP.Presenter presenter) {
    //        this.recyclerView = recyclerView;
    //        this.postAdapter = postAdapter;
    //        this.posts = posts;
    //        this.presenter = presenter;
    //    }
    @BindView(R2.id.recyclerView)
    var recyclerView: RecyclerView? = null
    var postAdapter: PostAdapter? = null
    var posts: List<AnnouncementPost> = ArrayList()

    //    @Inject
//    lateinit var presenter: PostMVPkt.Presenter
    lateinit var presenter: PostMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val postModel = PostModel()
        presenter = PostFragmentPresenter(postModel)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        val binding = FragmentConnectBinding.inflate(
//            inflater,
//            container, false
//        )
//        return binding.root
        val view = inflater.inflate(R.layout.fragment_posts, container, false)

        ButterKnife.bind(this, view)

//        setupRecyclerView()

        presenter.setView(this)
        presenter.fetchPosts()

        return view
        //        return super.onCreateView(inflater, container, savedInstanceState)
    }

    init {
        Log.d("LIFECYCLE", "{${this.javaClass.simpleName}} Class Created")
    }

    override fun displayPosts(posts: List<AnnouncementPost?>?) {
        postAdapter?.setData(posts)
    }

    //    TODO: you cannot bind the MVP interface and inject with
    //      an @Inject constructor, review option of companion object
    //      or a new provides method in the Legacy module to provide
    //      the needed presenter: PostMVPkt.Presenter
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment BlankFragment.
//         */
//        // TODO: Rename and change types and number of parameters
////        @JvmStatic
////        fun newInstance(presenter: PostMVPkt.Presenter) =
////            ConnectFragment().apply {
////                arguments = Bundle().apply {
////                    putString(ARG_PARAM1, param1)
////                    putString(ARG_PARAM2, param2)
////                }
////            }
//    }

}