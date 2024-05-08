package com.tencent.liteav.videoconsumer.decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class s {

    /* renamed from: b, reason: collision with root package name */
    public int f43992b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f43993c;

    /* renamed from: d, reason: collision with root package name */
    private int f43994d;

    /* renamed from: e, reason: collision with root package name */
    private int f43995e;

    /* renamed from: f, reason: collision with root package name */
    private final OutputStream f43996f;

    /* renamed from: h, reason: collision with root package name */
    private int f43998h;

    /* renamed from: a, reason: collision with root package name */
    public a f43991a = new a();

    /* renamed from: g, reason: collision with root package name */
    private int[] f43997g = new int[8];

    public s(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.f43993c = inputStream;
        this.f43996f = outputStream;
        this.f43994d = inputStream.read();
        this.f43995e = inputStream.read();
    }

    private int c(boolean z10) throws IOException {
        if (this.f43992b == 8) {
            f();
            if (this.f43994d == -1) {
                return -1;
            }
        }
        int i10 = this.f43994d;
        int i11 = this.f43992b;
        int i12 = (i10 >> (7 - i11)) & 1;
        this.f43992b = i11 + 1;
        if (z10 && this.f43996f != null) {
            f(i12);
        }
        return i12;
    }

    private long e(int i10) throws IOException {
        if (i10 > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = (j10 << 1) | c(true);
        }
        return j10;
    }

    private void f() throws IOException {
        this.f43994d = this.f43995e;
        this.f43995e = this.f43993c.read();
        this.f43992b = 0;
    }

    private int g() throws IOException {
        int i10 = 0;
        while (c(true) == 0) {
            i10++;
        }
        if (i10 <= 0) {
            return 0;
        }
        return (int) (((1 << i10) - 1) + e(i10));
    }

    private void h() throws IOException {
        int[] iArr = this.f43997g;
        this.f43996f.write(iArr[7] | (iArr[0] << 7) | (iArr[1] << 6) | (iArr[2] << 5) | (iArr[3] << 4) | (iArr[4] << 3) | (iArr[5] << 2) | (iArr[6] << 1));
    }

    public final boolean a(boolean z10) throws IOException {
        return c(z10) == 1;
    }

    public final void b(int i10) throws IOException {
        a(i10);
    }

    public final void d() throws IOException {
        int i10 = 0;
        while (c(true) == 0) {
            i10++;
        }
        if (i10 > 0) {
            a(i10);
        }
    }

    public final long a() throws IOException {
        long e2 = e(8);
        String.valueOf(e2);
        return e2;
    }

    public final int b() throws IOException {
        int i10 = 0;
        while (c(false) == 0) {
            i10++;
        }
        if (i10 <= 0) {
            return 0;
        }
        if (i10 > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = (j10 << 1) | c(false);
        }
        return (int) (((1 << i10) - 1) + j10);
    }

    public final void d(int i10) throws IOException {
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= 15) {
                break;
            }
            int i14 = (1 << i12) + i13;
            if (i10 < i14) {
                i11 = i12;
                break;
            } else {
                i12++;
                i13 = i14;
            }
        }
        a(0L, i11);
        f(1);
        a(i10 - i13, i11);
    }

    public final void e() throws IOException {
        f(1);
        a(0L, 8 - this.f43998h);
        for (int i10 = this.f43998h; i10 < 8; i10++) {
            this.f43997g[i10] = 0;
        }
        this.f43998h = 0;
        h();
    }

    private void f(int i10) throws IOException {
        if (this.f43998h == 8) {
            this.f43998h = 0;
            h();
        }
        int[] iArr = this.f43997g;
        int i11 = this.f43998h;
        this.f43998h = i11 + 1;
        iArr[i11] = i10;
    }

    public final void a(int i10) throws IOException {
        if (i10 > 64) {
            throw new IllegalArgumentException("Can not skip more then 64 bit");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            c(true);
        }
    }

    public final void b(boolean z10) throws IOException {
        f(z10 ? 1 : 0);
    }

    private void a(long j10, int i10) throws IOException {
        for (int i11 = 0; i11 < i10; i11++) {
            f(((int) (j10 >> ((i10 - i11) - 1))) & 1);
        }
    }

    public final int c() throws IOException {
        int g3 = g();
        String.valueOf(g3);
        return g3;
    }

    public final void c(int i10) throws IOException {
        int[] iArr = new int[i10];
        int i11 = 8;
        int i12 = 8;
        for (int i13 = 0; i13 < i10; i13++) {
            if (i11 != 0) {
                int g3 = g();
                int i14 = ((g3 >> 1) + (g3 & 1)) * ((r4 << 1) - 1);
                String.valueOf(i14);
                i11 = ((i14 + i12) + 256) % 256;
            }
            if (i11 != 0) {
                i12 = i11;
            }
            iArr[i13] = i12;
            i12 = iArr[i13];
        }
    }
}
