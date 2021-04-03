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

package com.missionchurchcooljc.mcc.postdetail;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;

import com.missionchurchcooljc.mcc.data.models.AnnouncementPost;
import com.squareup.picasso.Picasso;

import io.fmc.R;
import io.fmc.databinding.ActivityPostDetailBinding;
import io.fmc.ui.base.BaseActivity;

//@AndroidEntryPoint
public class PostDetailActivity extends BaseActivity {

    private ActivityPostDetailBinding binding;
    AnnouncementPost post;
//    @BindView(R2.id.backdrop)
//    ImageView backdrop;
//    @BindView(R2.id.content)
//    TextView content;
//    @BindView(R2.id.toolbar)
//    Toolbar toolbar;
//    @BindView(R2.id.title)
//    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_post_detail);
//        ButterKnife.bind(this);
        binding = ActivityPostDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        post = (AnnouncementPost) getIntent().getExtras().getSerializable("post");

//        not needed for Kotlin refactor
//        setupBaseActionbar(toolbar, post.getTitle(), true);

        displayData();
    }

    private void displayData() {

        Picasso.with(getApplicationContext())
                .load(post.getImageUrl())
                .error(R.mipmap.ic_launcher_mcc_2020_round)
//                .resize(screenWidth, imageHeight)
                .fit()
//                .centerCrop()
                .centerInside()
                .into(binding.backdrop);


        binding.title.setText(post.getTitle());
        binding.content.setText(Html.fromHtml(post.getContent()));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
