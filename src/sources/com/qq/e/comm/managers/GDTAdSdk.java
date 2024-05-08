package com.qq.e.comm.managers;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class GDTAdSdk {
    public static IGDTAdManager getGDTAdManger() {
        return b.b();
    }

    public static void init(Context context, String str) {
        b.b().a(context, str);
    }
}
