package com.alexkgn.listapp.ui.add_picture;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alexkgn.listapp.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Alex on 23.07.2017.
 */

public class AddPictureActivity extends DaggerAppCompatActivity implements IAddView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.picture)
    ImageView vPicture;

    @BindView(R.id.title)
    EditText vTitle;

    @BindView(R.id.description)
    EditText vDescription;

    @BindView(R.id.save)
    Button vSave;

    @Inject
    AddPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picture);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mPresenter.bind(this);
        vTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.fetchPicture(s.toString());
                mPresenter.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        vDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setDescription(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick(R.id.save)
    public void onClick() {
        mPresenter.savePicture();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void setPicture(String url) {
        Picasso.with(this)
                .load(url)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                        vPicture.setImageBitmap(bitmap);
                        mPresenter.setPicture(bitmap);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                    }
                });
    }

    @Override
    public void pictureSaved() {
        Toast.makeText(this, "Изобраджение сохранено", Toast.LENGTH_SHORT).show();
    }
}
