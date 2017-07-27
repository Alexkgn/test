package com.alexkgn.listapp.ui.main;

import com.alexkgn.listapp.ui.base.IPresenter;

/**
 * Created by Alex on 22.07.2017.
 */

public interface IMainPresenter extends IPresenter<IMainView> {

    void getAllPictures();

    void addNewPictureClick();

    void pictureClick(int pictureId);

}
