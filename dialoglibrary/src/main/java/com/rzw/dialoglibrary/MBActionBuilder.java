package com.rzw.dialoglibrary;

import android.app.Activity;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rzw.dialoglibrary.model.BottomItemModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: RenZhengWei
 * @CreateDate: 2020/3/2 15:35
 * @Description: java类作用描述
 */
public class MBActionBuilder {

    private List<BottomItemModel> mItemModels = new ArrayList<>();
    private ItemClickListener itemClickListener;
    private int visibility = View.VISIBLE;
    private String mtitleNameValue = "标题";
    private BottomSheetDialog bottomSheetDialog;
    private RecyclerView.ItemDecoration itemDecoration;
    private boolean isScrollBottomSheetBehavior = true;

    //设置数据
    public MBActionBuilder setDisplayList(BottomItemModel... mustomStr) {
        mItemModels.addAll(Arrays.asList(mustomStr));
        return this;
    }

    /**
     * 顶部标题是否可见
     *
     * @param visible
     * @return
     */
    public MBActionBuilder setTitleVisible(int visible) {
        this.visibility = visible;
        return this;
    }

    /**
     * 设置顶部标题文案
     *
     * @param value
     * @return
     */
    public MBActionBuilder setTitleValue(String value) {
        this.mtitleNameValue = value;
        return this;
    }


    /**
     * 是否可以拖拽关闭
     *
     * @param flag
     * @return
     */
    public MBActionBuilder setIsDragScrollView(boolean flag) {
        this.isScrollBottomSheetBehavior = flag;
        return this;
    }

    /**
     * 设置RecyclerView的分割线
     *
     * @param itemDecoration
     * @return
     */
    public MBActionBuilder setCustomRecyclerViewItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
        return this;
    }

    public MBActionBuilder setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        return this;
    }

    public void show(Activity activity) {
        if (bottomSheetDialog == null) {
            bottomSheetDialog = new BottomSheetDialog(activity);
            bottomSheetDialog.setContentView(R.layout.mb_dialog_bottom_sheet);
            View root = bottomSheetDialog.getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet);
            root.setBackgroundColor(activity.getResources().getColor(android.R.color.transparent));
            BottomSheetBehavior behavior = BottomSheetBehavior.from(root);
            if (!isScrollBottomSheetBehavior) {
                behavior.setHideable(false);
            }


            initBottomDialog(activity);
        }
        bottomSheetDialog.show();
    }

    private void initBottomDialog(Activity activity) {

        TextView textviewTitle = bottomSheetDialog.findViewById(R.id.textview);
        textviewTitle.setVisibility(visibility);
        textviewTitle.setText(mtitleNameValue);
        final MBItemAdapter mbItemAdapter = new MBItemAdapter(R.layout.item_mb_view, mItemModels);

        View view_one = bottomSheetDialog.findViewById(R.id.view_one);
        if (mItemModels.size() == 0) {
            view_one.setVisibility(View.GONE);
        }

        TextView tv_cancel = bottomSheetDialog.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomSheetDialog != null && bottomSheetDialog.isShowing()) {
                    bottomSheetDialog.dismiss();
                }
            }
        });

        RecyclerView recyclerview_platform = bottomSheetDialog.findViewById(R.id.recyclerview_platform);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview_platform.setLayoutManager(linearLayoutManager);
        recyclerview_platform.setHasFixedSize(true);

        if (itemDecoration != null) {
            recyclerview_platform.addItemDecoration(itemDecoration);
        }


        recyclerview_platform.setAdapter(mbItemAdapter);

        mbItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BottomItemModel itemModel = mbItemAdapter.getData().get(position);
                if (itemClickListener != null && itemModel != null) {
                    itemClickListener.onClick(itemModel);
                }
                if (bottomSheetDialog != null && bottomSheetDialog.isShowing()) {
                    bottomSheetDialog.dismiss();
                }
            }
        });
    }
}
