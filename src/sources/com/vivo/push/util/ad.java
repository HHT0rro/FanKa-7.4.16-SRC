package com.vivo.push.util;

import android.content.Context;

/* compiled from: SharePreferenceManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ad extends c {

    /* renamed from: b, reason: collision with root package name */
    private static ad f46392b;

    public static synchronized ad b() {
        ad adVar;
        synchronized (ad.class) {
            if (f46392b == null) {
                f46392b = new ad();
            }
            adVar = f46392b;
        }
        return adVar;
    }

    public final synchronized void a(Context context) {
        if (this.f46413a == null) {
            this.f46413a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] b4 = b(b("com.vivo.push.secure_cache_iv", ""));
        return (b4 == null || b4.length <= 0) ? new byte[]{34, 32, 33, 37, 33, 34, 32, 33, 33, 33, 34, 41, 35, 32, 32, 32} : b4;
    }

    public final byte[] d() {
        byte[] b4 = b(b("com.vivo.push.secure_cache_key", ""));
        return (b4 == null || b4.length <= 0) ? new byte[]{33, 34, 35, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, 35, 34, 33} : b4;
    }

    private static byte[] b(String str) {
        int i10;
        byte[] bArr = null;
        try {
            String[] split = str.split(",");
            if (split.length > 0) {
                bArr = new byte[split.length];
                i10 = split.length;
            } else {
                i10 = 0;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                bArr[i11] = Byte.parseByte(split[i11].trim());
            }
        } catch (Exception e2) {
            u.a("SharePreferenceManager", "getCodeBytes error:" + e2.getMessage());
        }
        return bArr;
    }
}
