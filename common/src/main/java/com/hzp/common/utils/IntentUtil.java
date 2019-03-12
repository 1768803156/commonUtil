package com.hzp.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author HZP
 * @version created at 2017/3/20 22:00
 */
public class IntentUtil {

    public static void startActivity(Context ctx, Class mclass, Bundle bundle) {
        Intent intent = new Intent(ctx, mclass);
        if (bundle != null) intent.putExtras(bundle);
        ctx.startActivity(intent);
    }

    public static void startActivity(Activity ctx, Class mclass, Bundle bundle) {
        Intent intent = new Intent(ctx, mclass);
        if (bundle != null) intent.putExtras(bundle);
        ctx.startActivity(intent);
    }

    public static void startActivityForResult(Activity ctx, Class mclass, int requestCode, Bundle bundle) {
        Intent intent = new Intent(ctx, mclass);
        if (bundle != null) intent.putExtras(bundle);
        ctx.startActivityForResult(intent, requestCode, bundle);
    }


    public static void startActivityNoAnim(Activity ctx, Class mclass) {
        startActivity(ctx, mclass);
        ctx.overridePendingTransition(0, 0);
    }

    public static void startActivityNoAnim(Activity ctx, Class mclass, int requestCode) {
        startActivityForResult(ctx, mclass, requestCode, null);
        ctx.overridePendingTransition(0, 0);
    }

    public static void startActivityNoAnim(Activity ctx, Class mclass, Bundle bundle) {
        startActivity(ctx, mclass, bundle);
        ctx.overridePendingTransition(0, 0);
    }

    public static void startActivity(Activity ctx, Class mclass) {
        startActivity(ctx, mclass, null);
    }

}
