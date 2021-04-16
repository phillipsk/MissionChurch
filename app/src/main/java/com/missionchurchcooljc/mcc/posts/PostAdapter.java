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

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.missionchurchcooljc.mcc.data.models.AnnouncementPost;

import java.util.List;
import java.util.Random;

import io.fmc.databinding.AdapterPostItemRowBinding;


/**
 * Created by  Kevin Phillips and Sunday Akinsete on 18/05/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private AdapterPostItemRowBinding binding;
    PostAdapterListener postAdapterListener;
    List<AnnouncementPost> posts;

    public PostAdapter(List<AnnouncementPost> posts) {
        this.posts = posts;
    }

    public interface PostAdapterListener {
        void onItemSelected(AnnouncementPost post);
    }

    public void setOnItemClickListener(PostAdapterListener onItemClickListener){
        postAdapterListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = AdapterPostItemRowBinding.inflate(LayoutInflater.from(parent.getContext()));
        View view = binding.getRoot();
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_post_item_row,parent,false);
        return new PostAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PostAdapterViewHolder postAdapterViewHolder = (PostAdapterViewHolder)holder;
        postAdapterViewHolder.setData(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setData(List<AnnouncementPost> data) {
        this.posts = data;
        notifyDataSetChanged();
    }


    public class PostAdapterViewHolder extends RecyclerView.ViewHolder {

//        @BindView(R2.id.post_title) TextView post_title;
//        @BindView(R2.id.post_date) TextView post_date;
//        @BindView(R2.id.post_content) TextView post_content;
//        @BindView(R2.id.favorite) TextView favorite;
//        @BindView(R2.id.view) TextView view;

        public PostAdapterViewHolder(View itemView) {
            super(itemView);

//            ButterKnife.bind(this,itemView);
        }

        public void setData(final AnnouncementPost post) {
            binding.postTitle.setText(post.getTitle());
            binding.postContent.setText(Html.fromHtml(post.getText()));
            binding.postDate.setText(post.getTimeDate(post.getDate()));
            Random r = new Random();
            int i1 = r.nextInt(18 - 5) + 5;
            int i2 = r.nextInt(18 - 5) + 5;
//            favorite.setText(String.valueOf(post.getLikes()));
            binding.favorite.setText(String.valueOf(i1));
            binding.view.setText(String.valueOf(i2));

            Log.e("favorite", String.valueOf(post.getLiked()));


            if (postAdapterListener != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        postAdapterListener.onItemSelected(post);
                    }
                });
            }
        }
    }

}
