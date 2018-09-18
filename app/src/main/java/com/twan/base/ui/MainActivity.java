package com.twan.base.ui;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.twan.base.R;
import com.twan.base.adapter.IndicateAdapter;
import com.twan.base.app.App;
import com.twan.base.app.BaseActivity;
import com.twan.base.app.Constants;
import com.twan.base.fragment.main.OrderFragment;
import com.twan.base.fragment.main.ClientFragment;
import com.twan.base.fragment.main.HomeFargment;
import com.twan.base.fragment.main.MyFragment;
import com.twan.base.widget.CustomPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    @BindView(R.id.mainboard)
    View mainboard;
    List<Fragment> views = new ArrayList<>();
    public static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setSwipeBackEnable(false);
    }

    @Override
    protected void initEventAndData() {
        final ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        OrderFragment cashFragment = new OrderFragment();
        HomeFargment taskFargment = new HomeFargment();
        ClientFragment clockFragment = new ClientFragment();
        MyFragment myFragment = new MyFragment();
        views.clear();
        views.add(taskFargment);
        views.add(cashFragment);
        views.add(clockFragment);
        views.add(myFragment);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_index:
                        viewpager.setCurrentItem(0, true);
                        break;
                    case R.id.tab_order:
                        viewpager.setCurrentItem(1, true);
                        break;
                    case R.id.tab_client:
                        viewpager.setCurrentItem(2, true);
                        break;
                    case R.id.tab_my:
                        viewpager.setCurrentItem(3, true);
                        break;
                }
            }
        });

        IndicateAdapter myFragmentAdapter = new IndicateAdapter(getSupportFragmentManager(), views);
        viewpager.setAdapter(myFragmentAdapter);
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int pos, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int pos) {
                if (bottomBar != null) bottomBar.selectTabAtPosition(pos, true);
                if (pos == 0) {

                } else if (pos == 1) {

                } else if (pos == 2) {

                } else if (pos == 3) {

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
