package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzbn extends y {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f24130b = Logger.getLogger(zzbn.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f24131c = p3.x();

    /* renamed from: a, reason: collision with root package name */
    public i0 f24132a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a extends zzbn {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f24133d;

        /* renamed from: e, reason: collision with root package name */
        public final int f24134e;

        /* renamed from: f, reason: collision with root package name */
        public final int f24135f;

        /* renamed from: g, reason: collision with root package name */
        public int f24136g;

        public a(byte[] bArr, int i10, int i11) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i12 = i10 + i11;
            if ((i10 | i11 | (bArr.length - i12)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            this.f24133d = bArr;
            this.f24134e = i10;
            this.f24136g = i10;
            this.f24135f = i12;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void A0(int i10) throws IOException {
            try {
                byte[] bArr = this.f24133d;
                int i11 = this.f24136g;
                int i12 = i11 + 1;
                this.f24136g = i12;
                bArr[i11] = (byte) i10;
                int i13 = i12 + 1;
                this.f24136g = i13;
                bArr[i12] = (byte) (i10 >> 8);
                int i14 = i13 + 1;
                this.f24136g = i14;
                bArr[i13] = (byte) (i10 >> 16);
                this.f24136g = i14 + 1;
                bArr[i14] = i10 >> 24;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f24136g), Integer.valueOf(this.f24135f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void G(int i10, int i11) throws IOException {
            y0((i10 << 3) | i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void I(int i10, zzbb zzbbVar) throws IOException {
            G(1, 3);
            b0(2, i10);
            m(3, zzbbVar);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void J(int i10, a2 a2Var) throws IOException {
            G(1, 3);
            b0(2, i10);
            n(3, a2Var);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void K(int i10, boolean z10) throws IOException {
            G(i10, 0);
            g(z10 ? (byte) 1 : (byte) 0);
        }

        public final int K0() {
            return this.f24136g - this.f24134e;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void L(long j10) throws IOException {
            if (zzbn.f24131c && u() >= 10) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.f24133d;
                    int i10 = this.f24136g;
                    this.f24136g = i10 + 1;
                    p3.k(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f24133d;
                int i11 = this.f24136g;
                this.f24136g = i11 + 1;
                p3.k(bArr2, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f24133d;
                    int i12 = this.f24136g;
                    this.f24136g = i12 + 1;
                    bArr3[i12] = (byte) ((((int) j10) & 127) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f24136g), Integer.valueOf(this.f24135f), 1), e2);
                }
            }
            byte[] bArr4 = this.f24133d;
            int i13 = this.f24136g;
            this.f24136g = i13 + 1;
            bArr4[i13] = (byte) j10;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void M(a2 a2Var) throws IOException {
            y0(a2Var.g());
            a2Var.e(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void T(int i10, int i11) throws IOException {
            G(i10, 0);
            x0(i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void U(int i10, long j10) throws IOException {
            G(i10, 1);
            c0(j10);
        }

        @Override // com.google.android.gms.internal.clearcut.y
        public final void a(byte[] bArr, int i10, int i11) throws IOException {
            c(bArr, i10, i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public void b() {
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b0(int i10, int i11) throws IOException {
            G(i10, 0);
            y0(i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c(byte[] bArr, int i10, int i11) throws IOException {
            try {
                System.arraycopy((Object) bArr, i10, (Object) this.f24133d, this.f24136g, i11);
                this.f24136g += i11;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f24136g), Integer.valueOf(this.f24135f), Integer.valueOf(i11)), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c0(long j10) throws IOException {
            try {
                byte[] bArr = this.f24133d;
                int i10 = this.f24136g;
                int i11 = i10 + 1;
                this.f24136g = i11;
                bArr[i10] = (byte) j10;
                int i12 = i11 + 1;
                this.f24136g = i12;
                bArr[i11] = (byte) (j10 >> 8);
                int i13 = i12 + 1;
                this.f24136g = i13;
                bArr[i12] = (byte) (j10 >> 16);
                int i14 = i13 + 1;
                this.f24136g = i14;
                bArr[i13] = (byte) (j10 >> 24);
                int i15 = i14 + 1;
                this.f24136g = i15;
                bArr[i14] = (byte) (j10 >> 32);
                int i16 = i15 + 1;
                this.f24136g = i16;
                bArr[i15] = (byte) (j10 >> 40);
                int i17 = i16 + 1;
                this.f24136g = i17;
                bArr[i16] = (byte) (j10 >> 48);
                this.f24136g = i17 + 1;
                bArr[i17] = (byte) (j10 >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f24136g), Integer.valueOf(this.f24135f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void g(byte b4) throws IOException {
            try {
                byte[] bArr = this.f24133d;
                int i10 = this.f24136g;
                this.f24136g = i10 + 1;
                bArr[i10] = b4;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f24136g), Integer.valueOf(this.f24135f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void i0(int i10, int i11) throws IOException {
            G(i10, 5);
            A0(i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void l(int i10, long j10) throws IOException {
            G(i10, 0);
            L(j10);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m(int i10, zzbb zzbbVar) throws IOException {
            G(i10, 2);
            q(zzbbVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m0(String str) throws IOException {
            int i10 = this.f24136g;
            try {
                int D0 = zzbn.D0(str.length() * 3);
                int D02 = zzbn.D0(str.length());
                if (D02 != D0) {
                    y0(r3.a(str));
                    this.f24136g = r3.b(str, this.f24133d, this.f24136g, u());
                    return;
                }
                int i11 = i10 + D02;
                this.f24136g = i11;
                int b4 = r3.b(str, this.f24133d, i11, u());
                this.f24136g = i10;
                y0((b4 - i10) - D02);
                this.f24136g = b4;
            } catch (zzfi e2) {
                this.f24136g = i10;
                s(str, e2);
            } catch (IndexOutOfBoundsException e10) {
                throw new zzc(e10);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void n(int i10, a2 a2Var) throws IOException {
            G(i10, 2);
            M(a2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void o(int i10, a2 a2Var, r2 r2Var) throws IOException {
            G(i10, 2);
            q qVar = (q) a2Var;
            int f10 = qVar.f();
            if (f10 == -1) {
                f10 = r2Var.f(qVar);
                qVar.b(f10);
            }
            y0(f10);
            r2Var.b(a2Var, this.f24132a);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void p(int i10, String str) throws IOException {
            G(i10, 2);
            m0(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void q(zzbb zzbbVar) throws IOException {
            y0(zzbbVar.size());
            zzbbVar.zza(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void r(a2 a2Var, r2 r2Var) throws IOException {
            q qVar = (q) a2Var;
            int f10 = qVar.f();
            if (f10 == -1) {
                f10 = r2Var.f(qVar);
                qVar.b(f10);
            }
            y0(f10);
            r2Var.b(a2Var, this.f24132a);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int u() {
            return this.f24135f - this.f24136g;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void x0(int i10) throws IOException {
            if (i10 >= 0) {
                y0(i10);
            } else {
                L(i10);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void y0(int i10) throws IOException {
            if (zzbn.f24131c && u() >= 10) {
                while ((i10 & (-128)) != 0) {
                    byte[] bArr = this.f24133d;
                    int i11 = this.f24136g;
                    this.f24136g = i11 + 1;
                    p3.k(bArr, i11, (byte) ((i10 & 127) | 128));
                    i10 >>>= 7;
                }
                byte[] bArr2 = this.f24133d;
                int i12 = this.f24136g;
                this.f24136g = i12 + 1;
                p3.k(bArr2, i12, (byte) i10);
                return;
            }
            while ((i10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f24133d;
                    int i13 = this.f24136g;
                    this.f24136g = i13 + 1;
                    bArr3[i13] = (byte) ((i10 & 127) | 128);
                    i10 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f24136g), Integer.valueOf(this.f24135f), 1), e2);
                }
            }
            byte[] bArr4 = this.f24133d;
            int i14 = this.f24136g;
            this.f24136g = i14 + 1;
            bArr4[i14] = (byte) i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends a {

        /* renamed from: h, reason: collision with root package name */
        public final ByteBuffer f24137h;

        /* renamed from: i, reason: collision with root package name */
        public int f24138i;

        public b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f24137h = byteBuffer;
            this.f24138i = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn.a, com.google.android.gms.internal.clearcut.zzbn
        public final void b() {
            this.f24137h.position(this.f24138i + K0());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends zzbn {

        /* renamed from: d, reason: collision with root package name */
        public final ByteBuffer f24139d;

        /* renamed from: e, reason: collision with root package name */
        public final ByteBuffer f24140e;

        /* renamed from: f, reason: collision with root package name */
        public final int f24141f;

        public c(ByteBuffer byteBuffer) {
            super();
            this.f24139d = byteBuffer;
            this.f24140e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f24141f = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void A0(int i10) throws IOException {
            try {
                this.f24140e.putInt(i10);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void G(int i10, int i11) throws IOException {
            y0((i10 << 3) | i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void I(int i10, zzbb zzbbVar) throws IOException {
            G(1, 3);
            b0(2, i10);
            m(3, zzbbVar);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void J(int i10, a2 a2Var) throws IOException {
            G(1, 3);
            b0(2, i10);
            n(3, a2Var);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void K(int i10, boolean z10) throws IOException {
            G(i10, 0);
            g(z10 ? (byte) 1 : (byte) 0);
        }

        public final void K0(String str) throws IOException {
            try {
                r3.c(str, this.f24140e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void L(long j10) throws IOException {
            while (((-128) & j10) != 0) {
                try {
                    this.f24140e.put((byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f24140e.put((byte) j10);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void M(a2 a2Var) throws IOException {
            y0(a2Var.g());
            a2Var.e(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void T(int i10, int i11) throws IOException {
            G(i10, 0);
            x0(i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void U(int i10, long j10) throws IOException {
            G(i10, 1);
            c0(j10);
        }

        @Override // com.google.android.gms.internal.clearcut.y
        public final void a(byte[] bArr, int i10, int i11) throws IOException {
            c(bArr, i10, i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b() {
            this.f24139d.position(this.f24140e.position());
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b0(int i10, int i11) throws IOException {
            G(i10, 0);
            y0(i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c(byte[] bArr, int i10, int i11) throws IOException {
            try {
                this.f24140e.put(bArr, i10, i11);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            } catch (BufferOverflowException e10) {
                throw new zzc(e10);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c0(long j10) throws IOException {
            try {
                this.f24140e.putLong(j10);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void g(byte b4) throws IOException {
            try {
                this.f24140e.put(b4);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void i0(int i10, int i11) throws IOException {
            G(i10, 5);
            A0(i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void l(int i10, long j10) throws IOException {
            G(i10, 0);
            L(j10);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m(int i10, zzbb zzbbVar) throws IOException {
            G(i10, 2);
            q(zzbbVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m0(String str) throws IOException {
            int position = this.f24140e.position();
            try {
                int D0 = zzbn.D0(str.length() * 3);
                int D02 = zzbn.D0(str.length());
                if (D02 != D0) {
                    y0(r3.a(str));
                    K0(str);
                    return;
                }
                int position2 = this.f24140e.position() + D02;
                this.f24140e.position(position2);
                K0(str);
                int position3 = this.f24140e.position();
                this.f24140e.position(position);
                y0(position3 - position2);
                this.f24140e.position(position3);
            } catch (zzfi e2) {
                this.f24140e.position(position);
                s(str, e2);
            } catch (IllegalArgumentException e10) {
                throw new zzc(e10);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void n(int i10, a2 a2Var) throws IOException {
            G(i10, 2);
            M(a2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void o(int i10, a2 a2Var, r2 r2Var) throws IOException {
            G(i10, 2);
            r(a2Var, r2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void p(int i10, String str) throws IOException {
            G(i10, 2);
            m0(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void q(zzbb zzbbVar) throws IOException {
            y0(zzbbVar.size());
            zzbbVar.zza(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void r(a2 a2Var, r2 r2Var) throws IOException {
            q qVar = (q) a2Var;
            int f10 = qVar.f();
            if (f10 == -1) {
                f10 = r2Var.f(qVar);
                qVar.b(f10);
            }
            y0(f10);
            r2Var.b(a2Var, this.f24132a);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int u() {
            return this.f24140e.remaining();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void x0(int i10) throws IOException {
            if (i10 >= 0) {
                y0(i10);
            } else {
                L(i10);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void y0(int i10) throws IOException {
            while ((i10 & (-128)) != 0) {
                try {
                    this.f24140e.put((byte) ((i10 & 127) | 128));
                    i10 >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f24140e.put((byte) i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d extends zzbn {

        /* renamed from: d, reason: collision with root package name */
        public final ByteBuffer f24142d;

        /* renamed from: e, reason: collision with root package name */
        public final ByteBuffer f24143e;

        /* renamed from: f, reason: collision with root package name */
        public final long f24144f;

        /* renamed from: g, reason: collision with root package name */
        public final long f24145g;

        /* renamed from: h, reason: collision with root package name */
        public final long f24146h;

        /* renamed from: i, reason: collision with root package name */
        public final long f24147i;

        /* renamed from: j, reason: collision with root package name */
        public long f24148j;

        public d(ByteBuffer byteBuffer) {
            super();
            this.f24142d = byteBuffer;
            this.f24143e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long o10 = p3.o(byteBuffer);
            this.f24144f = o10;
            long position = byteBuffer.position() + o10;
            this.f24145g = position;
            long limit = o10 + byteBuffer.limit();
            this.f24146h = limit;
            this.f24147i = limit - 10;
            this.f24148j = position;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void A0(int i10) throws IOException {
            this.f24143e.putInt((int) (this.f24148j - this.f24144f), i10);
            this.f24148j += 4;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void G(int i10, int i11) throws IOException {
            y0((i10 << 3) | i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void I(int i10, zzbb zzbbVar) throws IOException {
            G(1, 3);
            b0(2, i10);
            m(3, zzbbVar);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void J(int i10, a2 a2Var) throws IOException {
            G(1, 3);
            b0(2, i10);
            n(3, a2Var);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void K(int i10, boolean z10) throws IOException {
            G(i10, 0);
            g(z10 ? (byte) 1 : (byte) 0);
        }

        public final void K0(long j10) {
            this.f24143e.position((int) (j10 - this.f24144f));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void L(long j10) throws IOException {
            long j11;
            if (this.f24148j <= this.f24147i) {
                while (true) {
                    long j12 = j10 & (-128);
                    j11 = this.f24148j;
                    if (j12 == 0) {
                        break;
                    }
                    this.f24148j = j11 + 1;
                    p3.c(j11, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
            } else {
                while (true) {
                    j11 = this.f24148j;
                    if (j11 >= this.f24146h) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f24148j), Long.valueOf(this.f24146h), 1));
                    }
                    if ((j10 & (-128)) == 0) {
                        break;
                    }
                    this.f24148j = j11 + 1;
                    p3.c(j11, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
            }
            this.f24148j = 1 + j11;
            p3.c(j11, (byte) j10);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void M(a2 a2Var) throws IOException {
            y0(a2Var.g());
            a2Var.e(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void T(int i10, int i11) throws IOException {
            G(i10, 0);
            x0(i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void U(int i10, long j10) throws IOException {
            G(i10, 1);
            c0(j10);
        }

        @Override // com.google.android.gms.internal.clearcut.y
        public final void a(byte[] bArr, int i10, int i11) throws IOException {
            c(bArr, i10, i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b() {
            this.f24142d.position((int) (this.f24148j - this.f24144f));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b0(int i10, int i11) throws IOException {
            G(i10, 0);
            y0(i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c(byte[] bArr, int i10, int i11) throws IOException {
            if (bArr != null && i10 >= 0 && i11 >= 0 && bArr.length - i11 >= i10) {
                long j10 = i11;
                long j11 = this.f24146h - j10;
                long j12 = this.f24148j;
                if (j11 >= j12) {
                    p3.l(bArr, i10, j12, j10);
                    this.f24148j += j10;
                    return;
                }
            }
            Objects.requireNonNull(bArr, "value");
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f24148j), Long.valueOf(this.f24146h), Integer.valueOf(i11)));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c0(long j10) throws IOException {
            this.f24143e.putLong((int) (this.f24148j - this.f24144f), j10);
            this.f24148j += 8;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void g(byte b4) throws IOException {
            long j10 = this.f24148j;
            if (j10 >= this.f24146h) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f24148j), Long.valueOf(this.f24146h), 1));
            }
            this.f24148j = 1 + j10;
            p3.c(j10, b4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void i0(int i10, int i11) throws IOException {
            G(i10, 5);
            A0(i11);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void l(int i10, long j10) throws IOException {
            G(i10, 0);
            L(j10);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m(int i10, zzbb zzbbVar) throws IOException {
            G(i10, 2);
            q(zzbbVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m0(String str) throws IOException {
            long j10 = this.f24148j;
            try {
                int D0 = zzbn.D0(str.length() * 3);
                int D02 = zzbn.D0(str.length());
                if (D02 != D0) {
                    int a10 = r3.a(str);
                    y0(a10);
                    K0(this.f24148j);
                    r3.c(str, this.f24143e);
                    this.f24148j += a10;
                    return;
                }
                int i10 = ((int) (this.f24148j - this.f24144f)) + D02;
                this.f24143e.position(i10);
                r3.c(str, this.f24143e);
                int position = this.f24143e.position() - i10;
                y0(position);
                this.f24148j += position;
            } catch (zzfi e2) {
                this.f24148j = j10;
                K0(j10);
                s(str, e2);
            } catch (IllegalArgumentException e10) {
                throw new zzc(e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc(e11);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void n(int i10, a2 a2Var) throws IOException {
            G(i10, 2);
            M(a2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void o(int i10, a2 a2Var, r2 r2Var) throws IOException {
            G(i10, 2);
            r(a2Var, r2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void p(int i10, String str) throws IOException {
            G(i10, 2);
            m0(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void q(zzbb zzbbVar) throws IOException {
            y0(zzbbVar.size());
            zzbbVar.zza(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void r(a2 a2Var, r2 r2Var) throws IOException {
            q qVar = (q) a2Var;
            int f10 = qVar.f();
            if (f10 == -1) {
                f10 = r2Var.f(qVar);
                qVar.b(f10);
            }
            y0(f10);
            r2Var.b(a2Var, this.f24132a);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int u() {
            return (int) (this.f24146h - this.f24148j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void x0(int i10) throws IOException {
            if (i10 >= 0) {
                y0(i10);
            } else {
                L(i10);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void y0(int i10) throws IOException {
            long j10;
            if (this.f24148j <= this.f24147i) {
                while ((i10 & (-128)) != 0) {
                    long j11 = this.f24148j;
                    this.f24148j = j11 + 1;
                    p3.c(j11, (byte) ((i10 & 127) | 128));
                    i10 >>>= 7;
                }
                j10 = this.f24148j;
            } else {
                while (true) {
                    j10 = this.f24148j;
                    if (j10 >= this.f24146h) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f24148j), Long.valueOf(this.f24146h), 1));
                    }
                    if ((i10 & (-128)) == 0) {
                        break;
                    }
                    this.f24148j = j10 + 1;
                    p3.c(j10, (byte) ((i10 & 127) | 128));
                    i10 >>>= 7;
                }
            }
            this.f24148j = 1 + j10;
            p3.c(j10, (byte) i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class zzc extends IOException {
        public zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public zzc(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L11
                java.lang.String r3 = r0.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L16:
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzbn.zzc.<init>(java.lang.String):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public zzc(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L11
                java.lang.String r3 = r0.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L16:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzbn.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }

        public zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    public zzbn() {
    }

    public static int A(int i10, h1 h1Var) {
        return (B0(1) << 1) + n0(2, i10) + d(3, h1Var);
    }

    public static int B(int i10, a2 a2Var, r2 r2Var) {
        return B0(i10) + E(a2Var, r2Var);
    }

    public static int B0(int i10) {
        return D0(i10 << 3);
    }

    public static int C(int i10, String str) {
        return B0(i10) + q0(str);
    }

    public static int C0(int i10) {
        if (i10 >= 0) {
            return D0(i10);
        }
        return 10;
    }

    public static int D(zzbb zzbbVar) {
        int size = zzbbVar.size();
        return D0(size) + size;
    }

    public static int D0(int i10) {
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

    public static int E(a2 a2Var, r2 r2Var) {
        q qVar = (q) a2Var;
        int f10 = qVar.f();
        if (f10 == -1) {
            f10 = r2Var.f(qVar);
            qVar.b(f10);
        }
        return D0(f10) + f10;
    }

    public static int E0(int i10) {
        return D0(I0(i10));
    }

    public static int F(boolean z10) {
        return 1;
    }

    public static int F0(int i10) {
        return 4;
    }

    public static int G0(int i10) {
        return 4;
    }

    public static int H0(int i10) {
        return C0(i10);
    }

    public static int I0(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    @Deprecated
    public static int J0(int i10) {
        return D0(i10);
    }

    public static int N(int i10, zzbb zzbbVar) {
        int B0 = B0(i10);
        int size = zzbbVar.size();
        return B0 + D0(size) + size;
    }

    public static int O(int i10, a2 a2Var) {
        return B0(i10) + R(a2Var);
    }

    @Deprecated
    public static int P(int i10, a2 a2Var, r2 r2Var) {
        int B0 = B0(i10) << 1;
        q qVar = (q) a2Var;
        int f10 = qVar.f();
        if (f10 == -1) {
            f10 = r2Var.f(qVar);
            qVar.b(f10);
        }
        return B0 + f10;
    }

    public static int Q(int i10, boolean z10) {
        return B0(i10) + 1;
    }

    public static int R(a2 a2Var) {
        int g3 = a2Var.g();
        return D0(g3) + g3;
    }

    public static zzbn S(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int W(int i10, long j10) {
        return B0(i10) + h0(j10);
    }

    public static int X(int i10, zzbb zzbbVar) {
        return (B0(1) << 1) + n0(2, i10) + N(3, zzbbVar);
    }

    public static int Y(int i10, a2 a2Var) {
        return (B0(1) << 1) + n0(2, i10) + O(3, a2Var);
    }

    @Deprecated
    public static int Z(a2 a2Var) {
        return a2Var.g();
    }

    public static int a0(byte[] bArr) {
        int length = bArr.length;
        return D0(length) + length;
    }

    public static int d(int i10, h1 h1Var) {
        int B0 = B0(i10);
        int a10 = h1Var.a();
        return B0 + D0(a10) + a10;
    }

    public static int d0(int i10, long j10) {
        return B0(i10) + h0(j10);
    }

    public static int e(h1 h1Var) {
        int a10 = h1Var.a();
        return D0(a10) + a10;
    }

    public static int e0(long j10) {
        return h0(j10);
    }

    public static zzbn f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        }
        return p3.y() ? new d(byteBuffer) : new c(byteBuffer);
    }

    public static int g0(int i10, long j10) {
        return B0(i10) + h0(u0(j10));
    }

    public static int h0(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            i10 = 6;
            j10 >>>= 28;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static int j0(int i10, int i11) {
        return B0(i10) + C0(i11);
    }

    public static int k0(int i10, long j10) {
        return B0(i10) + 8;
    }

    public static int l0(long j10) {
        return h0(u0(j10));
    }

    public static int n0(int i10, int i11) {
        return B0(i10) + D0(i11);
    }

    public static int o0(int i10, long j10) {
        return B0(i10) + 8;
    }

    public static int p0(long j10) {
        return 8;
    }

    public static int q0(String str) {
        int length;
        try {
            length = r3.a(str);
        } catch (zzfi unused) {
            length = str.getBytes(z0.f24119a).length;
        }
        return D0(length) + length;
    }

    public static int r0(int i10, int i11) {
        return B0(i10) + D0(I0(i11));
    }

    public static int s0(long j10) {
        return 8;
    }

    public static int t0(int i10, int i11) {
        return B0(i10) + 4;
    }

    public static long u0(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static int v0(int i10, int i11) {
        return B0(i10) + 4;
    }

    public static int w(double d10) {
        return 8;
    }

    public static int w0(int i10, int i11) {
        return B0(i10) + C0(i11);
    }

    public static int x(float f10) {
        return 4;
    }

    public static int y(int i10, double d10) {
        return B0(i10) + 8;
    }

    public static int z(int i10, float f10) {
        return B0(i10) + 4;
    }

    public abstract void A0(int i10) throws IOException;

    public abstract void G(int i10, int i11) throws IOException;

    public final void H(int i10, long j10) throws IOException {
        l(i10, u0(j10));
    }

    public abstract void I(int i10, zzbb zzbbVar) throws IOException;

    public abstract void J(int i10, a2 a2Var) throws IOException;

    public abstract void K(int i10, boolean z10) throws IOException;

    public abstract void L(long j10) throws IOException;

    public abstract void M(a2 a2Var) throws IOException;

    public abstract void T(int i10, int i11) throws IOException;

    public abstract void U(int i10, long j10) throws IOException;

    public final void V(long j10) throws IOException {
        L(u0(j10));
    }

    public abstract void b() throws IOException;

    public abstract void b0(int i10, int i11) throws IOException;

    public abstract void c(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void c0(long j10) throws IOException;

    public final void f0(int i10, int i11) throws IOException {
        b0(i10, I0(i11));
    }

    public abstract void g(byte b4) throws IOException;

    public final void h(double d10) throws IOException {
        c0(Double.doubleToRawLongBits(d10));
    }

    public final void i(float f10) throws IOException {
        A0(Float.floatToRawIntBits(f10));
    }

    public abstract void i0(int i10, int i11) throws IOException;

    public final void j(int i10, double d10) throws IOException {
        U(i10, Double.doubleToRawLongBits(d10));
    }

    public final void k(int i10, float f10) throws IOException {
        i0(i10, Float.floatToRawIntBits(f10));
    }

    public abstract void l(int i10, long j10) throws IOException;

    public abstract void m(int i10, zzbb zzbbVar) throws IOException;

    public abstract void m0(String str) throws IOException;

    public abstract void n(int i10, a2 a2Var) throws IOException;

    public abstract void o(int i10, a2 a2Var, r2 r2Var) throws IOException;

    public abstract void p(int i10, String str) throws IOException;

    public abstract void q(zzbb zzbbVar) throws IOException;

    public abstract void r(a2 a2Var, r2 r2Var) throws IOException;

    public final void s(String str, zzfi zzfiVar) throws IOException {
        f24130b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzfiVar);
        byte[] bytes = str.getBytes(z0.f24119a);
        try {
            y0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zzc e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzc(e10);
        }
    }

    public final void t(boolean z10) throws IOException {
        g(z10 ? (byte) 1 : (byte) 0);
    }

    public abstract int u();

    public abstract void x0(int i10) throws IOException;

    public abstract void y0(int i10) throws IOException;

    public final void z0(int i10) throws IOException {
        y0(I0(i10));
    }
}
