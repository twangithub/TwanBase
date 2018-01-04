package com.tsfa.chedai.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by codeest on 2016/8/3.
 */
public class Constants {
    public static final String FR_COLOR="#75AAFA";

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "tsfanet";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tsfa" + File.separator + "chedai";


    public static final int CLOCK_LEFT_BAR_ROOM = 1;
}
