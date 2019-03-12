package com.hzp.common.utils.imageload;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.request.RequestOptions;
import com.hzp.common.R;

import java.security.MessageDigest;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * @author HZP
 * @version created at 2017/3/21 23:15
 * https://blog.csdn.net/shangmingchao/article/details/51125554
 */
public class ImageLoaderFactory {

    /*load SD卡资源：load("file://"+Environment.getExternalStorageDirectory().getPath()+"/test.jpg")
    load assets资源：load("file:///android_asset/f003.gif")
    load raw资源：load("android.resource://com.frank.glide/raw/raw_1")或load("android.resource://com.frank.glide/raw/"+R.raw.raw_1)
    load drawable资源：load("android.resource://com.frank.glide/drawable/news")或load("android.resource://com.frank.glide/drawable/"+R.drawable.news)
    load ContentProvider资源：load("content://media/external/images/media/139469")
    load http资源：load("http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg")
    load https资源：load("https://img.alicdn.com/tps/TB1uyhoMpXXXXcLXVXXXXXXXXXX-476-538.jpg_240x5000q50.jpg_.webp")*/

    //load(Uri uri)，load(File file)，load(Integer resourceId)，load(URL url)，load(byte[] model)，load(T model)，loadFromMediaStore(Uri uri)


    public static void displayImage(Context context, Object uri, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                //.centerCrop()
                .placeholder(R.drawable.def_rectimg)//预加载图片
                .error(R.drawable.def_rectimg)//加载失败显示图片
                .priority(Priority.HIGH)//优先级
                .diskCacheStrategy(DiskCacheStrategy.ALL);//缓存策略
        Glide.with(context).load(uri).apply(options).into(imageView);

    }

    public static void displayImage(Context context, Object uri, ImageView imageView, int placeholder) {
        RequestOptions options = new RequestOptions()
                //.centerCrop()
                .placeholder(R.drawable.def_rectimg)//预加载图片
                .error(R.drawable.def_rectimg)//加载失败显示图片
                .placeholder(placeholder)//预加载图片
                .error(placeholder)//加载失败显示图片
                .diskCacheStrategy(DiskCacheStrategy.ALL);//缓存策略
        Glide.with(context).load(uri).apply(options).into(imageView);
    }

    public static void displayCircleImage(Context context, Object uri, CircleImageView circleImageView) {
        RequestOptions options = new RequestOptions()
                //.centerCrop()
                .placeholder(R.drawable.def_circleimg)//预加载图片
                .error(R.drawable.def_circleimg)//加载失败显示图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存策略
                .transform(new GlideCircleTransform());//转化为圆形
        Glide.with(context).load(uri).apply(options).into(circleImageView);
    }

    public static void displayRoundCornersImage(Context context, Object uri, int radius, int placeholder, RoundedCornersTransformation.CornerType cornerType, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int radiuspx = (int) (Resources.getSystem().getDisplayMetrics().density * radius);
        RequestOptions options = new RequestOptions()
                //.centerCrop()
                .placeholder(placeholder)//预加载图片
                .error(placeholder)//加载失败显示图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存策略
                .transform(new RoundedCornersTransformation(radiuspx, 0, cornerType));
        Glide.with(context).load(uri).apply(options).into(imageView);
    }

    public static void displayCircleImage(Context context, Object uri, ImageView imageView) {
        displayCircleImage(context, uri, imageView, R.drawable.def_circleimg);
    }

    public static void displayCircleImage(Context context, Object uri, ImageView imageView, int placeholder) {

        RequestOptions options = new RequestOptions()
                //.centerCrop()
                .placeholder(placeholder)//预加载图片
                .error(placeholder)//加载失败显示图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存策略
                .transform(new GlideCircleTransform());//转化为圆形
        Glide.with(context).load(uri).apply(options).into(imageView);
    }

    public static void displayCircleLocalImage(Context context, Object uri, ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存策略
                .transform(new GlideCircleTransform());//转化为圆形
        Glide.with(context).load(uri).apply(options).into(imageView);
    }

    public static void displayRoundImage(Context context, Object uri, ImageView imageView) {
        displayRoundImage(context, uri, imageView, 4);
    }

    public static void displayRoundImageWithPlace(Context context, Object uri, ImageView imageView, int resID) {
        displayRoundImage(context, uri, imageView, 4, resID);
    }

    public static void displayRoundImage(Context context, Object uri, ImageView imageView, int dp) {
        displayRoundImage(context, uri, imageView, dp, R.drawable.def_roundimg);
    }

    public static void displayRoundImage(Context context, Object uri, final ImageView imageView, int dp, int resID) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RequestOptions options = new RequestOptions()
                //.placeholder(R.mipmap.default_roundimg2)//预加载图片R.mipmap.default_roundimg2
                //.error(R.mipmap.default_roundimg2)//加载失败显示图片R.drawable.def_roundimg
                .placeholder(resID)//预加载图片
                .error(resID)//加载失败显示图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存策略
                .dontAnimate()
                .transform(new GlideRoundTransform(dp));//转化为圆角
        Glide.with(context).load(uri).apply(options).into(imageView);
    }

    public static class GlideCircleTransform extends BitmapTransformation {

        public GlideCircleTransform() {
            super();
        }

        @Override
        protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        @Override
        public void updateDiskCacheKey(MessageDigest messageDigest) {

        }

        private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }
    }

    public static class GlideRoundTransform extends BitmapTransformation {

        private float radius = 0f;

        public GlideRoundTransform() {
            this(4);
        }

        public GlideRoundTransform(int dp) {
            super();
            this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
        }


        @Override
        protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
            Bitmap bitmap = TransformationUtils.centerCrop(pool, toTransform, outWidth, outHeight);
            return roundCrop(pool, bitmap);
        }

        public String getId() {
            return getClass().getName() + Math.round(radius);
        }

        @Override
        public void updateDiskCacheKey(MessageDigest messageDigest) {

        }


        private Bitmap roundCrop(BitmapPool pool, Bitmap source) {
            if (source == null) {
                return null;
            }
            Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
            canvas.drawRoundRect(rectF, radius, radius, paint);

            return result;
        }
    }

}
