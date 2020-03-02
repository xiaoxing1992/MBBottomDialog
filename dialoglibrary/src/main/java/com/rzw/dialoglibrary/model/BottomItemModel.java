package com.rzw.dialoglibrary.model;

/**
 * @Author: RenZhengWei
 * @CreateDate: 2020/3/2 16:27
 * @Description: java类作用描述
 */
public class BottomItemModel {
    public String name;
    public String color;
    public int type;

    public BottomItemModel(String name, String color, int type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }

    @Override
    public String toString() {
        return "BottomItemModel{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", type=" + type +
                '}';
    }
}
