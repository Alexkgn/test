package com.alexkgn.listapp.ui.main;

import com.alexkgn.listapp.data.Picture;
import com.alexkgn.listapp.ui.base.IView;

import java.util.List;

/**
 * Created by Alex on 22.07.2017.
 */

public interface IMainView extends IView {

    void setListPictures(List<Picture> pictures);

    void showPictureFullInfo(int id);

    void openAddPicture();

}
