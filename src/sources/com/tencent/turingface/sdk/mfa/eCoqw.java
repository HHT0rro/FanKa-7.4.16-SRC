package com.tencent.turingface.sdk.mfa;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class eCoqw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f45770a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f45771b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ rBDKv f45772c;

    public eCoqw(rBDKv rbdkv, Context context, int i10) {
        this.f45772c = rbdkv;
        this.f45770a = context;
        this.f45771b = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r9 = this;
            com.tencent.turingface.sdk.mfa.rBDKv r0 = r9.f45772c
            android.content.Context r1 = r9.f45770a
            int r2 = r9.f45771b
            com.tencent.turingface.sdk.mfa.fenkF r3 = r0.f45932g
            r3.getClass()
            java.lang.String r3 = "403"
            java.lang.String r3 = com.tencent.turingface.sdk.mfa.fenkF.b(r1, r3)
            r4 = 1
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L22
            if (r5 == 0) goto L19
            goto L22
        L19:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L22
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Throwable -> L22
            goto L23
        L22:
            r3 = 1
        L23:
            r5 = 0
            r6 = 0
        L25:
            com.tencent.turingface.sdk.mfa.CvowV r7 = r0.f45929d
            int r7 = r7.f45560v
            if (r6 >= r7) goto L3f
            com.tencent.turingface.sdk.mfa.vneRm r7 = r0.a(r1, r4, r3, r2)
            r0.a(r7, r4)
            int r7 = r7.f45967c
            if (r7 != 0) goto L37
            goto L3f
        L37:
            r8 = -30014(0xffffffffffff8ac2, float:NaN)
            if (r7 != r8) goto L3c
            goto L3f
        L3c:
            int r6 = r6 + 1
            goto L25
        L3f:
            if (r3 == 0) goto L5c
            com.tencent.turingface.sdk.mfa.fenkF r2 = r0.f45932g
            r2.getClass()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = ""
            r3.append(r6)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "403"
            r2.a(r1, r5, r3, r4)
        L5c:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r0.f45935j
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r2 = r0.f45935j     // Catch: java.lang.Throwable -> L6d
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L6d
            r2.set(r3)     // Catch: java.lang.Throwable -> L6d
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r0.f45935j     // Catch: java.lang.Throwable -> L6d
            r0.notifyAll()     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L6d
            return
        L6d:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L6d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.eCoqw.run():void");
    }
}
