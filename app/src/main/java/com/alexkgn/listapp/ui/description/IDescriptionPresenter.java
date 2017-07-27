package com.alexkgn.listapp.ui.description;

import com.alexkgn.listapp.ui.base.IPresenter;

/**
 * Created by Alex on 24.07.2017.
 */

public interface IDescriptionPresenter extends IPresenter<IDescriptionView> {

    void getPicture(int pictureId);

}
