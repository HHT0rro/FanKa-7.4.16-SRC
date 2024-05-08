package com.danlan.android.cognition.collector.util;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PermissionUtil {
    private final Context context;

    public PermissionUtil(Context context) {
        this.context = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        if (androidx.core.content.ContextCompat.checkSelfPermission(r3.context, r4) != 0) goto L17;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x001e -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean isPermissionGranted(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 1
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L2b
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            r2 = 23
            if (r1 >= r2) goto L12
            android.content.Context r1 = r3.context     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            int r4 = r1.checkCallingOrSelfPermission(r4)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r4 == 0) goto L26
            goto L25
        L12:
            android.content.Context r1 = r3.context     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            int r4 = androidx.core.content.ContextCompat.checkSelfPermission(r1, r4)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r4 == 0) goto L26
            goto L25
        L1b:
            r4 = move-exception
            goto L29
        L1d:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L1b
            com.danlan.android.cognition.Logger.e(r4)     // Catch: java.lang.Throwable -> L1b
        L25:
            r0 = 0
        L26:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r3)
            return r0
        L29:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1b
            throw r4     // Catch: java.lang.Throwable -> L2b
        L2b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.util.PermissionUtil.isPermissionGranted(java.lang.String):boolean");
    }
}
