package com.huawei.quickcard.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alipay.sdk.util.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class StrUtils {
    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    @NonNull
    public static String int2String(int i10) {
        if (i10 < 0) {
            return "_" + Math.abs(i10);
        }
        return String.valueOf(i10);
    }

    public static boolean isInvalidParam(String str) {
        return TextUtils.isEmpty(str) || "null".equals(str) || "undefined".equals(str);
    }

    @NonNull
    public static String null2Empty(String str) {
        return str == null ? "" : str;
    }

    public static String objDesc(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }

    public static String strip(String str) {
        if (str == null) {
            return null;
        }
        return (str.startsWith("${") && str.endsWith(i.f4738d)) ? str.substring(2, str.length() - 1) : str;
    }
}
