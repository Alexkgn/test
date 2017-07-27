package com.alexkgn.listapp.ui.description;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexkgn.listapp.R;
import com.alexkgn.listapp.data.Picture;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Alex on 24.07.2017.
 */

public class DescriptionActivity extends DaggerAppCompatActivity implements IDescriptionView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.picture)
    ImageView vPicture;

    @BindView(R.id.title)
    TextView vTitle;

    @BindView(R.id.desctription)
    TextView vDescriptione;

    @Inject
    IDescriptionPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mPresenter.bind(this);
        //mPresenter.getPicture();

        initViews();
    }

    private void initViews() {

    }

    @Override
    public void showPicture(Picture picture) {
        vPicture.setImageBitmap(
                BitmapFactory.decodeByteArray(picture.getPicture(), 0, picture.getPicture().length));
        vTitle.setText(picture.getTitle());
        vDescriptione.setText(picture.getDescription());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
