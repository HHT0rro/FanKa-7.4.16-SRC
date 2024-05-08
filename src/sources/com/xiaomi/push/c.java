package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f47144a;

    /* renamed from: b, reason: collision with root package name */
    public final int f47145b;

    /* renamed from: c, reason: collision with root package name */
    public int f47146c;

    /* renamed from: d, reason: collision with root package name */
    public final OutputStream f47147d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public c(OutputStream outputStream, byte[] bArr) {
        this.f47147d = outputStream;
        this.f47144a = bArr;
        this.f47146c = 0;
        this.f47145b = bArr.length;
    }

    public c(byte[] bArr, int i10, int i11) {
        this.f47147d = null;
        this.f47144a = bArr;
        this.f47146c = i10;
        this.f47145b = i10 + i11;
    }

    public static int G(int i10) {
        return V(i10);
    }

    public static int H(int i10, int i11) {
        return P(i10) + G(i11);
    }

    public static int I(int i10, long j10) {
        return P(i10) + J(j10);
    }

    public static int J(long j10) {
        return Q(j10);
    }

    public static int P(int i10) {
        return V(c4.b(i10, 0));
    }

    public static int Q(long j10) {
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (((-16384) & j10) == 0) {
            return 2;
        }
        if (((-2097152) & j10) == 0) {
            return 3;
        }
        if (((-268435456) & j10) == 0) {
            return 4;
        }
        if (((-34359738368L) & j10) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j10) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j10) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j10) == 0) {
            return 8;
        }
        return (j10 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int V(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int b(int i10) {
        if (i10 >= 0) {
            return V(i10);
        }
        return 10;
    }

    public static int c(int i10, int i11) {
        return P(i10) + b(i11);
    }

    public static int d(int i10, long j10) {
        return P(i10) + i(j10);
    }

    public static int e(int i10, com.xiaomi.push.a aVar) {
        return P(i10) + j(aVar);
    }

    public static int f(int i10, t2 t2Var) {
        return P(i10) + k(t2Var);
    }

    public static int g(int i10, String str) {
        return P(i10) + l(str);
    }

    public static int h(int i10, boolean z10) {
        return P(i10) + m(z10);
    }

    public static int i(long j10) {
        return Q(j10);
    }

    public static int j(com.xiaomi.push.a aVar) {
        return V(aVar.a()) + aVar.a();
    }

    public static int k(t2 t2Var) {
        int i10 = t2Var.i();
        return V(i10) + i10;
    }

    public static int l(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return V(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int m(boolean z10) {
        return 1;
    }

    public static c n(OutputStream outputStream) {
        return o(outputStream, 4096);
    }

    public static c o(OutputStream outputStream, int i10) {
        return new c(outputStream, new byte[i10]);
    }

    public static c p(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    public void A(com.xiaomi.push.a aVar) {
        byte[] d10 = aVar.d();
        W(d10.length);
        E(d10);
    }

    public void B(t2 t2Var) {
        W(t2Var.a());
        t2Var.e(this);
    }

    public void C(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        W(bytes.length);
        E(bytes);
    }

    public void D(boolean z10) {
        S(z10 ? 1 : 0);
    }

    public void E(byte[] bArr) {
        F(bArr, 0, bArr.length);
    }

    public void F(byte[] bArr, int i10, int i11) {
        int i12 = this.f47145b;
        int i13 = this.f47146c;
        if (i12 - i13 >= i11) {
            System.arraycopy((Object) bArr, i10, (Object) this.f47144a, i13, i11);
            this.f47146c += i11;
            return;
        }
        int i14 = i12 - i13;
        System.arraycopy((Object) bArr, i10, (Object) this.f47144a, i13, i14);
        int i15 = i10 + i14;
        int i16 = i11 - i14;
        this.f47146c = this.f47145b;
        R();
        if (i16 > this.f47145b) {
            this.f47147d.write(bArr, i15, i16);
        } else {
            System.arraycopy((Object) bArr, i15, (Object) this.f47144a, 0, i16);
            this.f47146c = i16;
        }
    }

    public void K() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void L(int i10) {
        W(i10);
    }

    public void M(int i10, int i11) {
        T(i10, 0);
        L(i11);
    }

    public void N(int i10, long j10) {
        T(i10, 0);
        O(j10);
    }

    public void O(long j10) {
        U(j10);
    }

    public final void R() {
        OutputStream outputStream = this.f47147d;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f47144a, 0, this.f47146c);
        this.f47146c = 0;
    }

    public void S(int i10) {
        r((byte) i10);
    }

    public void T(int i10, int i11) {
        W(c4.b(i10, i11));
    }

    public void U(long j10) {
        while (((-128) & j10) != 0) {
            S((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        S((int) j10);
    }

    public void W(int i10) {
        while ((i10 & (-128)) != 0) {
            S((i10 & 127) | 128);
            i10 >>>= 7;
        }
        S(i10);
    }

    public int a() {
        if (this.f47147d == null) {
            return this.f47145b - this.f47146c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void q() {
        if (this.f47147d != null) {
            R();
        }
    }

    public void r(byte b4) {
        if (this.f47146c == this.f47145b) {
            R();
        }
        byte[] bArr = this.f47144a;
        int i10 = this.f47146c;
        this.f47146c = i10 + 1;
        bArr[i10] = b4;
    }

    public void s(int i10) {
        if (i10 >= 0) {
            W(i10);
        } else {
            U(i10);
        }
    }

    public void t(int i10, int i11) {
        T(i10, 0);
        s(i11);
    }

    public void u(int i10, long j10) {
        T(i10, 0);
        z(j10);
    }

    public void v(int i10, com.xiaomi.push.a aVar) {
        T(i10, 2);
        A(aVar);
    }

    public void w(int i10, t2 t2Var) {
        T(i10, 2);
        B(t2Var);
    }

    public void x(int i10, String str) {
        T(i10, 2);
        C(str);
    }

    public void y(int i10, boolean z10) {
        T(i10, 0);
        D(z10);
    }

    public void z(long j10) {
        U(j10);
    }
}
