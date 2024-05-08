package com.tencent.open.a;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {
    public static int a(String str) {
        int a10;
        if (com.tencent.open.utils.f.a() == null || (a10 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a10;
    }

    public static int a() {
        int a10 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_HttpRetryCount");
        if (a10 == 0) {
            return 2;
        }
        return a10;
    }
}
