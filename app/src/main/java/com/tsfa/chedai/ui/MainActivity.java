package com.tsfa.chedai.ui;

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

import com.jaeger.library.StatusBarUtil;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.tsfa.chedai.R;
import com.tsfa.chedai.adapter.IndicateAdapter;
import com.tsfa.chedai.app.App;
import com.tsfa.chedai.app.BaseActivity;
import com.tsfa.chedai.app.Constants;
import com.tsfa.chedai.fragment.main.OrderFragment;
import com.tsfa.chedai.fragment.main.ClientFragment;
import com.tsfa.chedai.fragment.main.HomeFargment;
import com.tsfa.chedai.fragment.main.MyFragment;
import com.tsfa.chedai.widget.CustomPopWindow;

import java.util.ArrayList;
import java.util.List;import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottomBar) BottomBar bottomBar;
    @BindView(R.id.mainboard) View mainboard;
    List<Fragment> views = new ArrayList<>();
    public static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance=this;
        setSwipeBackEnable(false);
        StatusBarUtil.setColor(MainActivity.this, Color.parseColor(Constants.FR_COLOR));

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
                        currTab(0);
                        viewpager.setCurrentItem(0, true);
                        break;
                    case R.id.tab_order:
                        currTab(1);
                        viewpager.setCurrentItem(1, true);
                        break;
                    case R.id.tab_client:
                        currTab(2);
                        viewpager.setCurrentItem(2, true);
                        break;
                    case R.id.tab_my:
                        currTab(3);
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
                    StatusBarUtil.setColor(MainActivity.this, Color.parseColor(Constants.FR_COLOR));
                } else if (pos == 1) {
                    StatusBarUtil.setColor(MainActivity.this, Color.parseColor(Constants.FR_COLOR));
                } else if (pos == 2) {
                    StatusBarUtil.setColor(MainActivity.this, Color.parseColor(Constants.FR_COLOR));
                }else if (pos == 3) {
                    StatusBarUtil.setColor(MainActivity.this, Color.parseColor(Constants.FR_COLOR));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    public void onFabActionNetClick(View view){
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_clock_arrange,null);
        //处理popWindow 显示内容
        //handleLogic(contentView);
        //创建并显示popWindow
         new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .enableBackgroundDark(true) //弹出popWindow时，背景是否变暗
                .setBgDarkAlpha(0.8f) // 控制亮度
                .setOnDissmissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        Log.e("TAG","onDismiss");
                    }
                })
                .create()

                //.showAsDropDown(mButton5,0,20);
                .showAtLocation(mainboard, Gravity.CENTER,0,0);
    }

    private void currTab(int itemId){
        if (itemId == 2){
            //fab_action_1=(FloatingActionButton)findViewById(R.id.fab_action_1);
            //fab_action_2=(FloatingActionButton)findViewById(R.id.fab_action_2);
            //fab_action_1.setVisibility(View.GONE);
            //fab_action_2.setVisibility(View.GONE);
        }
    }

    public View getMainBoard(){
        return mainboard;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    private void showExitDialog() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("确定退出GeekNews吗");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                App.getInstance().exitApp();
            }
        });
        builder.show();
    }


}
