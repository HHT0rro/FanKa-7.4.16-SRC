package com.vivo.push.util;

/* compiled from: OperateUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class y {
    public static int a(com.vivo.push.b.c cVar) {
        ad b4 = ad.b();
        int b10 = cVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        int b11 = b4.b("com.vivo.push_preferences.operate." + b10 + "OPERATE_COUNT", 0);
        long b12 = currentTimeMillis - b4.b("com.vivo.push_preferences.operate." + b10 + "START_TIME", 0L);
        if (b12 <= 86400000 && b12 >= 0) {
            if (b11 >= cVar.d()) {
                return 1001;
            }
            b4.a("com.vivo.push_preferences.operate." + b10 + "OPERATE_COUNT", b11 + 1);
        } else {
            b4.a("com.vivo.push_preferences.operate." + b10 + "START_TIME", System.currentTimeMillis());
            b4.a("com.vivo.push_preferences.operate." + b10 + "OPERATE_COUNT", 1);
        }
        return 0;
    }
}
