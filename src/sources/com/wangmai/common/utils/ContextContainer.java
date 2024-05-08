package com.wangmai.common.utils;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ContextContainer {
    public static Context context;

    public static Context getApplicationContext() {
        return context;
    }

    public static void init(Context context2) {
        context = context2;
    }
}
