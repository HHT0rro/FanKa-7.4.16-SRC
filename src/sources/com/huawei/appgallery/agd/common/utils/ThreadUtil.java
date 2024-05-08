package com.huawei.appgallery.agd.common.utils;

import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ThreadUtil {
    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
