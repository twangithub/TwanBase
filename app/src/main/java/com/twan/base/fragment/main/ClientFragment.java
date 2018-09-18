package com.twan.base.fragment.main;

import android.os.Bundle;
import android.view.View;

import com.twan.base.R;
import com.twan.base.app.BaseFragment;

import java.util.ArrayList;
import java.util.List;

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
