package com.huawei.flexiblelayout.common;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Debuggable {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f27921a;

    public static void init(Context context) {
        f27921a = (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean isDebuggable() {
        return f27921a;
    }
}
