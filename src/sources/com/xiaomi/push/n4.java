package com.xiaomi.push;

import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n4 {

    /* renamed from: e, reason: collision with root package name */
    public static String f47990e = u5.a(5) + "-";

    /* renamed from: f, reason: collision with root package name */
    public static long f47991f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f47992g = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public h3 f47993a;

    /* renamed from: b, reason: collision with root package name */
    public short f47994b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f47995c;

    /* renamed from: d, reason: collision with root package name */
    public String f47996d;

    public n4() {
        this.f47994b = (short) 2;
        this.f47995c = f47992g;
        this.f47996d = null;
        this.f47993a = new h3();
    }

    public n4(h3 h3Var, short s2, byte[] bArr) {
        this.f47996d = null;
        this.f47993a = h3Var;
        this.f47994b = s2;
        this.f47995c = bArr;
    }

    @Deprecated
    public static n4 b(k5 k5Var, String str) {
        int i10;
        n4 n4Var = new n4();
        try {
            i10 = Integer.parseInt(k5Var.m());
        } catch (Exception e2) {
            fc.c.i("Blob parse chid err " + e2.getMessage());
            i10 = 1;
        }
        n4Var.g(i10);
        n4Var.i(k5Var.l());
        n4Var.u(k5Var.q());
        n4Var.r(k5Var.s());
        n4Var.j("XMLMSG", null);
        try {
            n4Var.l(k5Var.f().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                n4Var.k((short) 3);
            } else {
                n4Var.k((short) 2);
                n4Var.j("SECMSG", null);
            }
        } catch (UnsupportedEncodingException e10) {
            fc.c.i("Blob setPayload err： " + e10.getMessage());
        }
        return n4Var;
    }

    public static n4 c(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s2 = slice.getShort(0);
            short s10 = slice.getShort(2);
            int i10 = slice.getInt(4);
            h3 h3Var = new h3();
            h3Var.d(slice.array(), slice.arrayOffset() + 8, s10);
            byte[] bArr = new byte[i10];
            slice.position(s10 + 8);
            slice.get(bArr, 0, i10);
            return new n4(h3Var, s2, bArr);
        } catch (Exception e2) {
            fc.c.i("read Blob err :" + e2.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String v() {
        String sb2;
        synchronized (n4.class) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(f47990e);
            long j10 = f47991f;
            f47991f = 1 + j10;
            sb3.append(Long.toString(j10));
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public int a() {
        return this.f47993a.v();
    }

    public String d() {
        return this.f47993a.y();
    }

    public ByteBuffer e(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(s());
        }
        byteBuffer.putShort(this.f47994b);
        byteBuffer.putShort((short) this.f47993a.a());
        byteBuffer.putInt(this.f47995c.length);
        int position = byteBuffer.position();
        this.f47993a.f(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f47993a.a());
        byteBuffer.position(position + this.f47993a.a());
        byteBuffer.put(this.f47995c);
        return byteBuffer;
    }

    public short f() {
        return this.f47994b;
    }

    public void g(int i10) {
        this.f47993a.l(i10);
    }

    public void h(long j10, String str, String str2) {
        if (j10 != 0) {
            this.f47993a.m(j10);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f47993a.o(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f47993a.s(str2);
    }

    public void i(String str) {
        this.f47993a.G(str);
    }

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f47993a.x(str);
        this.f47993a.k();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f47993a.C(str2);
    }

    public void k(short s2) {
        this.f47994b = s2;
    }

    public void l(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f47993a.w(0);
            this.f47995c = bArr;
        } else {
            this.f47993a.w(1);
            this.f47995c = kc.s.i(kc.s.g(str, w()), bArr);
        }
    }

    public boolean m() {
        return this.f47993a.Q();
    }

    public byte[] n() {
        return this.f47995c;
    }

    public byte[] o(String str) {
        if (this.f47993a.F() == 1) {
            return kc.s.i(kc.s.g(str, w()), this.f47995c);
        }
        if (this.f47993a.F() == 0) {
            return this.f47995c;
        }
        fc.c.i("unknow cipher = " + this.f47993a.F());
        return this.f47995c;
    }

    public int p() {
        return this.f47993a.J();
    }

    public String q() {
        return this.f47993a.D();
    }

    public void r(String str) {
        this.f47996d = str;
    }

    public int s() {
        return this.f47993a.i() + 8 + this.f47995c.length;
    }

    public String t() {
        return this.f47993a.L();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + w() + "; cmd=" + d() + "; type=" + ((int) f()) + "; from=" + y() + " ]";
    }

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f47993a.m(parseLong);
            this.f47993a.o(substring);
            this.f47993a.s(substring2);
        } catch (Exception e2) {
            fc.c.i("Blob parse user err " + e2.getMessage());
        }
    }

    public String w() {
        String H = this.f47993a.H();
        if ("ID_NOT_AVAILABLE".equals(H)) {
            return null;
        }
        if (this.f47993a.N()) {
            return H;
        }
        String v2 = v();
        this.f47993a.G(v2);
        return v2;
    }

    public String x() {
        return this.f47996d;
    }

    public String y() {
        if (!this.f47993a.u()) {
            return null;
        }
        return Long.toString(this.f47993a.j()) + "@" + this.f47993a.p() + "/" + this.f47993a.t();
    }
}
