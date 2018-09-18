package com.twan.base.util;

import android.app.Activity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

public class RxPermissionsUtil {

    //use rxpermission
    public static void requestPermission(final Activity context, final PermissionListener listener, String... permissions) {
        try {
            RxPermissions rxPermissions = new RxPermissions(context);
            rxPermissions.request(permissions)
                    .subscribe(new Consumer<Boolean>() {
                                   @Override
                                   public void accept(Boolean aBoolean) throws Exception {
                                       if (aBoolean) {
                                           if (listener != null) listener.onSucces();
                                       } else {
                                           ToastUtil.shortShow("请开启权限");
                                       }
                                   }
                               }
                    );
        } catch (Exception e) {
            LogUtil.e(e.toString());
        }
    }

    public interface PermissionListener {
        void onSucces();
    }
}
