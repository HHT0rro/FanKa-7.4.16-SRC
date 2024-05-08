package com.vivo.push.util;

import android.os.Looper;

/* compiled from: DebugUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k {
    public static void a(String str) {
        if (u.b() && Looper.myLooper() == Looper.getMainLooper()) {
            StringBuilder sb2 = new StringBuilder("Operation: ");
            sb2.append(str);
            sb2.append(" in main thread!");
            new Throwable();
        }
    }
}
