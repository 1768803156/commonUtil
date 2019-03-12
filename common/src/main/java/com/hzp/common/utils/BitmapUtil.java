package com.hzp.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * @author HZP
 * @version created at 2017/3/20 22:00
 */
public class BitmapUtil {
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
        int x = bitmap.getWidth();
        int y = bitmap.getHeight();
        float[] mOuter = new float[]{roundPx, roundPx, roundPx, roundPx,
                roundPx, roundPx, roundPx, roundPx};
        // 根据源文件新建一个darwable对象
        Drawable imageDrawable = new BitmapDrawable(bitmap);

        // 新建一个新的输出图片
        Bitmap output = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        // 新建一个矩形
        RectF outerRect = new RectF(0, 0, x, y);
        Path mPath = new Path();
        // 创建一个圆角矩形路径
        mPath.addRoundRect(outerRect, mOuter, Path.Direction.CW);

        // 画出一个红色的圆角矩形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        canvas.drawPath(mPath, paint);
        // 设置绘图两层交汇时的模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        // 设置绘图区域（在那个区域内绘图）
        imageDrawable.setBounds(0, 0, x, y);
        // 将用于绘制图片的图层拷贝到单独图层并压入图层栈
        canvas.saveLayer(outerRect, paint, Canvas.ALL_SAVE_FLAG);
        // 将源图片绘制到这个拷贝的图片图层上
        imageDrawable.draw(canvas);
        // 将图片图层退出栈并将图像绘制到矩形的那一层
        canvas.restore();
        return output;
    }

    public static Bitmap getCircleBitmap(Bitmap bitmap, float roundPx) {
        Drawable imageDrawable = new BitmapDrawable(bitmap);
        // 新建一个新的输出图片
        Bitmap output = Bitmap.createBitmap((int) roundPx, (int) roundPx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Path mPath = new Path();
        mPath.addCircle(roundPx / 2, roundPx / 2, roundPx / 2, Path.Direction.CW);

        // 画出一个红色的圆角矩形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        canvas.drawPath(mPath, paint);
        // 设置绘图两层交汇时的模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        // 设置绘图区域（在那个区域内绘图）
        imageDrawable.setBounds(0, 0, (int) roundPx, (int) roundPx);
        // 将用于绘制图片的图层压入图层栈
        canvas.saveLayer(0, 0, (int) roundPx, (int) roundPx, paint, Canvas.ALL_SAVE_FLAG);
        // 将源图片绘制到这个圆角矩形上
        imageDrawable.draw(canvas);
        // 将图片图层退出栈并将图像绘制到矩形的那一层
        canvas.restore();
        return output;
    }

}
