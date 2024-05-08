package com.huawei.appgallery.agd.common.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.appgallery.agd.common.CommonLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class StringUtils {
    public static final String NO_PRINT_CODE = "*";
    public static final String SENSITIVE_CODE = "****";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Encoding {
        public static final String UTF_8 = "UTF-8";
    }

    public static String encode2utf8(String str) {
        CommonLog commonLog;
        StringBuilder sb2;
        String message;
        if (str == null) {
            return null;
        }
        if (SENSITIVE_CODE.equals(str) || NO_PRINT_CODE.equals(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, "%20").replace(NO_PRINT_CODE, "%2A").replace("~", "%7E");
        } catch (UnsupportedEncodingException e2) {
            commonLog = CommonLog.LOG;
            sb2 = new StringBuilder();
            sb2.append("encode2utf8 error");
            message = e2.getMessage();
            sb2.append(message);
            commonLog.e("StringUtils", sb2.toString());
            return null;
        } catch (Exception e10) {
            commonLog = CommonLog.LOG;
            sb2 = new StringBuilder();
            sb2.append("encode2utf8 error");
            message = e10.getMessage();
            sb2.append(message);
            commonLog.e("StringUtils", sb2.toString());
            return null;
        }
    }

    public static String encodeByURLEncoder(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            CommonLog.LOG.e("StringUtils", "encodingURL error", e2);
            return str;
        }
    }

    public static boolean equals(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        return str != null && str.equals(str2);
    }

    public static String getValueOfUrl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return SafeUri.getQueryParameter(Uri.parse(str), str2);
        } catch (Exception e2) {
            CommonLog.LOG.e("StringUtils", "getValueOfUrl exception:" + e2.getMessage());
            return null;
        }
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isJSONString(String str) {
        return str != null && str.trim().startsWith("{") && str.trim().endsWith(i.f4738d);
    }

    public static boolean isNull(String str) {
        return str == null || str.trim().length() == 0;
    }
}
