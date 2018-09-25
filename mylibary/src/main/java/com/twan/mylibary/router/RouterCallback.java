package com.twan.mylibary.router;

import android.app.Activity;

/**
 * Created by twan on 2017/11/2.
 */

public interface RouterCallback {

    void onBefore(Activity from, Class<?> to);

    void onNext(Activity from, Class<?> to);

    void onError(Activity from, Class<?> to, Throwable throwable);

}
