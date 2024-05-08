package com.amap.api.col.s;

import android.content.Context;

/* compiled from: OfflineLocEntity.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ed {

    /* renamed from: a, reason: collision with root package name */
    private Context f7881a;

    /* renamed from: b, reason: collision with root package name */
    private ch f7882b;

    /* renamed from: c, reason: collision with root package name */
    private String f7883c;

    public final byte[] a() {
        return ci.a(a(this.f7881a, this.f7882b, this.f7883c));
    }

    private static String a(Context context, ch chVar, String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("\"sdkversion\":\"");
            sb2.append(chVar.d());
            sb2.append("\",\"product\":\"");
            sb2.append(chVar.b());
            sb2.append("\",\"nt\":\"");
            sb2.append(ca.c(context));
            sb2.append("\",\"details\":");
            sb2.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb2.toString();
    }
}
