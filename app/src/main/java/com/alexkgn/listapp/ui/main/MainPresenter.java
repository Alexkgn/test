package com.alexkgn.listapp.ui.main;

import com.alexkgn.listapp.data.Picture;
import com.alexkgn.listapp.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alex on 22.07.2017.
 */

public class MainPresenter extends BasePresenter<IMainView> implements IMainPresenter {

    @Inject
    public MainPresenter() {

    }

    @Override
    public void getAllPictures() {

    }

    @Override
    public void addNewPictureClick() {
        if (getView() != null) {
            getView().openAddPicture();
        }
    }

    @Override
    public void pictureClick(int pictureId) {
        if (getView() != null) {
            getView().showPictureFullInfo(pictureId);
        }
    }

    private void setContent(List<Picture> pictures) {
        if (getView() != null) {
            getView().setListPictures(pictures);
        }
    }
}
