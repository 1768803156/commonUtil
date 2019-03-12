package com.hzp.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    protected ArrayList<T> beans;
    protected LayoutInflater mInflater;
    protected Context context;

    public MyBaseAdapter(Context context, ArrayList<T> beans) {
        this.beans = beans;
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ArrayList<T> getData() {
        return beans;
    }

    public void addData(ArrayList<T> beans) {
        if (beans == null) return;
        this.beans.addAll(beans);
        notifyDataSetChanged();
    }


    public void setData(ArrayList<T> beans) {
        if (beans == null) return;
        this.beans = beans;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (beans == null) return 0;
        return beans.size();
    }

    @Override
    public T getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getExView(position, convertView, parent);
    }

    protected abstract View getExView(int position, View convertView, ViewGroup parent);
}
