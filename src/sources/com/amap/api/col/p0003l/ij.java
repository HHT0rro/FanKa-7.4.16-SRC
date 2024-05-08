package com.amap.api.col.p0003l;

import android.content.Context;

/* compiled from: OfflineLocEntity.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ij {

    /* renamed from: a, reason: collision with root package name */
    private Context f6462a;

    /* renamed from: b, reason: collision with root package name */
    private fu f6463b;

    /* renamed from: c, reason: collision with root package name */
    private String f6464c;

    public ij(Context context, fu fuVar, String str) {
        this.f6462a = context.getApplicationContext();
        this.f6463b = fuVar;
        this.f6464c = str;
    }

    public final byte[] a() {
        return fv.a(a(this.f6462a, this.f6463b, this.f6464c));
    }

    private static String a(Context context, fu fuVar, String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("\"sdkversion\":\"");
            sb2.append(fuVar.c());
            sb2.append("\",\"product\":\"");
            sb2.append(fuVar.a());
            sb2.append("\",\"nt\":\"");
            sb2.append(fm.c(context));
            sb2.append("\",\"details\":");
            sb2.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb2.toString();
    }
}
