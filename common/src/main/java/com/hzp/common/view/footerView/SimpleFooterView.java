package com.hzp.common.view.footerView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hzp.common.R;

/**
 * @author HZP
 * @version created at 2017/3/23 2:25
 */
public class SimpleFooterView extends BaseFooterView {

    private TextView mText;

    private ProgressBar progressBar;

    public SimpleFooterView(Context context) {
        this(context, null);
    }

    public SimpleFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_footer_view, this);
        progressBar = (ProgressBar) view.findViewById(R.id.footer_view_progressbar);
        mText = (TextView) view.findViewById(R.id.footer_view_tv);
    }


    @Override
    public void onLoadingMore() {
        progressBar.setVisibility(VISIBLE);
        mText.setVisibility(GONE);
    }

    public void showText() {
        progressBar.setVisibility(GONE);
        mText.setVisibility(VISIBLE);
    }

    public void noText() {
        progressBar.setVisibility(GONE);
        mText.setVisibility(GONE);
    }

    /**************
     * 文字自行修改或根据传入的参数动态修改
     ****************/

    @Override
    public void onNoMore(CharSequence message) {
        showText();
        if (message.toString().isEmpty()) mText.setText("-- 已到底部 --");
        else mText.setText(message);
    }

    @Override
    public void onNoMore() {
        noText();
    }

    @Override
    public void onError(CharSequence message) {
        showText();
        if (message.toString().isEmpty()) mText.setText("啊哦，好像哪里不对劲!");
        else mText.setText(message);
    }

    @Override
    public void onNetChange(boolean isAvailable) {
        showText();
        mText.setText("网络连接不通畅!");
    }
}
