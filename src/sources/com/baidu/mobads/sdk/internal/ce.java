package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.an;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ce implements an.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ double f10015a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ by f10016b;

    public ce(by byVar, double d10) {
        this.f10016b = byVar;
        this.f10015a = d10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0055, code lost:
    
        if (r9 == java.lang.Math.floor(r4.b())) goto L12;
     */
    @Override // com.baidu.mobads.sdk.internal.an.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            com.baidu.mobads.sdk.internal.by r10 = r8.f10016b
            com.baidu.mobads.sdk.internal.bw r0 = new com.baidu.mobads.sdk.internal.bw
            r0.<init>(r9)
            com.baidu.mobads.sdk.internal.by.a(r10, r0)
            double r9 = com.baidu.mobads.sdk.internal.cl.b()
            com.baidu.mobads.sdk.internal.by r0 = r8.f10016b
            android.content.SharedPreferences r0 = com.baidu.mobads.sdk.internal.by.f(r0)
            java.lang.String r1 = "__badApkVersion__9.332"
            r2 = 0
            float r0 = r0.getFloat(r1, r2)
            com.baidu.mobads.sdk.internal.by r1 = r8.f10016b
            com.baidu.mobads.sdk.internal.bw r1 = com.baidu.mobads.sdk.internal.by.g(r1)
            double r1 = r1.b()
            float r1 = (float) r1
            r2 = 1
            r3 = 0
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L2e
            r1 = 1
            goto L2f
        L2e:
            r1 = 0
        L2f:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            com.baidu.mobads.sdk.internal.by r4 = r8.f10016b
            com.baidu.mobads.sdk.internal.bw r4 = com.baidu.mobads.sdk.internal.by.g(r4)
            double r4 = r4.b()
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 > 0) goto L58
            double r9 = java.lang.Math.floor(r9)
            com.baidu.mobads.sdk.internal.by r4 = r8.f10016b
            com.baidu.mobads.sdk.internal.bw r4 = com.baidu.mobads.sdk.internal.by.g(r4)
            double r4 = r4.b()
            double r4 = java.lang.Math.floor(r4)
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 != 0) goto L58
            goto L59
        L58:
            r2 = 0
        L59:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r2)
            com.baidu.mobads.sdk.internal.by r10 = r8.f10016b
            com.baidu.mobads.sdk.internal.bs r10 = com.baidu.mobads.sdk.internal.by.e(r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "try to download apk badVer="
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = ", isBad="
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = ", compatible="
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "ApkLoader"
            r10.a(r2, r0)
            double r4 = r8.f10015a
            com.baidu.mobads.sdk.internal.by r10 = r8.f10016b
            com.baidu.mobads.sdk.internal.bw r10 = com.baidu.mobads.sdk.internal.by.g(r10)
            double r6 = r10.b()
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 >= 0) goto Lc7
            com.baidu.mobads.sdk.internal.by r10 = r8.f10016b
            com.baidu.mobads.sdk.internal.bw r10 = com.baidu.mobads.sdk.internal.by.g(r10)
            if (r10 == 0) goto Lc7
            com.baidu.mobads.sdk.internal.by r10 = r8.f10016b
            com.baidu.mobads.sdk.internal.bw r10 = com.baidu.mobads.sdk.internal.by.g(r10)
            java.lang.Boolean r10 = r10.a()
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Lc7
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lc7
            boolean r9 = r1.booleanValue()
            if (r9 != 0) goto Lc7
            com.baidu.mobads.sdk.internal.by r9 = r8.f10016b
            com.baidu.mobads.sdk.internal.bw r10 = com.baidu.mobads.sdk.internal.by.g(r9)
            com.baidu.mobads.sdk.internal.by.b(r9, r10)
            goto Ldb
        Lc7:
            com.baidu.mobads.sdk.internal.by r9 = r8.f10016b
            boolean r9 = com.baidu.mobads.sdk.internal.by.c(r9)
            if (r9 == 0) goto Ldb
            com.baidu.mobads.sdk.internal.by r9 = r8.f10016b
            com.baidu.mobads.sdk.internal.by.a(r9, r3)
            com.baidu.mobads.sdk.internal.by r9 = r8.f10016b
            java.lang.String r10 = "Refused to download remote for version..."
            com.baidu.mobads.sdk.internal.by.a(r9, r3, r10)
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.ce.a(java.lang.String, java.lang.String):void");
    }

    @Override // com.baidu.mobads.sdk.internal.an.b
    public void a(String str, int i10) {
        boolean z10;
        z10 = this.f10016b.A;
        if (z10) {
            this.f10016b.A = false;
            this.f10016b.a(false, "remote update Network access failed");
        }
    }
}
