package com.bun.miitmdid.utils;

import android.content.Context;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LoadJsonUtil {
    public static String LoadJsonFromAsset(Context context, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = str;
        objArr[3] = 134;
        objArr[4] = 1598952044356L;
        return (String) Utils.rL(objArr);
    }
}
