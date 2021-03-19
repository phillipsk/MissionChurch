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

package io.fmc.ui.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import io.fmc.R;

/**
 * Created by  Kevin Phillips and Sunday Akinsete on 16/05/2018.
 */

// TODO: There are 2 BaseFragments across different packages
public class BaseFragment extends Fragment {

    ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    public void showLoading(String message){
        progressDialog = ProgressDialog.show(getContext(),null,message,false,false);
    }

    public void hideLaoding(){
        if(progressDialog != null){
            if(progressDialog.isShowing()){
                progressDialog.cancel();
            }
        }
    }

    public void showMessage(String message, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(null);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok,positiveListener);
        builder.setPositiveButton(R.string.cancel,negativeListener);
        builder.create().show();
    }

    public void showMessage(String message, DialogInterface.OnClickListener positiveListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(null);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok,positiveListener);
        builder.create().show();
    }


}
