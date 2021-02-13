package io.techministry.android.fellowshipmissionchurch;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fmc.R;
import io.fmc.R2;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA_ID = "EXTRA_DATA_ID";

    @BindView(R2.id.toolbar) Toolbar toolbar;
    @BindView(R2.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_view);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra(EXTRA_DATA_ID)) {
            collapsingToolbar.setTitle(getIntent().getStringExtra(EXTRA_DATA_ID));
        }

    }
}
