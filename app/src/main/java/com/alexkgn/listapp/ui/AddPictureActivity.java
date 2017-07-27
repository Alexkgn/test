package com.alexkgn.listapp.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.alexkgn.listapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Alex on 23.07.2017.
 */

public class AddPictureActivity extends DaggerAppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
    }
}
