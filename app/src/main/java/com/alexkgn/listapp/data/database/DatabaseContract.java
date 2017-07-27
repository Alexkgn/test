package com.alexkgn.listapp.data.database;

import android.provider.BaseColumns;

/**
 * Created by Alex on 24.07.2017.
 */

public class DatabaseContract {

    public static abstract class PictureEntry implements BaseColumns {
        public static final String TABLE_NAME = "pictures";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PICTURE = "picture";
    }

}
