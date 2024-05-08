package com.xiaomi.push;

import java.net.InetSocketAddress;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    public String f48369a;

    /* renamed from: b, reason: collision with root package name */
    public int f48370b;

    public t1(String str, int i10) {
        this.f48369a = str;
        this.f48370b = i10;
    }

    public static t1 b(String str, int i10) {
        int lastIndexOf = str.lastIndexOf(com.huawei.openalliance.ad.constant.u.bD);
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i10 = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new t1(str, i10);
    }

    public static InetSocketAddress d(String str, int i10) {
        t1 b4 = b(str, i10);
        return new InetSocketAddress(b4.c(), b4.a());
    }

    public int a() {
        return this.f48370b;
    }

    public String c() {
        return this.f48369a;
    }

    public String toString() {
        if (this.f48370b <= 0) {
            return this.f48369a;
        }
        return this.f48369a + com.huawei.openalliance.ad.constant.u.bD + this.f48370b;
    }
}
