package com.facebook.soloader;

import android.os.Trace;

/* JADX INFO: Access modifiers changed from: package-private */
@DoNotOptimize
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Api18TraceUtils {
    public static void beginTraceSection(String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
