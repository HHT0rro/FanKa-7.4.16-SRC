package com.sina.weibo.sdk.net;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpManager {
    static {
        System.loadLibrary("weibosdkcore");
    }

    public static String a(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(str3);
        }
        return calcOauthSignNative(context, sb2.toString(), str4);
    }

    private static native String calcOauthSignNative(Context context, String str, String str2);
}
