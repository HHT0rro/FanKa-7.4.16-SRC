package com.tencent.liteav.base;

import android.os.StrictMode;
import java.io.Closeable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final StrictMode.ThreadPolicy f42748a;

    /* renamed from: b, reason: collision with root package name */
    private final StrictMode.VmPolicy f42749b;

    private b(StrictMode.ThreadPolicy threadPolicy) {
        this.f42748a = threadPolicy;
        this.f42749b = null;
    }

    public static b a() {
        return new b(StrictMode.allowThreadDiskWrites(), (byte) 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        StrictMode.ThreadPolicy threadPolicy = this.f42748a;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        StrictMode.VmPolicy vmPolicy = this.f42749b;
        if (vmPolicy != null) {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    private b(StrictMode.ThreadPolicy threadPolicy, byte b4) {
        this(threadPolicy);
    }
}
