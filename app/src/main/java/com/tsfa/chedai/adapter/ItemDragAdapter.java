package com.tsfa.chedai.adapter;

import com.tsfa.mylibary.recyclerViewHelper.BaseItemDraggableAdapter;
import com.tsfa.mylibary.recyclerViewHelper.BaseViewHolder;
import com.tsfa.chedai.R;
import com.tsfa.chedai.entity.Room;

import java.util.List;

/**
 * Created by luoxw on 2016/6/20.
 */
public class ItemDragAdapter extends BaseItemDraggableAdapter<Room, BaseViewHolder> {
    public ItemDragAdapter(List data) {
        super(R.layout.item_draggable_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Room item) {
        helper.setText(R.id.tv, item.getRoomname());
        helper.setText(R.id.desc, "(空闲) 0/"+item.getBedcnt());
    }
}
