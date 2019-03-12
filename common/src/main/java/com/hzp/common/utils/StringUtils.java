package com.hzp.common.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

import com.hzp.common.utils.aes.MD5Util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * @创建者 CSDN_LQR
 * @描述 字符串工具类
 */
public class StringUtils {

    /**
     * 判断字符串或集合是否为空
     *
     * @param o
     * @return
     */
    public static boolean isEmpty(Object o) {
        if (o instanceof List) return ((List) o).size() == 0;
        return o == null || o.toString().equals("");
    }

    public static float string2float(String s) {
        if (TextUtils.isEmpty(s)) return 0;
        float r = 0f;
        try {
            r = Float.parseFloat(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;

    }

    public static long string2long(String s) {
        if (TextUtils.isEmpty(s)) return 0;
        long r = 0L;
        try {
            r = Long.parseLong(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;

    }

    public static double string2double(String s) {
        double r = 0L;
        try {
            r = Double.parseDouble(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;

    }

    /**
     * 隐藏手机号中间4位
     */
    public static String hidePhone(String phone) {
        String pp = "";
        try {
            pp = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp;

    }

    public static String float2string(float f) {
        return String.format(Locale.CHINA, "%.2f", f);
    }

    /**
     * 函数传入汉字的Unicode编码字符串，返回相应的汉字字符串
     *
     * @return
     */
    public static String decodeUnicode(final String utfString) {
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while ((i = utfString.indexOf("\\u", pos)) != -1) {
            sb.append(utfString.substring(pos, i));
            if (i + 5 < utfString.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(utfString.substring(i + 2, i + 6), 16));
            }
        }
        sb.append(utfString.substring(pos, utfString.length()));

        return sb.toString();
    }

    public static String getTextColors(String content, String colorstr) {
        //<font color=\"#ff0000\">红色</font>
        String ss = String.format("<font color=\"%1$s\">%2$s</font>", colorstr, content);
        return ss;

    }

    public static String getCodeSign(String code, String moble) {
        String key = MD5Util.GetMD5Code(code + moble + "CC1528096983", true);
        return key;
    }

    /**
     * 字符串转整形
     *
     * @param data
     * @return
     */
    public static int string2Int(String data) {
        if (TextUtils.isEmpty(data)) return 0;
        int num = 0;
        try {
            num = Integer.parseInt(data);
        } catch (Exception e) {
        }
        return num;
    }

    /**
     * 判断是不是手机号码格式
     */
    public static boolean isPhone(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("1") && str.length() == 11) return true;
        return false;
    }

    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    public static String dintanceFormat(String distance) {
        return String.format(Locale.CHINA, "%.1fkm", string2float(distance) / 1000);

    }

    //timetype："100" 早上 010 中午 001 晚上
    // 100 转成 8,13形式
    public static String timeTypeFormat(String timetype) {
        String timePeriod = "8,22";
        if ("100".equals(timetype)) {
            timePeriod = "8,13";
        } else if ("010".equals(timetype)) {
            timePeriod = "11,19";
        } else if ("110".equals(timetype)) {
            timePeriod = "8,19";
        } else if ("001".equals(timetype)) {
            timePeriod = "17,22";
        } else if ("101".equals(timetype)) {
            timePeriod = "8,13,17,22";
        } else if ("011".equals(timetype)) {
            timePeriod = "11,22";
        } else if ("111".equals(timetype)) {
            timePeriod = "8,22";
        }
        return timePeriod;
    }


    //timetype："100" 早上 010 中午 001 晚上
    // 100 转成 8:00-13:00形式
    public static String timeTypeFormat2(String timetype) {
        String timePeriod = "8:00-22:00";
        if ("100".equals(timetype)) {
            timePeriod = "8:00-13:00";
        } else if ("010".equals(timetype)) {
            timePeriod = "11:00-19:00";
        } else if ("110".equals(timetype)) {
            timePeriod = "8:00-19:00";
        } else if ("001".equals(timetype)) {
            timePeriod = "17:00-22:00";
        } else if ("101".equals(timetype)) {
            timePeriod = "8:00-13:00 17:00-22:00";
        } else if ("011".equals(timetype)) {
            timePeriod = "11:00-22:00";
        } else if ("111".equals(timetype)) {
            timePeriod = "8:00-22:00";
        }
        return timePeriod;
    }

    //timetype："100" 上午 010 中午 001 晚上
    // 100 转成 上午
    public static String timeTypeFormat3(String timetype) {
        String timePeriod = "全天时段";
        if ("100".equals(timetype)) {
            timePeriod = "上午";
        } else if ("010".equals(timetype)) {
            timePeriod = "下午";
        } else if ("110".equals(timetype)) {
            timePeriod = "上午，上午";
        } else if ("001".equals(timetype)) {
            timePeriod = "晚上";
        } else if ("101".equals(timetype)) {
            timePeriod = "上午，晚上";
        } else if ("011".equals(timetype)) {
            timePeriod = "下午，晚上";
        } else if ("111".equals(timetype)) {
            timePeriod = "全天时段";
        }
        return timePeriod;
    }

    public static void StringCopy(Context context, String str) {
        // 全名为android.text.ClipboardManager从API 11开始就废弃了。
        // 取而代之的是它的子类：android.content.ClipboardManager (since API Level 11)。
        //1.获取剪贴板服务
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);

        // 2.把数据放在ClipData对象中。
        ClipData clip = ClipData.newPlainText("link", str);
        // 3.把clip对象放在剪贴板中：
        cmb.setPrimaryClip(clip);
        // 获取内容
        // cmb.getText().toString().trim();
        ToastUtils.show(context, "复制成功");
    }

    /**
     * double 除法
     *
     * @param d1
     * @param d2
     * @param scale 四舍五入 小数点位数
     * @return
     */
    public static double chuFa(double d1, double d2, int scale) {
        //  当然在此之前，你要判断分母是否为0，
        //  为0你可以根据实际需求做相应的处理
        try {
            if (d2 == 0) {
                throw new Exception("分母不能为0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.divide
                (bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
