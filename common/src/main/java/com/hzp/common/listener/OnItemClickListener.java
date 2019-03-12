package com.hzp.common.listener;

/**
 * @author HZP
 * @version created at 2018-07-26 17:02
 */
public interface OnItemClickListener<T> {
    void onItemClick(int clickType, int currentP, T t);
}
