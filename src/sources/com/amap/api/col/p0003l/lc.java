package com.amap.api.col.p0003l;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* compiled from: FlatBufferBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class lc {

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f6866c = Charset.forName("UTF-8");

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ boolean f6867p = true;

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f6868a;

    /* renamed from: b, reason: collision with root package name */
    public int f6869b;

    /* renamed from: d, reason: collision with root package name */
    public int f6870d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f6871e;

    /* renamed from: f, reason: collision with root package name */
    public int f6872f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6873g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6874h;

    /* renamed from: i, reason: collision with root package name */
    public int f6875i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f6876j;

    /* renamed from: k, reason: collision with root package name */
    public int f6877k;

    /* renamed from: l, reason: collision with root package name */
    public int f6878l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6879m;

    /* renamed from: n, reason: collision with root package name */
    public CharsetEncoder f6880n;

    /* renamed from: o, reason: collision with root package name */
    public ByteBuffer f6881o;

    private lc() {
        this.f6870d = 1;
        this.f6871e = null;
        this.f6872f = 0;
        this.f6873g = false;
        this.f6874h = false;
        this.f6876j = new int[16];
        this.f6877k = 0;
        this.f6878l = 0;
        this.f6879m = false;
        this.f6880n = f6866c.newEncoder();
        this.f6869b = 1024;
        this.f6868a = d(1024);
    }

    private static ByteBuffer b(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) == 0) {
            int i10 = capacity << 1;
            byteBuffer.position(0);
            ByteBuffer d10 = d(i10);
            d10.position(i10 - capacity);
            d10.put(byteBuffer);
            return d10;
        }
        throw new AssertionError((Object) "FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    private void c(int i10, int i11) {
        if (i10 > this.f6870d) {
            this.f6870d = i10;
        }
        int i12 = ((~((this.f6868a.capacity() - this.f6869b) + i11)) + 1) & (i10 - 1);
        while (this.f6869b < i12 + i10 + i11) {
            int capacity = this.f6868a.capacity();
            ByteBuffer b4 = b(this.f6868a);
            this.f6868a = b4;
            this.f6869b += b4.capacity() - capacity;
        }
        e(i12);
    }

    private static ByteBuffer d(int i10) {
        ByteBuffer allocate = ByteBuffer.allocate(i10);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private void e(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            ByteBuffer byteBuffer = this.f6868a;
            int i12 = this.f6869b - 1;
            this.f6869b = i12;
            byteBuffer.put(i12, (byte) 0);
        }
    }

    private void f(int i10) {
        ByteBuffer byteBuffer = this.f6868a;
        int i11 = this.f6869b - 4;
        this.f6869b = i11;
        byteBuffer.putInt(i11, i10);
    }

    private void g(int i10) {
        c(4, 0);
        f(i10);
    }

    private void h(int i10) {
        this.f6871e[i10] = d();
    }

    public final lc a(ByteBuffer byteBuffer) {
        this.f6868a = byteBuffer;
        byteBuffer.clear();
        this.f6868a.order(ByteOrder.LITTLE_ENDIAN);
        this.f6870d = 1;
        this.f6869b = this.f6868a.capacity();
        this.f6872f = 0;
        this.f6873g = false;
        this.f6874h = false;
        this.f6875i = 0;
        this.f6877k = 0;
        this.f6878l = 0;
        return this;
    }

    private void e() {
        if (!this.f6874h) {
            throw new AssertionError((Object) "FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    private void f() {
        if (this.f6873g) {
            throw new AssertionError((Object) "FlatBuffers: object serialization must not be nested.");
        }
    }

    private int d() {
        return this.f6868a.capacity() - this.f6869b;
    }

    private byte[] d(int i10, int i11) {
        e();
        byte[] bArr = new byte[i11];
        this.f6868a.position(i10);
        this.f6868a.get(bArr);
        return bArr;
    }

    private void b(boolean z10) {
        ByteBuffer byteBuffer = this.f6868a;
        int i10 = this.f6869b - 1;
        this.f6869b = i10;
        byteBuffer.put(i10, z10 ? (byte) 1 : (byte) 0);
    }

    private void b(byte b4) {
        ByteBuffer byteBuffer = this.f6868a;
        int i10 = this.f6869b - 1;
        this.f6869b = i10;
        byteBuffer.put(i10, b4);
    }

    private void c(boolean z10) {
        c(1, 0);
        b(z10);
    }

    private void b(short s2) {
        c(2, 0);
        a(s2);
    }

    private int c(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        a((byte) 0);
        a(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f6868a;
        int i10 = this.f6869b - remaining;
        this.f6869b = i10;
        byteBuffer2.position(i10);
        this.f6868a.put(byteBuffer);
        return a();
    }

    private void b(long j10) {
        c(8, 0);
        a(j10);
    }

    public final void b(int i10) {
        f();
        int[] iArr = this.f6871e;
        if (iArr == null || iArr.length < i10) {
            this.f6871e = new int[i10];
        }
        this.f6872f = i10;
        Arrays.fill(this.f6871e, 0, i10, 0);
        this.f6873g = true;
        this.f6875i = d();
    }

    private void a(short s2) {
        ByteBuffer byteBuffer = this.f6868a;
        int i10 = this.f6869b - 2;
        this.f6869b = i10;
        byteBuffer.putShort(i10, s2);
    }

    private void a(long j10) {
        ByteBuffer byteBuffer = this.f6868a;
        int i10 = this.f6869b - 8;
        this.f6869b = i10;
        byteBuffer.putLong(i10, j10);
    }

    public lc(ByteBuffer byteBuffer) {
        this.f6870d = 1;
        this.f6871e = null;
        this.f6872f = 0;
        this.f6873g = false;
        this.f6874h = false;
        this.f6876j = new int[16];
        this.f6877k = 0;
        this.f6878l = 0;
        this.f6879m = false;
        this.f6880n = f6866c.newEncoder();
        a(byteBuffer);
    }

    public final void a(byte b4) {
        c(1, 0);
        b(b4);
    }

    public final void a(int i10) {
        c(4, 0);
        if (!f6867p && i10 > d()) {
            throw new AssertionError();
        }
        f((d() - i10) + 4);
    }

    public final void c(int i10) {
        c(this.f6870d, 4);
        a(i10);
        this.f6868a.position(this.f6869b);
        this.f6874h = true;
    }

    public final void b(int i10, int i11) {
        if (this.f6879m || i11 != 0) {
            a(i11);
            h(i10);
        }
    }

    public final int b() {
        int i10;
        int i11;
        if (this.f6871e != null && this.f6873g) {
            g(0);
            int d10 = d();
            for (int i12 = this.f6872f - 1; i12 >= 0; i12--) {
                int[] iArr = this.f6871e;
                b((short) (iArr[i12] != 0 ? d10 - iArr[i12] : 0));
            }
            b((short) (d10 - this.f6875i));
            b((short) ((this.f6872f + 2) * 2));
            int i13 = 0;
            loop1: while (true) {
                if (i13 >= this.f6877k) {
                    i10 = 0;
                    break;
                }
                int capacity = this.f6868a.capacity() - this.f6876j[i13];
                int i14 = this.f6869b;
                short s2 = this.f6868a.getShort(capacity);
                if (s2 == this.f6868a.getShort(i14)) {
                    while (i11 < s2) {
                        i11 = this.f6868a.getShort(capacity + i11) == this.f6868a.getShort(i14 + i11) ? i11 + 2 : 2;
                    }
                    i10 = this.f6876j[i13];
                    break loop1;
                }
                i13++;
            }
            if (i10 != 0) {
                int capacity2 = this.f6868a.capacity() - d10;
                this.f6869b = capacity2;
                this.f6868a.putInt(capacity2, i10 - d10);
            } else {
                int i15 = this.f6877k;
                int[] iArr2 = this.f6876j;
                if (i15 == iArr2.length) {
                    this.f6876j = Arrays.copyOf(iArr2, i15 * 2);
                }
                int[] iArr3 = this.f6876j;
                int i16 = this.f6877k;
                this.f6877k = i16 + 1;
                iArr3[i16] = d();
                ByteBuffer byteBuffer = this.f6868a;
                byteBuffer.putInt(byteBuffer.capacity() - d10, d() - d10);
            }
            this.f6873g = false;
            return d10;
        }
        throw new AssertionError((Object) "FlatBuffers: endObject called without startObject");
    }

    public final void a(int i10, int i11, int i12) {
        f();
        this.f6878l = i11;
        int i13 = i10 * i11;
        c(4, i13);
        c(i12, i13);
        this.f6873g = true;
    }

    public final byte[] c() {
        return d(this.f6869b, this.f6868a.capacity() - this.f6869b);
    }

    public final int a() {
        if (this.f6873g) {
            this.f6873g = false;
            f(this.f6878l);
            return d();
        }
        throw new AssertionError((Object) "FlatBuffers: endVector called without startVector");
    }

    public int a(CharSequence charSequence) {
        int length = (int) (charSequence.length() * this.f6880n.maxBytesPerChar());
        ByteBuffer byteBuffer = this.f6881o;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.f6881o = ByteBuffer.allocate(Math.max(128, length));
        }
        this.f6881o.clear();
        CoderResult encode = this.f6880n.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.f6881o, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e2) {
                throw new Error(e2);
            }
        }
        this.f6881o.flip();
        return c(this.f6881o);
    }

    public final void a(boolean z10) {
        if (this.f6879m || z10) {
            c(z10);
            h(0);
        }
    }

    public final void a(int i10, byte b4) {
        if (this.f6879m || b4 != 0) {
            a(b4);
            h(i10);
        }
    }

    public final void a(int i10, short s2) {
        if (this.f6879m || s2 != 0) {
            b(s2);
            h(i10);
        }
    }

    public final void a(int i10, int i11) {
        if (this.f6879m || i11 != 0) {
            g(i11);
            h(i10);
        }
    }

    public final void a(int i10, long j10) {
        if (this.f6879m || j10 != 0) {
            b(j10);
            h(i10);
        }
    }
}
