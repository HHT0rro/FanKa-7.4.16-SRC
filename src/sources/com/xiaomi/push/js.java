package com.xiaomi.push;

import com.xiaomi.push.ji;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class js extends ji {

    /* renamed from: o, reason: collision with root package name */
    public static int f47865o = 10000;

    /* renamed from: p, reason: collision with root package name */
    public static int f47866p = 10000;

    /* renamed from: q, reason: collision with root package name */
    public static int f47867q = 10000;

    /* renamed from: r, reason: collision with root package name */
    public static int f47868r = 10485760;

    /* renamed from: s, reason: collision with root package name */
    public static int f47869s = 104857600;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a extends ji.a {
        public a() {
            super(false, true);
        }

        public a(boolean z10, boolean z11, int i10) {
            super(z10, z11, i10);
        }

        @Override // com.xiaomi.push.ji.a, com.xiaomi.push.jo
        public x6 a(e7 e7Var) {
            js jsVar = new js(e7Var, ((ji.a) this).f617a, this.f47863b);
            int i10 = ((ji.a) this).f47862a;
            if (i10 != 0) {
                jsVar.L(i10);
            }
            return jsVar;
        }
    }

    public js(e7 e7Var, boolean z10, boolean z11) {
        super(e7Var, z10, z11);
    }

    @Override // com.xiaomi.push.ji, com.xiaomi.push.x6
    public v6 f() {
        byte a10 = a();
        int c4 = c();
        if (c4 <= f47866p) {
            return new v6(a10, c4);
        }
        throw new jn(3, "Thrift list size " + c4 + " out of range!");
    }

    @Override // com.xiaomi.push.ji, com.xiaomi.push.x6
    public w6 g() {
        byte a10 = a();
        byte a11 = a();
        int c4 = c();
        if (c4 <= f47865o) {
            return new w6(a10, a11, c4);
        }
        throw new jn(3, "Thrift map size " + c4 + " out of range!");
    }

    @Override // com.xiaomi.push.ji, com.xiaomi.push.x6
    public z6 h() {
        byte a10 = a();
        int c4 = c();
        if (c4 <= f47867q) {
            return new z6(a10, c4);
        }
        throw new jn(3, "Thrift set size " + c4 + " out of range!");
    }

    @Override // com.xiaomi.push.ji, com.xiaomi.push.x6
    public String j() {
        int c4 = c();
        if (c4 > f47868r) {
            throw new jn(3, "Thrift string size " + c4 + " out of range!");
        }
        if (this.f48482a.f() < c4) {
            return K(c4);
        }
        try {
            String str = new String(this.f48482a.e(), this.f48482a.a(), c4, "UTF-8");
            this.f48482a.c(c4);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new jg("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ji, com.xiaomi.push.x6
    public ByteBuffer k() {
        int c4 = c();
        if (c4 > f47869s) {
            throw new jn(3, "Thrift binary size " + c4 + " out of range!");
        }
        M(c4);
        if (this.f48482a.f() >= c4) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f48482a.e(), this.f48482a.a(), c4);
            this.f48482a.c(c4);
            return wrap;
        }
        byte[] bArr = new byte[c4];
        this.f48482a.g(bArr, 0, c4);
        return ByteBuffer.wrap(bArr);
    }
}
