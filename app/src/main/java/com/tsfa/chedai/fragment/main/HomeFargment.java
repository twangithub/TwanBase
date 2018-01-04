package com.tsfa.chedai.fragment.main;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gongwen.marqueen.MarqueeFactory;
import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tsfa.chedai.adapter.BaseRecyclerAdapter;
import com.tsfa.chedai.adapter.SmartViewHolder;
import com.tsfa.chedai.util.DynamicTimeFormat;
import com.tsfa.mylibary.refresh.SuperEasyRefreshLayout;
import com.tsfa.mylibary.router.Router;
import com.tsfa.chedai.R;
import com.tsfa.chedai.app.BaseFragment;
import com.tsfa.chedai.ui.SecondeActivity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;

import static android.R.layout.simple_list_item_2;
import static android.support.v7.widget.DividerItemDecoration.VERTICAL;


/**
 * Created by twan on 2017/10/26.
 */
public class HomeFargment extends BaseFragment implements AdapterView.OnItemClickListener{
    @BindView(R.id.simpleMarqueeView)
    SimpleMarqueeView marqueeView;

    @BindView(R.id.refreshLayout)
    RefreshLayout mRefreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    SimpleMF<String> marqueeFactory;
    private BaseRecyclerAdapter<Item> mAdpater;
    private ClassicsHeader mClassicsHeader;
    private Drawable mDrawableProgress;
    private static boolean isFirstEnter = true;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    private enum Item {
        尺寸拉伸("下拉的时候Header的高度跟随变大"),
        位置平移("下拉的时候Header的位置向下偏移"),
        背后固定("下拉的时候Header固定在背后"),
        显示时间("开启显示上次更新功能"),
        隐藏时间("关闭显示上次更新功能"),
        默认主题("更改为默认主题颜色"),
        橙色主题("更改为橙色主题颜色"),
        红色主题("更改为红色主题颜色"),
        绿色主题("更改为绿色主题颜色"),
        蓝色主题("更改为蓝色主题颜色"),
        加载更多("上啦加载更多"),
        ;
        public String name;
        Item(String name) {
            this.name = name;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        //Router.newIntent(mActivity).to(SecondeActivity.class).launch();


        marqueeFactory.setOnItemClickListener(new MarqueeFactory.OnItemClickListener<TextView, String>() {
            @Override
            public void onItemClickListener(MarqueeFactory.ViewHolder<TextView, String> holder) {
                Toast.makeText(mContext, holder.data, Toast.LENGTH_SHORT).show();
            }
        });

        int deta = new Random().nextInt(7 * 24 * 60 * 60 * 1000);
        mClassicsHeader = (ClassicsHeader)mRefreshLayout.getRefreshHeader();
        mClassicsHeader.setLastUpdateTime(new Date(System.currentTimeMillis()-deta));
        mClassicsHeader.setTimeFormat(new SimpleDateFormat("更新于 MM-dd HH:mm", Locale.CHINA));
        mClassicsHeader.setTimeFormat(new DynamicTimeFormat("更新于 %s"));

        mDrawableProgress = mClassicsHeader.getProgressView().getDrawable();
        if (mDrawableProgress instanceof LayerDrawable) {
            mDrawableProgress = ((LayerDrawable) mDrawableProgress).getDrawable(0);
        }

        View view1 = findViewById(R.id.recycler_view);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view1;
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            recyclerView.addItemDecoration(new DividerItemDecoration(mContext, VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdpater = new BaseRecyclerAdapter<Item>(Arrays.asList(Item.values()), simple_list_item_2,HomeFargment.this) {
                @Override
                protected void onBindViewHolder(SmartViewHolder holder, Item model, int position) {
                    holder.text(android.R.id.text1, model.name());
                    holder.text(android.R.id.text2, model.name);
                    holder.textColorId(android.R.id.text2, R.color.colorTextAssistant);
                }
            });
            mRecyclerView = recyclerView;
        }

        if (isFirstEnter) {
            isFirstEnter = false;
            //触发自动刷新
            mRefreshLayout.autoRefresh();
        }
    }

    @Override
    protected void initData(Bundle arguments) {
        marqueeView.setVisibility(View.VISIBLE);
        final List<String> datas = Arrays.asList("《赋得古原草送别》", "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。", "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");
        marqueeFactory = new SimpleMF(getActivity());
        marqueeFactory.setData(datas);
        marqueeView.setMarqueeFactory(marqueeFactory);
        marqueeView.startFlipping();

    }



}
