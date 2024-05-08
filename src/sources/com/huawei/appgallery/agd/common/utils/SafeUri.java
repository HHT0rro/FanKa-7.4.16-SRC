package com.huawei.appgallery.agd.common.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.CommonLog;
import wa.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SafeUri {
    public static String getQueryParameter(Uri uri, String str) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                String a10 = c.a(uri, str);
                return TextUtils.isEmpty(a10) ? "" : a10;
            } catch (Exception e2) {
                CommonLog.LOG.e("SafeUri", "getQueryParameter: " + e2.getMessage());
            }
        }
        return "";
    }
}
