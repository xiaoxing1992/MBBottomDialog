package com.rzw.dialoglibrary;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rzw.dialoglibrary.model.BottomItemModel;

import java.util.List;

/**
 * @Author: RenZhengWei
 * @CreateDate: 2020/3/2 16:17
 * @Description: java类作用描述
 */
public class MBItemAdapter extends BaseQuickAdapter<BottomItemModel, BaseViewHolder> {

    public MBItemAdapter(int layoutResId, @Nullable List<BottomItemModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BottomItemModel model) {
        if (model.type == 96) {
            helper.setTextColor(R.id.tv_name, Color.parseColor(model.color));
        } else if (model.type == 97) {
            helper.setTextColor(R.id.tv_name, Color.parseColor(model.color));
        } else if (model.type == 98) {
            helper.setTextColor(R.id.tv_name, Color.parseColor(model.color));
        } else if (model.type == 99) {
            helper.setTextColor(R.id.tv_name, Color.parseColor(model.color));
        } else {
            helper.setTextColor(R.id.tv_name, Color.parseColor("#282828"));
        }
        helper.setText(R.id.tv_name, model.name);

    }
}