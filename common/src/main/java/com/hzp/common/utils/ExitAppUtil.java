package com.hzp.common.utils;

import android.content.Context;

public class ExitAppUtil {

    private static long exitTime = 0;

    /**
     * 判断两次返回时间间隔,小于两秒则退出程序
     */
    public static void ExitApp(final Context context) {

        // Intent intent = new Intent(Intent.ACTION_MAIN);
        // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // intent.addCategory(Intent.CATEGORY_HOME);
        // activity.startActivity(intent);
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            ToastUtils.show(context, "再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            ActivityManager.getInstance().finishAll();
            //android.os.Process.killProcess(android.os.Process.myPid());
            //System.exit(0);
        }
    }
}
