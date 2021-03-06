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

package com.missionchurchcooljc.mcc.posts;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.missionchurchcooljc.mcc.data.models.AnnouncementPost;
import com.missionchurchcooljc.mcc.di.AppController;
import com.missionchurchcooljc.mcc.postdetail.PostDetailActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.fmc.databinding.FragmentPostsBinding;
import io.fmc.ui.base.BaseFragment;
import io.fmc.ui.videoplayer.PlayerActivity;
import io.fmc.utils.SimpleDividerItemDecoration;


//@AndroidEntryPoint
public class PostsFragment extends BaseFragment implements PostMVP.View {

//    public PostsFragment(RecyclerView recyclerView, PostAdapter postAdapter, List<AnnouncementPost> posts, PostMVP.Presenter presenter) {
//        this.recyclerView = recyclerView;
//        this.postAdapter = postAdapter;
//        this.posts = posts;
//        this.presenter = presenter;
//    }

    //    @BindView(R.id.recyclerview)
    private FragmentPostsBinding binding;
    RecyclerView recyclerView;
    PostAdapter postAdapter;
    List<AnnouncementPost> posts = new ArrayList<>();

    @Inject
    PostMVP.Presenter presenter;

//    LegacyAppComponent component;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        PostModel postModel = new PostModel();
//        this.presenter = new PostFragmentPresenter(postModel);
//        MainActivity activity = (MainActivity) getActivity();

//        component =
//                ((DashboardActivity)getActivity()).getLegacyAppComponent();
//        component.inject(this);

//        ((DashboardActivity)getActivity()).
//                getLegacyAppComponent().inject(this);

//        (MainActivity)getActivity().(AppController).getApplication();
//
//        AppController component =
//                (AppController)requireActivity().getApplication();
        ((AppController) getActivity().getApplication()).getComponent().inject(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        View view = inflater.inflate(R.layout.fragment_posts, container, false);
//        ButterKnife.bind(this,view);
        binding = FragmentPostsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setupRecyclerView();

        presenter.setView(this);

        presenter.fetchPosts();

        return view;
    }

    private void setupRecyclerView() {
        postAdapter =  new PostAdapter(posts);
        postAdapter.setOnItemClickListener(new PostAdapter.PostAdapterListener() {
            @Override
            public void onItemSelected(AnnouncementPost post) {
                Intent intent;
                if(post.getContentType() == AnnouncementPost.Type.VIDEO) {
                    intent = new Intent(getContext(), PlayerActivity.class);
                    intent.putExtra("video_url", post.getVideo_url());
                } else {
                    // TODO: refactor to a Fragment, why switch from MainActivity > Navigation > PostsFragment > PostDetailActivity
                    intent = new Intent(getContext(), PostDetailActivity.class);
                    intent.putExtra("post", post);

                }
                startActivity(intent);

            }
        });
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        binding.recyclerView.setAdapter(postAdapter);
    }

    @Override
    public void displayPosts(List<AnnouncementPost> posts) {
        postAdapter.setData(posts);
    }

//commented until post activity enabled
//    @OnClick(R2.id.btn_add_post)
//    public void addPost(){
//
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
