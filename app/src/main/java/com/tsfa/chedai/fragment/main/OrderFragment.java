package com.tsfa.chedai.fragment.main;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tsfa.chedai.R;
import com.tsfa.chedai.adapter.OrderViewPager;
import com.tsfa.chedai.app.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by twan on 2017/10/26.
 */

public class OrderFragment extends BaseFragment implements View.OnClickListener{

    @BindView(R.id.viewpager) ViewPager mViewPager;
    @BindView(R.id.btn_left) Button btn_left;
    @BindView(R.id.btn_right) Button btn_right;

    List<View> viewContainter;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        btn_left.setText("活期理财");
        btn_right.setText("定期理财");
        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
        setBtnStatus(true);

        LayoutInflater lf = getLayoutInflater().from(mContext);
        View view1 = lf.inflate(R.layout.fragment_order_left, null);
        View view2 = lf.inflate(R.layout.fragment_order_right, null);
        viewContainter  = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewContainter .add(view1);
        viewContainter .add(view2);

        mViewPager.setAdapter(new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)   {
                container.removeView(viewContainter.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewContainter.get(position), 0);
                return viewContainter.get(position);
            }

            @Override
            public int getCount() {
                return  viewContainter.size();
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0==arg1;
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                setBtnStatus(position == 0);
            }
        });
    }

    private void setBtnStatus(boolean isLeft) {
        btn_left.setSelected(isLeft);
        btn_right.setSelected(!isLeft);
    }

    @Override
    protected void initData(Bundle arguments) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                setBtnStatus(true);
                mViewPager.setCurrentItem(0,true);
                break;
            case R.id.btn_right:
                setBtnStatus(false);
                mViewPager.setCurrentItem(1,true);
                break;
        }
    }
}
