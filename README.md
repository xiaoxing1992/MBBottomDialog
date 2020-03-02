# 自定义底部弹窗菜单

可自定义数据
可设置是否拖拽关闭
可以设置顶部title是否显示和可自定义标题内容

----------
![Alt text](./1583145681719.gif)


```
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
```

```
  OpManager.shareNews(MainActivity.this, new ShareListener() {
                    @Override
                    public void onOperations() {
                        super.onOperations();
                        Toast.makeText(MainActivity.this, "onOperations", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDelete() {
                        super.onDelete();
                        Toast.makeText(MainActivity.this, "onDelete", Toast.LENGTH_SHORT).show();
                    }
                });
```
