package com.bun.miitmdid.provider.nubia;

import android.content.Context;
import android.net.Uri;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NubiaIdentityImpl {
    public static final String TAG = "NubiaLog";
    public static Uri uri = Uri.parse("content://cn.nubia.identity/identity");

    public static String getAAID(Context context, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = str;
        objArr[3] = 75;
        objArr[4] = 1598952044297L;
        return (String) Utils.rL(objArr);
    }

    public static String getOAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 76;
        objArr[3] = 1598952044298L;
        return (String) Utils.rL(objArr);
    }

    public static String getVAID(Context context, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = str;
        objArr[3] = 77;
        objArr[4] = 1598952044299L;
        return (String) Utils.rL(objArr);
    }

    public static boolean isSupported(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 78;
        objArr[3] = 1598952044300L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }
}
