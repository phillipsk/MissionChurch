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

package io.fmc.ui.dashboard;


import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import io.fmc.R;
import io.fmc.di.DaggerLegacyAppComponent;
import io.fmc.di.LegacyAppComponent;
import io.fmc.ui.aboutus.AboutUsFragmentLegacy;
import io.fmc.ui.base.BaseActivity;
import io.fmc.ui.connect.StayConnectedFragment;
import io.fmc.ui.listen.AudiosFragment;
import io.fmc.ui.location.LocationFragment;
import io.fmc.ui.posts.PostsFragment;

//import io.fmc.ui.bible.BibleFragment;

public class DashboardActivity extends BaseActivity implements StayConnectedFragment.OnFragmentInteractionListener {

//    @BindView(R2.id.bottom_navigation) BottomNavigationView bottomNavigationView;
//    @BindView(R2.id.toolbar) Toolbar toolBar;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private LegacyAppComponent legacyAppComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dashboard);

//        ButterKnife.bind(this);

        legacyAppComponent = DaggerLegacyAppComponent.builder()
//                .postModule(new PostModule())
                .build();

        fragmentManager = getSupportFragmentManager();

//        setupBaseActionbar(toolBar,"Home",false);
//        setupBaseActionbar(toolBar,getString(R.string.app_name_long),false);


        setTupBottomNavigation();

//        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_the_word);
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_the_word);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_the_word);
//    }

    private void setTupBottomNavigation() {
        switchFragments(R.id.bottom_nav_the_word);

//        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//            switchFragments(item.getItemId());
//            return true;
//        });
////        This is a custom helper class
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


    }


    private void switchFragments(int position){
        Fragment fragment = fragmentManager.findFragmentByTag(String.valueOf(position));
        fragmentTransaction = fragmentManager.beginTransaction();

        for(Fragment eachFragment: fragmentManager.getFragments()){
            fragmentTransaction.hide(eachFragment);
        }

        if(fragment == null){
            Fragment newFrag = getItem(position);
            fragmentTransaction.add(R.id.container, newFrag,String.valueOf(position));
            fragmentTransaction.commit();
        }else{
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
        }
    }



    public Fragment getItem(int menu_id) {
        Fragment fragment = null;
//        fragment = new BibleFragment();
        if (menu_id == R.id.bottom_nav_connected) {
            fragment = new AboutUsFragmentLegacy();
//        }else if (menu_id == R.id.bottom_nav_connect){
//            fragment = new StayConnectedFragment();
        }else if(menu_id == R.id.bottom_nav_the_word) {
            fragment = new PostsFragment();  // to avoid Hilt dependency
        }else if (menu_id == R.id.bottom_nav_listen) {
            fragment = new AudiosFragment();
        } else if (menu_id == R.id.bottom_nav_prayer) {
            fragment = new AboutUsFragmentLegacy();
        } else if (menu_id == R.id.bottom_nav_info) {
            fragment = new LocationFragment();
        }
        return fragment;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public LegacyAppComponent getLegacyAppComponent() {
        return legacyAppComponent;
    }
}
