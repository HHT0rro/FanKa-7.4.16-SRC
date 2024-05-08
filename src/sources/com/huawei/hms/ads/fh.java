package com.huawei.hms.ads;

import android.graphics.Bitmap;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fh {
    private static final int B = 1;
    private static final int C = 2;
    private static final int D = 33;
    private static final int F = 44;
    private static final int I = 4096;
    private static final int L = 249;
    private static final int S = 3;
    private static final int Z = 0;

    /* renamed from: a, reason: collision with root package name */
    private static final long f29172a = 62914560;

    /* renamed from: b, reason: collision with root package name */
    private static final String f29173b = "fh";
    public int Code;
    private int[] E;
    private int G;
    private Bitmap J;
    private int[] K;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int T;
    private int U;
    public int V;
    private int W;

    /* renamed from: c, reason: collision with root package name */
    private final int f29174c;

    /* renamed from: d, reason: collision with root package name */
    private InputStream f29175d;

    /* renamed from: j, reason: collision with root package name */
    private boolean f29181j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f29182k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f29183l;

    /* renamed from: m, reason: collision with root package name */
    private short[] f29184m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f29185n;

    /* renamed from: p, reason: collision with root package name */
    private byte[] f29187p;

    /* renamed from: q, reason: collision with root package name */
    private byte[] f29188q;

    /* renamed from: r, reason: collision with root package name */
    private int f29189r;

    /* renamed from: v, reason: collision with root package name */
    private int f29193v;

    /* renamed from: w, reason: collision with root package name */
    private int f29194w;

    /* renamed from: x, reason: collision with root package name */
    private int f29195x;

    /* renamed from: y, reason: collision with root package name */
    private int f29196y;

    /* renamed from: e, reason: collision with root package name */
    private final Object f29176e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private final Object f29177f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private boolean f29178g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f29179h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f29180i = false;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f29186o = new byte[512];

    /* renamed from: s, reason: collision with root package name */
    private int f29190s = 100;

    /* renamed from: t, reason: collision with root package name */
    private int f29191t = 0;

    /* renamed from: u, reason: collision with root package name */
    private int f29192u = 0;

    /* renamed from: z, reason: collision with root package name */
    private int[] f29197z = null;
    private int[] A = null;
    private int H = 0;
    private int M = 0;
    private int X = 0;
    private int[] Y = null;

    public fh(InputStream inputStream, int i10) {
        this.f29175d = inputStream;
        this.f29174c = i10;
        Z();
    }

    private void B() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < 6; i10++) {
            stringBuffer.append((char) C());
        }
        if (!stringBuffer.toString().startsWith("GIF")) {
            this.f29192u = 1;
            return;
        }
        S();
        if (!this.f29181j || D()) {
            return;
        }
        int[] Code = Code(this.f29193v);
        this.f29197z = Code;
        this.f29196y = Code[this.f29195x];
    }

    private int C() {
        try {
            return this.f29175d.read();
        } catch (Exception unused) {
            this.f29192u = 1;
            return 0;
        }
    }

    private Bitmap Code(int[] iArr, int i10, int i11, Bitmap bitmap) {
        if (bitmap == null) {
            Bitmap.Config config = com.huawei.openalliance.ad.utils.v.V() > f29172a ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (gl.Code()) {
                gl.Code(f29173b, "create image with config %s", config);
            }
            bitmap = Bitmap.createBitmap(i10, i11, config);
        }
        bitmap.setPixels(iArr, 0, i10, 0, 0, i10, i11);
        return bitmap;
    }

    private void Code(boolean z10) {
        synchronized (this.f29177f) {
            this.f29179h = z10;
        }
    }

    private int[] Code(int i10) {
        int i11;
        int[] iArr = new int[256];
        int i12 = i10 * 3;
        byte[] bArr = new byte[i12];
        try {
            i11 = this.f29175d.read(bArr);
        } catch (Exception unused) {
            gl.I(f29173b, "read color table fail");
            i11 = 0;
        }
        if (i11 < i12) {
            this.f29192u = 1;
        } else {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = i13 + 1;
                int i16 = i15 + 1;
                iArr[i14] = ((bArr[i13] & 255) << 16) | (-16777216) | ((bArr[i15] & 255) << 8) | (bArr[i16] & 255);
                i13 = i16 + 1;
            }
        }
        return iArr;
    }

    private boolean D() {
        return this.f29192u != 0;
    }

    private int F() {
        return C() | (C() << 8);
    }

    private fj L() {
        int a10;
        fj fjVar = null;
        try {
            a10 = a();
        } catch (Exception | StackOverflowError unused) {
            this.f29192u = 1;
            gl.I(f29173b, "read image error");
        } catch (OutOfMemoryError unused2) {
            this.f29192u = 1;
            gl.I(f29173b, "run out of memory");
            f();
        }
        if (D()) {
            return null;
        }
        b();
        d();
        if (D()) {
            return null;
        }
        e();
        if (D()) {
            return null;
        }
        Bitmap bitmap = this.J;
        if (bitmap != null) {
            int i10 = this.M + 1;
            this.M = i10;
            fjVar = new fj(i10, bitmap, this.f29190s);
        }
        if (this.f29180i) {
            this.E[this.G] = a10;
        }
        g();
        return fjVar;
    }

    private void S() {
        this.Code = F();
        this.V = F();
        this.f29181j = (C() & 128) != 0;
        this.f29193v = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.f29195x = C();
        C();
    }

    private void V(int i10) {
        byte[] bArr = this.f29188q;
        if (bArr == null || bArr.length < i10) {
            this.f29188q = new byte[i10];
        }
        if (this.f29184m == null) {
            this.f29184m = new short[4096];
        }
        if (this.f29185n == null) {
            this.f29185n = new byte[4096];
        }
        if (this.f29187p == null) {
            this.f29187p = new byte[4097];
        }
    }

    private void Z() {
        if (this.f29175d == null) {
            Code(true);
            return;
        }
        B();
        if (D()) {
            Code(true);
            V();
        }
    }

    private int a() {
        int[] iArr;
        this.N = F();
        this.O = F();
        this.P = F();
        this.Q = F();
        int C2 = C();
        int i10 = 0;
        this.f29182k = (C2 & 128) != 0;
        this.f29183l = (C2 & 64) != 0;
        int pow = (int) Math.pow(2.0d, (C2 & 7) + 1);
        this.f29194w = pow;
        if (this.f29182k) {
            int[] Code = Code(pow);
            this.A = Code;
            this.E = Code;
        } else {
            this.E = this.f29197z;
            if (this.f29195x == this.G) {
                this.f29196y = 0;
            }
        }
        if (this.f29180i && (iArr = this.E) != null && iArr.length > 0) {
            int length = iArr.length;
            int i11 = this.G;
            if (length > i11) {
                int i12 = iArr[i11];
                iArr[i11] = 0;
                i10 = i12;
            }
        }
        if (this.E == null) {
            this.f29192u = 1;
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18, types: [short] */
    /* JADX WARN: Type inference failed for: r2v20 */
    private void b() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        short s2;
        int i15 = this.P * this.Q;
        V(i15);
        int C2 = C();
        int i16 = 1 << C2;
        int i17 = i16 + 1;
        int i18 = i16 + 2;
        int i19 = C2 + 1;
        int i20 = (1 << i19) - 1;
        for (int i21 = 0; i21 < i16; i21++) {
            this.f29184m[i21] = 0;
            this.f29185n[i21] = (byte) i21;
        }
        int i22 = i19;
        int i23 = i18;
        int i24 = i20;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = -1;
        int i32 = 0;
        int i33 = 0;
        while (i25 < i15) {
            if (i26 != 0) {
                i10 = i19;
                i11 = i16;
                i12 = i17;
                i13 = i18;
                i14 = i31;
            } else if (i27 >= i22) {
                int i34 = i28 & i24;
                i28 >>= i22;
                i27 -= i22;
                if (i34 > i23 || i34 == i17) {
                    break;
                }
                if (i34 == i16) {
                    i22 = i19;
                    i23 = i18;
                    i24 = i20;
                    i31 = -1;
                } else {
                    i10 = i19;
                    int i35 = i31;
                    if (i35 == -1) {
                        this.f29187p[i26] = this.f29185n[i34];
                        i31 = i34;
                        i26++;
                        i19 = i10;
                        i32 = i31;
                    } else {
                        if (i34 == i23) {
                            i12 = i17;
                            this.f29187p[i26] = (byte) i32;
                            s2 = i35;
                            i26++;
                        } else {
                            i12 = i17;
                            s2 = i34;
                        }
                        while (s2 > i16) {
                            this.f29187p[i26] = this.f29185n[s2];
                            s2 = this.f29184m[s2];
                            i26++;
                            i16 = i16;
                        }
                        i11 = i16;
                        byte[] bArr = this.f29185n;
                        int i36 = bArr[s2] & 255;
                        if (i23 >= 4096) {
                            break;
                        }
                        int i37 = i26 + 1;
                        i13 = i18;
                        byte b4 = (byte) i36;
                        this.f29187p[i26] = b4;
                        this.f29184m[i23] = (short) i35;
                        bArr[i23] = b4;
                        i23++;
                        if ((i23 & i24) == 0 && i23 < 4096) {
                            i22++;
                            i24 += i23;
                        }
                        i32 = i36;
                        i14 = i34;
                        i26 = i37;
                    }
                }
            } else {
                if (i29 == 0) {
                    i29 = h();
                    if (i29 <= 0) {
                        break;
                    } else {
                        i30 = 0;
                    }
                }
                i28 += (this.f29186o[i30] & 255) << i27;
                i27 += 8;
                i30++;
                i29--;
            }
            i26--;
            this.f29188q[i33] = this.f29187p[i26];
            i25++;
            i31 = i14;
            i33++;
            i19 = i10;
            i16 = i11;
            i17 = i12;
            i18 = i13;
        }
        for (int i38 = i33; i38 < i15; i38++) {
            this.f29188q[i38] = 0;
        }
    }

    private void c() {
        C();
        int C2 = C();
        int i10 = (C2 & 28) >> 2;
        this.f29191t = i10;
        if (i10 == 0) {
            this.f29191t = 1;
        }
        this.f29180i = (C2 & 1) != 0;
        int F2 = F() * 10;
        this.f29190s = F2;
        int i11 = this.f29174c;
        if (i11 > F2) {
            this.f29190s = i11;
        }
        this.G = C();
        C();
    }

    private void d() {
        do {
            h();
            if (this.X <= 0) {
                return;
            }
        } while (!D());
    }

    private void e() {
        int i10;
        try {
            i();
            int i11 = 8;
            int i12 = 0;
            int i13 = 0;
            int i14 = 1;
            while (true) {
                int i15 = this.Q;
                if (i12 >= i15) {
                    this.J = Code(this.Y, this.Code, this.V, this.J);
                    return;
                }
                if (this.f29183l) {
                    if (i13 >= i15) {
                        i14++;
                        if (i14 == 2) {
                            i13 = 4;
                        } else if (i14 == 3) {
                            i11 = 4;
                            i13 = 2;
                        } else if (i14 == 4) {
                            i11 = 2;
                            i13 = 1;
                        }
                    }
                    i10 = i13 + i11;
                } else {
                    i10 = i13;
                    i13 = i12;
                }
                int i16 = i13 + this.O;
                if (i16 < this.V) {
                    int i17 = this.Code;
                    int i18 = i16 * i17;
                    int i19 = this.N + i18;
                    int i20 = this.P;
                    int i21 = i19 + i20;
                    if (i18 + i17 < i21) {
                        i21 = i18 + i17;
                    }
                    int i22 = i20 * i12;
                    while (i19 < i21) {
                        int i23 = i22 + 1;
                        int i24 = this.E[this.f29188q[i22] & 255];
                        if (i24 != 0) {
                            this.Y[i19] = i24;
                        }
                        i19++;
                        i22 = i23;
                    }
                }
                i12++;
                i13 = i10;
            }
        } catch (Exception | StackOverflowError unused) {
            this.f29192u = 1;
            gl.I(f29173b, "set pixel error");
        }
    }

    private void f() {
        this.f29192u = 3;
    }

    private void g() {
        this.H = this.f29191t;
        this.R = this.N;
        this.T = this.O;
        this.U = this.P;
        this.W = this.Q;
        this.f29189r = this.f29196y;
        this.K = this.Y;
        this.f29180i = false;
        this.f29191t = 0;
        this.A = null;
        this.f29190s = this.f29174c;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int h() {
        /*
            r4 = this;
            int r0 = r4.C()
            r4.X = r0
            r1 = 0
            if (r0 <= 0) goto L2f
        L9:
            int r0 = r4.X     // Catch: java.lang.Exception -> L1c java.io.IOException -> L21
            if (r1 >= r0) goto L28
            java.io.InputStream r2 = r4.f29175d     // Catch: java.lang.Exception -> L1c java.io.IOException -> L21
            byte[] r3 = r4.f29186o     // Catch: java.lang.Exception -> L1c java.io.IOException -> L21
            int r0 = r0 - r1
            int r0 = r2.read(r3, r1, r0)     // Catch: java.lang.Exception -> L1c java.io.IOException -> L21
            r2 = -1
            if (r0 != r2) goto L1a
            goto L28
        L1a:
            int r1 = r1 + r0
            goto L9
        L1c:
            java.lang.String r0 = com.huawei.hms.ads.fh.f29173b
            java.lang.String r2 = "read block fail"
            goto L25
        L21:
            java.lang.String r0 = com.huawei.hms.ads.fh.f29173b
            java.lang.String r2 = "read block IOException"
        L25:
            com.huawei.hms.ads.gl.I(r0, r2)
        L28:
            int r0 = r4.X
            if (r1 >= r0) goto L2f
            r0 = 1
            r4.f29192u = r0
        L2f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.fh.h():int");
    }

    private void i() {
        if (this.Y == null) {
            this.Y = new int[this.Code * this.V];
        }
        int i10 = this.H;
        if (i10 > 0) {
            if (3 == i10) {
                this.K = null;
            }
            int[] iArr = this.K;
            if (iArr != null) {
                this.Y = iArr;
                if (2 == i10) {
                    int i11 = !this.f29180i ? this.f29189r : 0;
                    for (int i12 = 0; i12 < this.W; i12++) {
                        int i13 = ((this.T + i12) * this.Code) + this.R;
                        int i14 = this.U + i13;
                        while (i13 < i14) {
                            this.Y[i13] = i11;
                            i13++;
                        }
                    }
                }
            }
        }
    }

    private boolean j() {
        boolean z10;
        synchronized (this.f29177f) {
            z10 = this.f29179h;
        }
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0050, code lost:
    
        if (j() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0052, code lost:
    
        V();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0055, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.ads.fj Code() {
        /*
            r4 = this;
            boolean r0 = r4.I()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lc
            r4.Code(r2)
            return r1
        Lc:
            boolean r0 = r4.j()
            if (r0 != 0) goto L4c
            boolean r0 = r4.D()
            if (r0 == 0) goto L1c
            r4.Code(r2)
            goto L4c
        L1c:
            int r0 = r4.C()
            if (r0 == 0) goto Lc
            r3 = 33
            if (r0 == r3) goto L3c
            r3 = 44
            if (r0 == r3) goto L35
            r3 = 59
            if (r0 == r3) goto L31
            r4.f29192u = r2
            goto Lc
        L31:
            r4.Code(r2)
            goto Lc
        L35:
            com.huawei.hms.ads.fj r0 = r4.L()
            if (r0 == 0) goto Lc
            return r0
        L3c:
            int r0 = r4.C()
            r3 = 249(0xf9, float:3.49E-43)
            if (r3 != r0) goto L48
            r4.c()
            goto Lc
        L48:
            r4.d()
            goto Lc
        L4c:
            boolean r0 = r4.j()
            if (r0 == 0) goto L55
            r4.V()
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.fh.Code():com.huawei.hms.ads.fj");
    }

    public boolean I() {
        boolean z10;
        synchronized (this.f29176e) {
            z10 = this.f29178g;
        }
        return z10;
    }

    public void V() {
        synchronized (this.f29176e) {
            if (!this.f29178g) {
                this.f29178g = true;
                com.huawei.openalliance.ad.utils.at.Code((Closeable) this.f29175d);
            }
        }
    }
}
