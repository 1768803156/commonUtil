package com.hzp.common.utils.imageload;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * @author HZP
 * @version created at 2017/3/27 1:18
 *          轮播图使用
 */
public class BannerImgLoader extends ImageLoader {

    private int round;

    public BannerImgLoader() {
    }

    public BannerImgLoader(int round) {
        this.round = round;
    }

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        if (round == 0)
            ImageLoaderFactory.displayImage(context, path.toString(), imageView);
        else
            ImageLoaderFactory.displayRoundImage(context, path.toString(), imageView, round);
    }
}
