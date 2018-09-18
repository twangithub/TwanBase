package com.twan.base.fragment.main;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.twan.base.R;
import com.twan.base.adapter.BaseRecyclerAdapter;
import com.twan.base.adapter.SmartViewHolder;
import com.twan.base.app.BaseFragment;
import com.twan.base.entity.Good;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;


/**
 * Created by twan on 2017/10/26.
 */
public class HomeFargment extends BaseFragment implements AdapterView.OnItemClickListener {

    @BindView(R.id.refreshLayout)
    RefreshLayout mRefreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private BaseRecyclerAdapter<Good> mAdpater;
    List<Good> mddddd = new ArrayList<>();

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        //Router.newIntent(mActivity).to(SecondeActivity.class).launch();
        mRefreshLayout.setRefreshHeader(new ClassicsHeader(mContext));
        mRefreshLayout.setRefreshFooter(new ClassicsFooter(mContext));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdpater = new BaseRecyclerAdapter<Good>(mddddd, R.layout.item_sample) {
            @Override
            protected void onBindViewHolder(SmartViewHolder holder, Good model, final int position) {
                holder.text(R.id.name, model.getGoodname());
            }
        });
    }

    @Override
    protected void initData(Bundle arguments) {

    }


}
