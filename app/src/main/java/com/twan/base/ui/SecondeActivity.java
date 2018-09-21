package com.twan.base.ui;

import android.os.Bundle;
import android.util.Log;

import com.twan.base.R;
import com.twan.base.api.Api;
import com.twan.base.app.BaseActivity;
import com.twan.base.entity.Bean;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by twan on 2017/10/24.
 */

public class SecondeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_second;
    }

    @Override
    protected void initEventAndData() {

//        Api.getApiService().getBlogs().doOnSubscribe(new Consumer<Subscription>() {
//            @Override
//            public void accept(Subscription subscription) throws Exception {
//                Log.e("tag", "请求开始了"+ subscription.toString());
//            }
//        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
//                .as(AutoDispose.<Bean>autoDisposable(AndroidLifecycleScopeProvider.from(this)))
//                .subscribe(new Consumer<Bean>() {
//                    @Override
//                    public void accept(Bean beanResult) throws Exception {
//                        Bean bean = beanResult;
//                        if (bean != null)
//                            Log.e("tag", bean.toString());
//                    }
//                });


        //模拟内存泄漏
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //AutoDispose的使用就是这句
                //.as(AutoDispose.<Long>autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.i("接收数据,当前线程" + Thread.currentThread().getName(), String.valueOf(aLong));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
