package com.huawei.hms.ads.uiengineloader;

import java.io.Closeable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ae {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29427a = "StreamUtil";

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
                aa.c(f29427a, "close exception");
            }
        }
    }
}
