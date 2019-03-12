package com.hzp.common.net;

import android.content.Context;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.AbsCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author HZP
 * @version created at 2017/3/30 22:30
 */
public class HttpUtils {

    public static void requestPostForOkGo(Context context, Object object, String url, String cacheKey, CacheMode cacheMode, Map<String, String> params, AbsCallback callback) {

        OkGo.post(url).tag(object).cacheKey(cacheKey).cacheMode(cacheMode).params(params).execute(callback);
    }

    public static void requestPostForOkGo(Context context, Object object, String url, String cacheKey, Map<String, String> params, AbsCallback callback) {
        OkGo.post(url).tag(object).cacheKey(cacheKey).cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST).params(params).execute(callback);
    }

    public static void requestPostForOkGo(Context context, Object object, String url, Map<String, String> params, AbsCallback callback) {
        OkGo.post(url).tag(object).cacheMode(CacheMode.NO_CACHE).params(params).execute(callback);
    }
    public static void UpdateFileForOkGo(Context context, Object object, String url, Map<String, String> params, String key, ArrayList<File> files, AbsCallback callback) {
        OkGo.post(url).tag(object).params(params).addFileParams(key, files).execute(callback);
    }

}
