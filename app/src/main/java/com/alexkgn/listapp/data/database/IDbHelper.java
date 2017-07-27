package com.alexkgn.listapp.data.database;

import android.support.annotation.NonNull;

import com.alexkgn.listapp.data.Picture;

import java.util.List;

/**
 * Created by Alex on 24.07.2017.
 */

public interface IDbHelper {

    boolean savePicture(@NonNull Picture picture);

    List<Picture> getPictureList();

}
