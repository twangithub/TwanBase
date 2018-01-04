package com.tsfa.chedai.fragment.main;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.tsfa.chedai.R;
import com.tsfa.chedai.app.BaseFragment;
import com.tsfa.chedai.fragment.child.AddcFragment;
import com.tsfa.chedai.fragment.child.AppoFragment;
import com.tsfa.chedai.fragment.child.GoodFragment;
import com.tsfa.chedai.fragment.child.HistFragment;
import com.tsfa.chedai.fragment.child.ProjFragment;
import com.tsfa.chedai.fragment.child.RoomFragment;
import com.tsfa.chedai.fragment.child.TechFragment;
import com.tsfa.chedai.ui.MainActivity;
import com.tsfa.chedai.util.FragmentUtils;
import com.tsfa.chedai.widget.CustomPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by twan on 2017/10/26.
 */
public class ClientFragment extends BaseFragment {

    List<View> views = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_clock;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

//                            View contentView = LayoutInflater.from(mActivity).inflate(R.layout.pop_clock_arrange, null);
//                            //处理popWindow 显示内容
//                            //handleLogic(contentView);
//                            //创建并显示popWindow
//                            new CustomPopWindow.PopupWindowBuilder(mActivity)
//                                    .setView(contentView)
//                                    .enableBackgroundDark(true) //弹出popWindow时，背景是否变暗
//                                    .setBgDarkAlpha(0.8f) // 控制亮度
//                                    .setOnDissmissListener(new PopupWindow.OnDismissListener() {
//                                        @Override
//                                        public void onDismiss() {
//                                            Log.e("TAG", "onDismiss");
//                                        }
//                                    })
//                                    .create()
//
//                                    //.showAsDropDown(mButton5,0,20);
//                                    .showAtLocation(MainActivity.instance.getMainBoard(), Gravity.CENTER, 0, 0);
//                            //FragmentUtils.replace(getActivity().getSupportFragmentManager(),clock7Fragment,R.id.frame);

    }


    @Override
    protected void initData(Bundle arguments) {

    }
}
