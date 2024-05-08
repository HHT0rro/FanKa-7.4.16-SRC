package com.huawei.openalliance.ad.utils;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k {
    private static final String B = "com.huawei.software.features.mobiletv";
    private static final String C = "com.huawei.software.features.watch";
    private static final String Code = "DeviceTypeUtil";
    private static final String D = "com.hihonor.software.features.pad";
    private static final String F = "com.hihonor.software.features.handset";
    private static final String I = "com.huawei.software.features.pad";
    private static final String L = "com.hihonor.software.features.tv";
    private static final String S = "com.huawei.software.features.kidwatch";
    private static final String V = "com.huawei.software.features.handset";
    private static final String Z = "com.huawei.software.features.tv";

    /* renamed from: a, reason: collision with root package name */
    private static final String f32601a = "com.hihonor.software.features.mobiletv";

    /* renamed from: b, reason: collision with root package name */
    private static final String f32602b = "com.hihonor.software.features.watch";

    /* renamed from: c, reason: collision with root package name */
    private static final String f32603c = "com.hihonor.software.features.kidwatch";

    /* renamed from: d, reason: collision with root package name */
    private static final String f32604d = "default";

    /* renamed from: e, reason: collision with root package name */
    private static final String f32605e = "tablet";

    /* renamed from: f, reason: collision with root package name */
    private static final String f32606f = "tv";

    /* renamed from: g, reason: collision with root package name */
    private static k f32607g;

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f32608h = new byte[0];

    /* renamed from: i, reason: collision with root package name */
    private Context f32609i;

    /* renamed from: j, reason: collision with root package name */
    private String f32610j = "0";

    private k(Context context) {
        this.f32609i = context.getApplicationContext();
        Z();
    }

    public static k Code(Context context) {
        return V(context);
    }

    private static k V(Context context) {
        k kVar;
        synchronized (f32608h) {
            if (f32607g == null) {
                f32607g = new k(context);
            }
            kVar = f32607g;
        }
        return kVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ea, code lost:
    
        if (r0.equals(com.huawei.openalliance.ad.utils.k.f32606f) != false) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Z() {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.k.Z():void");
    }

    public String Code() {
        return this.f32610j;
    }

    public int I() {
        if ("4".equalsIgnoreCase(this.f32610j)) {
            return 8;
        }
        return "1".equalsIgnoreCase(this.f32610j) ? 5 : 4;
    }

    public boolean V() {
        return "4".equalsIgnoreCase(Code(this.f32609i).Code());
    }
}
