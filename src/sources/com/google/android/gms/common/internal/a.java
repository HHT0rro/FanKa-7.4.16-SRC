package com.google.android.gms.common.internal;

import android.os.Looper;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {
    public static void a(@RecentlyNonNull String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        String valueOf = String.valueOf(Thread.currentThread());
        String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
        sb2.append("checkMainThread: current thread ");
        sb2.append(valueOf);
        sb2.append(" IS NOT the main thread ");
        sb2.append(valueOf2);
        sb2.append("!");
        throw new IllegalStateException(str);
    }

    public static void b(@RecentlyNonNull String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            return;
        }
        String valueOf = String.valueOf(Thread.currentThread());
        String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 56 + valueOf2.length());
        sb2.append("checkNotMainThread: current thread ");
        sb2.append(valueOf);
        sb2.append(" IS the main thread ");
        sb2.append(valueOf2);
        sb2.append("!");
        throw new IllegalStateException(str);
    }

    public static void c(@RecentlyNonNull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }
}
