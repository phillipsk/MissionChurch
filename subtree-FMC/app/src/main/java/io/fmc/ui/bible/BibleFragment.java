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

package io.fmc.ui.bible;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import io.fmc.R;
import io.fmc.network.BibleBook;

//import io.fmc2.FellowshipApplication;

//@AndroidEntryPoint
public class BibleFragment extends Fragment implements BibleScreen {

    private final String bibleId = "de4e12af7f28f599-02";
    private RecyclerView recyclerView;
    private BooksAdapter booksAdapter;

    @Inject BiblePresenter biblePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View rv = inflater.inflate(R.layout.fragment_about_us_legacy,container,false);

        TextView mTextView = (TextView) rv.findViewById(R.id.text); //findViewById(R.id.text);


        return rv;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        AppController.getAppContext().getApplicationContext()
//        ((FellowshipApplication) context.getApplicationContext()).getAppComponent().inject(this);

        biblePresenter.bind(this);

        biblePresenter.fetchBibleBooks(bibleId);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(layoutManager);
        booksAdapter = new BooksAdapter();
        recyclerView.setAdapter(booksAdapter);
        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* In order to have to documentation work, they instantiate these variables above
        *     private RecyclerView mRecyclerView;
              private RecyclerView.Adapter mAdapter;
              private RecyclerView.LayoutManager mLayoutManager;

              mLayoutManager = new LinearLayoutManager(getActivity());
              mRecyclerView.setLayoutManager(mLayoutManager);
        */


    }

    @Override
    public void onDestroy() {
        biblePresenter.unbind();
        super.onDestroy();
    }

    @Override
    public void onNewBibleBooks(List<BibleBook> books) {
        booksAdapter.setItems(books);
    }

    /*    private void setUpRecyclerView(RecyclerView rv, ArrayList<AboutUsModel> models) {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
//        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(models);
        rv.setAdapter(adapter);
    }*/


    }

