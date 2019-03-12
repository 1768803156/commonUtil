package com.hzp.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * ToastUtils
 */
public class ToastUtils {
    private static Toast TOAST = null;

    public static void show(Context context, CharSequence text, int duration) {
        if (TOAST == null) {
            TOAST = Toast.makeText(context, text, duration);
        } else {
            TOAST.setText(text);
            TOAST.setDuration(duration);
        }
        TOAST.show();
    }

    public static void show(Context context, CharSequence text) {
        show(context, text, Toast.LENGTH_SHORT);
    }

    public static void releaseToast() {
        TOAST = null;
    }

}
