package com.twan.base.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.twan.swipebacklayout.app.SwipeBackActivity;
import com.twan.base.ui.MainActivity;

import butterknife.ButterKnife;


public abstract class BaseActivity extends SwipeBackActivity {
    protected Activity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        mContext = this;
        App.getInstance().addActivity(this);
        initEventAndData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
    }

    protected abstract int getLayout();

    protected abstract void initEventAndData();

}
