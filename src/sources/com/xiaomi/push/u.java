package com.xiaomi.push;

import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class u {
    public static void a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
