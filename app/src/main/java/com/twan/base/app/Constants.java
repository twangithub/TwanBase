package com.twan.base.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by Twan on 2016/8/3.
 */
public class Constants {
    public static final String FR_COLOR = "#75AAFA";

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "base";
    public static final String PATH_CACHE = PATH_DATA + "/cache";

}
