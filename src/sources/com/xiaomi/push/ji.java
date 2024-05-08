package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ji extends x6 {

    /* renamed from: n, reason: collision with root package name */
    public static final a7 f47849n = new a7();

    /* renamed from: b, reason: collision with root package name */
    public boolean f47850b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47851c;

    /* renamed from: d, reason: collision with root package name */
    public int f47852d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47853e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f47854f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f47855g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f47856h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f47857i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f47858j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f47859k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f47860l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f47861m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements jo {

        /* renamed from: a, reason: collision with root package name */
        public int f47862a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f617a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f47863b;

        public a() {
            this(false, true);
        }

        public a(boolean z10, boolean z11) {
            this(z10, z11, 0);
        }

        public a(boolean z10, boolean z11, int i10) {
            this.f617a = z10;
            this.f47863b = z11;
            this.f47862a = i10;
        }

        @Override // com.xiaomi.push.jo
        public x6 a(e7 e7Var) {
            ji jiVar = new ji(e7Var, this.f617a, this.f47863b);
            int i10 = this.f47862a;
            if (i10 != 0) {
                jiVar.L(i10);
            }
            return jiVar;
        }
    }

    public ji(e7 e7Var, boolean z10, boolean z11) {
        super(e7Var);
        this.f47853e = false;
        this.f47854f = new byte[1];
        this.f47855g = new byte[2];
        this.f47856h = new byte[4];
        this.f47857i = new byte[8];
        this.f47858j = new byte[1];
        this.f47859k = new byte[2];
        this.f47860l = new byte[4];
        this.f47861m = new byte[8];
        this.f47850b = z10;
        this.f47851c = z11;
    }

    @Override // com.xiaomi.push.x6
    public void A() {
        n((byte) 0);
    }

    @Override // com.xiaomi.push.x6
    public void B() {
    }

    @Override // com.xiaomi.push.x6
    public void C() {
    }

    @Override // com.xiaomi.push.x6
    public void D() {
    }

    @Override // com.xiaomi.push.x6
    public void E() {
    }

    @Override // com.xiaomi.push.x6
    public void F() {
    }

    @Override // com.xiaomi.push.x6
    public void G() {
    }

    @Override // com.xiaomi.push.x6
    public void H() {
    }

    public final int J(byte[] bArr, int i10, int i11) {
        M(i11);
        return this.f48482a.g(bArr, i10, i11);
    }

    public String K(int i10) {
        try {
            M(i10);
            byte[] bArr = new byte[i10];
            this.f48482a.g(bArr, 0, i10);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new jg("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void L(int i10) {
        this.f47852d = i10;
        this.f47853e = true;
    }

    public void M(int i10) {
        if (i10 < 0) {
            throw new jg("Negative length: " + i10);
        }
        if (this.f47853e) {
            int i11 = this.f47852d - i10;
            this.f47852d = i11;
            if (i11 >= 0) {
                return;
            }
            throw new jg("Message length exceeded: " + i10);
        }
    }

    @Override // com.xiaomi.push.x6
    public byte a() {
        if (this.f48482a.f() < 1) {
            J(this.f47858j, 0, 1);
            return this.f47858j[0];
        }
        byte b4 = this.f48482a.e()[this.f48482a.a()];
        this.f48482a.c(1);
        return b4;
    }

    @Override // com.xiaomi.push.x6
    public double b() {
        return Double.longBitsToDouble(d());
    }

    @Override // com.xiaomi.push.x6
    public int c() {
        byte[] bArr = this.f47860l;
        int i10 = 0;
        if (this.f48482a.f() >= 4) {
            bArr = this.f48482a.e();
            i10 = this.f48482a.a();
            this.f48482a.c(4);
        } else {
            J(this.f47860l, 0, 4);
        }
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.x6
    public long d() {
        byte[] bArr = this.f47861m;
        int i10 = 0;
        if (this.f48482a.f() >= 8) {
            bArr = this.f48482a.e();
            i10 = this.f48482a.a();
            this.f48482a.c(8);
        } else {
            J(this.f47861m, 0, 8);
        }
        return (bArr[i10 + 7] & 255) | ((bArr[i10] & 255) << 56) | ((bArr[i10 + 1] & 255) << 48) | ((bArr[i10 + 2] & 255) << 40) | ((bArr[i10 + 3] & 255) << 32) | ((bArr[i10 + 4] & 255) << 24) | ((bArr[i10 + 5] & 255) << 16) | ((bArr[i10 + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.x6
    public u6 e() {
        byte a10 = a();
        return new u6("", a10, a10 == 0 ? (short) 0 : l());
    }

    @Override // com.xiaomi.push.x6
    public v6 f() {
        return new v6(a(), c());
    }

    @Override // com.xiaomi.push.x6
    public w6 g() {
        return new w6(a(), a(), c());
    }

    @Override // com.xiaomi.push.x6
    public z6 h() {
        return new z6(a(), c());
    }

    @Override // com.xiaomi.push.x6
    public a7 i() {
        return f47849n;
    }

    @Override // com.xiaomi.push.x6
    public String j() {
        int c4 = c();
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

    @Override // com.xiaomi.push.x6
    public ByteBuffer k() {
        int c4 = c();
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

    @Override // com.xiaomi.push.x6
    public short l() {
        byte[] bArr = this.f47859k;
        int i10 = 0;
        if (this.f48482a.f() >= 2) {
            bArr = this.f48482a.e();
            i10 = this.f48482a.a();
            this.f48482a.c(2);
        } else {
            J(this.f47859k, 0, 2);
        }
        return (short) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }

    @Override // com.xiaomi.push.x6
    public void m() {
    }

    @Override // com.xiaomi.push.x6
    public void n(byte b4) {
        byte[] bArr = this.f47854f;
        bArr[0] = b4;
        this.f48482a.d(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.x6
    public void o(int i10) {
        byte[] bArr = this.f47856h;
        bArr[0] = (byte) ((i10 >> 24) & 255);
        bArr[1] = (byte) ((i10 >> 16) & 255);
        bArr[2] = (byte) ((i10 >> 8) & 255);
        bArr[3] = (byte) (i10 & 255);
        this.f48482a.d(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.x6
    public void p(long j10) {
        byte[] bArr = this.f47857i;
        bArr[0] = (byte) ((j10 >> 56) & 255);
        bArr[1] = (byte) ((j10 >> 48) & 255);
        bArr[2] = (byte) ((j10 >> 40) & 255);
        bArr[3] = (byte) ((j10 >> 32) & 255);
        bArr[4] = (byte) ((j10 >> 24) & 255);
        bArr[5] = (byte) ((j10 >> 16) & 255);
        bArr[6] = (byte) ((j10 >> 8) & 255);
        bArr[7] = (byte) (j10 & 255);
        this.f48482a.d(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.x6
    public void q(u6 u6Var) {
        n(u6Var.f48410b);
        w(u6Var.f48411c);
    }

    @Override // com.xiaomi.push.x6
    public void r(v6 v6Var) {
        n(v6Var.f48447a);
        o(v6Var.f48448b);
    }

    @Override // com.xiaomi.push.x6
    public void s(w6 w6Var) {
        n(w6Var.f48459a);
        n(w6Var.f48460b);
        o(w6Var.f48461c);
    }

    @Override // com.xiaomi.push.x6
    public void t(a7 a7Var) {
    }

    @Override // com.xiaomi.push.x6
    public void u(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            o(bytes.length);
            this.f48482a.d(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new jg("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.x6
    public void v(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        o(limit);
        this.f48482a.d(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.x6
    public void w(short s2) {
        byte[] bArr = this.f47855g;
        bArr[0] = (byte) ((s2 >> 8) & 255);
        bArr[1] = (byte) (s2 & 255);
        this.f48482a.d(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.x6
    public void x(boolean z10) {
        n(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.x6
    public boolean y() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.x6
    public void z() {
    }
}
