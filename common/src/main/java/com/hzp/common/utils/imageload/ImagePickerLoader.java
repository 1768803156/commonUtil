package com.hzp.common.utils.imageload;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.hzp.common.R;
import com.lzy.imagepicker.loader.ImageLoader;

import java.io.File;


/**
 * @author HZP
 * @version created at 2017/3/27 22:40
 *          compile 'com.lzy.widget:imagepicker:0.5.0'
 *          https://github.com/jeasonlzy/ImagePicker
 *          图片选择器
 */
public class ImagePickerLoader implements ImageLoader {

    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_default_image)
                .error(R.drawable.ic_default_image)
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.RESOURCE);//缓存策略

        Glide.with(activity).load(Uri.fromFile(new File(path))).thumbnail(0.4f).apply(options).into(imageView);

    }


    @Override
    public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL);//缓存策略

        Glide.with(activity).load(Uri.fromFile(new File(path))).apply(options).into(imageView);
    }

    @Override
    public void clearMemoryCache() {
    }
}