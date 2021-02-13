package io.fmc.ui.posts.postdetail;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fmc.R;
import io.fmc.R2;
import io.fmc.data.models.AnnouncementPost;
import io.fmc.ui.base.BaseActivity;

public class PostDetailActivity extends BaseActivity {

    AnnouncementPost post;
    @BindView(R2.id.backdrop)
    ImageView backdrop;
    @BindView(R2.id.content)
    TextView content;
    @BindView(R2.id.toolbar)
    Toolbar toolbar;
    @BindView(R2.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        ButterKnife.bind(this);

        post = (AnnouncementPost) getIntent().getExtras().getSerializable("post");

        setupBaseActionbar(toolbar, post.getTitle(), true);

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
                .into(backdrop);
        


        title.setText(post.getTitle());
        content.setText(Html.fromHtml(post.getContent()));
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
