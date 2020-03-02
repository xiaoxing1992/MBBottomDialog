package com.rzw;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rzw.dialoglibrary.ItemClickListener;
import com.rzw.dialoglibrary.MBActionBuilder;
import com.rzw.dialoglibrary.model.BottomItemModel;

/**
 * @Author: RenZhengWei
 * @CreateDate: 2020/3/2 16:48
 * @Description: java类作用描述
 */
public class OpManager {
    /**
     * 分享动态
     */
    public static void shareNews(Activity activity, final ShareListener shareListener) {
        new MBActionBuilder()
                .setTitleVisible(View.GONE)
                .setIsDragScrollView(false)
                .setTitleValue("选择")
                .setCustomRecyclerViewItemDecoration(new SpacesItemDecoration(1))
                .setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(BottomItemModel model) {
                        sharePlatform(model, shareListener);
                    }
                })
                .setDisplayList(new BottomItemModel("精选管理", null, 1)
                        , new BottomItemModel("删除", "#e25555", 99))
                .show(activity);
    }

    /**
     * 操作回调
     */
    private static void sharePlatform(BottomItemModel sharePlatformModel, ShareListener shareListener) {
        if (sharePlatformModel == null || shareListener == null) {
            return;
        }
        switch (sharePlatformModel.type) {
            case 1:
                shareListener.onOperations();
                break;
            case 99:
                shareListener.onDelete();
                break;
        }
    }

    private static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private Paint dividerPaint;
        private int space;

        private SpacesItemDecoration(int space) {
            dividerPaint = new Paint();
            dividerPaint.setColor(Color.parseColor("#f7f7f7"));
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int childPosition = parent.getChildAdapterPosition(view);
            int itemCount = parent.getAdapter().getItemCount();
            if (childPosition == itemCount - 1) {
            } else {
                outRect.bottom = space;
            }
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int childCount = parent.getChildCount();
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            for (int i = 0; i < childCount - 1; i++) {
                View view = parent.getChildAt(i);
                float top = view.getBottom();
                float bottom = view.getBottom() + space;
                c.drawRect(left, top, right, bottom, dividerPaint);
            }
        }
    }
}
