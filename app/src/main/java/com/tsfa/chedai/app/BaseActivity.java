package com.tsfa.chedai.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.twan.swipebacklayout.app.SwipeBackActivity;
import com.tsfa.chedai.ui.MainActivity;
import butterknife.ButterKnife;



public abstract class BaseActivity extends SwipeBackActivity {
    protected Toolbar mToolbar;
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

    //移除fragment
    protected void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    protected abstract int getLayout();
    protected abstract void initEventAndData();

}
