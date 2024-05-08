package com.tencent.turingface.sdk.mfa;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class usfPi implements Xjpd8 {
    @Override // com.tencent.turingface.sdk.mfa.Xjpd8
    public final void a(Context context) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0022, code lost:
    
        if (r2 >= 24) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
    
        r5.release();
     */
    @Override // com.tencent.turingface.sdk.mfa.Xjpd8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.turingface.sdk.mfa.OTVRM b(android.content.Context r5) {
        /*
            r4 = this;
            int[] r0 = com.tencent.turingface.sdk.mfa.kC0XR.f45878x0
            java.lang.String r0 = com.tencent.turingface.sdk.mfa.kC0XR.a(r0)
            android.net.Uri r0 = android.net.Uri.parse(r0)
            int[] r1 = com.tencent.turingface.sdk.mfa.kC0XR.f45828a
            java.lang.String r1 = com.tencent.turingface.sdk.mfa.kC0XR.a(r1)
            int r2 = android.os.Build.VERSION.SDK_INT
            android.content.ContentResolver r5 = r5.getContentResolver()
            android.content.ContentProviderClient r5 = r5.acquireContentProviderClient(r0)
            r0 = 24
            r3 = 0
            android.os.Bundle r1 = r5.call(r1, r3, r3)     // Catch: java.lang.Throwable -> L25
            r3 = r1
            if (r2 < r0) goto L2f
            goto L2b
        L25:
            if (r5 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L2f
        L2b:
            r5.close()
            goto L32
        L2f:
            r5.release()
        L32:
            r5 = -1
            if (r3 != 0) goto L3a
            com.tencent.turingface.sdk.mfa.OTVRM r5 = com.tencent.turingface.sdk.mfa.OTVRM.a(r5)
            return r5
        L3a:
            int[] r0 = com.tencent.turingface.sdk.mfa.kC0XR.f45880y0
            java.lang.String r0 = com.tencent.turingface.sdk.mfa.kC0XR.a(r0)
            int r5 = r3.getInt(r0, r5)
            if (r5 == 0) goto L4c
            r5 = -2
            com.tencent.turingface.sdk.mfa.OTVRM r5 = com.tencent.turingface.sdk.mfa.OTVRM.a(r5)
            return r5
        L4c:
            com.tencent.turingface.sdk.mfa.OTVRM r5 = new com.tencent.turingface.sdk.mfa.OTVRM
            int[] r0 = com.tencent.turingface.sdk.mfa.kC0XR.f45882z0
            java.lang.String r0 = com.tencent.turingface.sdk.mfa.kC0XR.a(r0)
            java.lang.String r0 = r3.getString(r0)
            r1 = 0
            r5.<init>(r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.usfPi.b(android.content.Context):com.tencent.turingface.sdk.mfa.OTVRM");
    }
}
