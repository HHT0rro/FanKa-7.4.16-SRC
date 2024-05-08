package com.google.android.exoplayer2.util;

import android.os.Trace;
import androidx.annotation.RequiresApi;

/* compiled from: TraceUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g0 {
    public static void a(String str) {
        if (j0.f22990a >= 18) {
            b(str);
        }
    }

    @RequiresApi(18)
    public static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (j0.f22990a >= 18) {
            d();
        }
    }

    @RequiresApi(18)
    public static void d() {
        Trace.endSection();
    }
}
