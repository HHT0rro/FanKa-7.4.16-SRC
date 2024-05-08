package com.alipay.apmobilesecuritysdk.b;

import e0.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f4300b = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f4301a = 0;

    public static a a() {
        return f4300b;
    }

    public final void a(int i10) {
        this.f4301a = i10;
    }

    public final int b() {
        return this.f4301a;
    }

    public final String c() {
        String b4 = d.b();
        if (z.a.g(b4)) {
            return b4;
        }
        int i10 = this.f4301a;
        return i10 != 1 ? i10 != 3 ? i10 != 4 ? "https://mobilegw.alipay.com/mgw.htm" : "http://mobilegw.aaa.alipay.net/mgw.htm" : "http://mobilegw-1-64.test.alipay.net/mgw.htm" : "http://mobilegw.stable.alipay.net/mgw.htm";
    }
}
