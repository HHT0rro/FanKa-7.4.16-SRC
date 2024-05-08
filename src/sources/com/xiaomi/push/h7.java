package com.xiaomi.push;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h7 {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
