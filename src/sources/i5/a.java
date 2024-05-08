package i5;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.zip.ZipUtils;

/* compiled from: DefaultEbmlReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f49722a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<b> f49723b = new ArrayDeque<>();

    /* renamed from: c, reason: collision with root package name */
    public final g f49724c = new g();

    /* renamed from: d, reason: collision with root package name */
    public i5.b f49725d;

    /* renamed from: e, reason: collision with root package name */
    public int f49726e;

    /* renamed from: f, reason: collision with root package name */
    public int f49727f;

    /* renamed from: g, reason: collision with root package name */
    public long f49728g;

    /* compiled from: DefaultEbmlReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f49729a;

        /* renamed from: b, reason: collision with root package name */
        public final long f49730b;

        public b(int i10, long j10) {
            this.f49729a = i10;
            this.f49730b = j10;
        }
    }

    public static String f(d5.d dVar, int i10) throws IOException {
        if (i10 == 0) {
            return "";
        }
        byte[] bArr = new byte[i10];
        dVar.readFully(bArr, 0, i10);
        while (i10 > 0 && bArr[i10 - 1] == 0) {
            i10--;
        }
        return new String(bArr, 0, i10);
    }

    @Override // i5.c
    public boolean a(d5.d dVar) throws IOException {
        com.google.android.exoplayer2.util.a.i(this.f49725d);
        while (true) {
            b peek = this.f49723b.peek();
            if (peek != null && dVar.getPosition() >= peek.f49730b) {
                this.f49725d.a(this.f49723b.pop().f49729a);
                return true;
            }
            if (this.f49726e == 0) {
                long d10 = this.f49724c.d(dVar, true, false, 4);
                if (d10 == -2) {
                    d10 = c(dVar);
                }
                if (d10 == -1) {
                    return false;
                }
                this.f49727f = (int) d10;
                this.f49726e = 1;
            }
            if (this.f49726e == 1) {
                this.f49728g = this.f49724c.d(dVar, false, true, 8);
                this.f49726e = 2;
            }
            int g3 = this.f49725d.g(this.f49727f);
            if (g3 != 0) {
                if (g3 == 1) {
                    long position = dVar.getPosition();
                    this.f49723b.push(new b(this.f49727f, this.f49728g + position));
                    this.f49725d.f(this.f49727f, position, this.f49728g);
                    this.f49726e = 0;
                    return true;
                }
                if (g3 == 2) {
                    long j10 = this.f49728g;
                    if (j10 <= 8) {
                        this.f49725d.d(this.f49727f, e(dVar, (int) j10));
                        this.f49726e = 0;
                        return true;
                    }
                    StringBuilder sb2 = new StringBuilder(42);
                    sb2.append("Invalid integer size: ");
                    sb2.append(j10);
                    throw ParserException.createForMalformedContainer(sb2.toString(), null);
                }
                if (g3 == 3) {
                    long j11 = this.f49728g;
                    if (j11 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
                        this.f49725d.e(this.f49727f, f(dVar, (int) j11));
                        this.f49726e = 0;
                        return true;
                    }
                    StringBuilder sb3 = new StringBuilder(41);
                    sb3.append("String element size: ");
                    sb3.append(j11);
                    throw ParserException.createForMalformedContainer(sb3.toString(), null);
                }
                if (g3 == 4) {
                    this.f49725d.c(this.f49727f, (int) this.f49728g, dVar);
                    this.f49726e = 0;
                    return true;
                }
                if (g3 == 5) {
                    long j12 = this.f49728g;
                    if (j12 != 4 && j12 != 8) {
                        StringBuilder sb4 = new StringBuilder(40);
                        sb4.append("Invalid float size: ");
                        sb4.append(j12);
                        throw ParserException.createForMalformedContainer(sb4.toString(), null);
                    }
                    this.f49725d.b(this.f49727f, d(dVar, (int) j12));
                    this.f49726e = 0;
                    return true;
                }
                StringBuilder sb5 = new StringBuilder(32);
                sb5.append("Invalid element type ");
                sb5.append(g3);
                throw ParserException.createForMalformedContainer(sb5.toString(), null);
            }
            dVar.r((int) this.f49728g);
            this.f49726e = 0;
        }
    }

    @Override // i5.c
    public void b(i5.b bVar) {
        this.f49725d = bVar;
    }

    public final long c(d5.d dVar) throws IOException {
        dVar.m();
        while (true) {
            dVar.j(this.f49722a, 0, 4);
            int c4 = g.c(this.f49722a[0]);
            if (c4 != -1 && c4 <= 4) {
                int a10 = (int) g.a(this.f49722a, c4, false);
                if (this.f49725d.h(a10)) {
                    dVar.r(c4);
                    return a10;
                }
            }
            dVar.r(1);
        }
    }

    public final double d(d5.d dVar, int i10) throws IOException {
        long e2 = e(dVar, i10);
        if (i10 == 4) {
            return Float.intBitsToFloat((int) e2);
        }
        return Double.longBitsToDouble(e2);
    }

    public final long e(d5.d dVar, int i10) throws IOException {
        dVar.readFully(this.f49722a, 0, i10);
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = (j10 << 8) | (this.f49722a[i11] & 255);
        }
        return j10;
    }

    @Override // i5.c
    public void reset() {
        this.f49726e = 0;
        this.f49723b.clear();
        this.f49724c.e();
    }
}
