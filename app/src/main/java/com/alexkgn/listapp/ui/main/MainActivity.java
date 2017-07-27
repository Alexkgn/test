package com.alexkgn.listapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.alexkgn.listapp.R;
import com.alexkgn.listapp.data.Picture;
import com.alexkgn.listapp.ui.AddPictureActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements IMainView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.list_pictures)
    RecyclerView vListPictures;

    @BindView(R.id.fab)
    FloatingActionButton vAddNewPicture;

    @Inject
    IMainPresenter mPresenter;

    PicturesAdapter mPicturesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mPresenter.bind(this);
        mPresenter.getAllPictures();

        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }

    private void initViews() {
        mPicturesAdapter = new PicturesAdapter(null, new PicturesAdapter.Callbacks() {
            @Override
            public void onPictureClick(int pictureId) {
                mPresenter.pictureClick(pictureId);
            }
        });
        vListPictures.setLayoutManager(new LinearLayoutManager(this));
        vListPictures.setAdapter(mPicturesAdapter);
    }

    @OnClick(R.id.fab)
    public void addNewPicture(FloatingActionButton fab) {
        mPresenter.addNewPictureClick();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void setListPictures(List<Picture> pictures) {
        mPicturesAdapter.updateListPictures(pictures);
    }

    @Override
    public void showPictureFullInfo(int id) {

    }

    @Override
    public void openAddPicture() {
        startActivity(new Intent(this, AddPictureActivity.class));
    }
}
