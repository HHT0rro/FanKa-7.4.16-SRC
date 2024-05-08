package com.huawei.uikit.hwdotspageindicator.widget;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static final int f35171a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f35172b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f35173c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f35174d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f35175e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f35176f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f35177g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static final int f35178h = 3;

    /* renamed from: i, reason: collision with root package name */
    public static final int f35179i = 3;

    /* renamed from: j, reason: collision with root package name */
    public static final float f35180j = 2.0f;

    /* renamed from: k, reason: collision with root package name */
    public static final float f35181k = 8.0f;
    public boolean A;
    public float[][] E;
    public float[][] F;
    public float[][] G;
    public float[][] H;
    public ConcurrentHashMap<Integer, Float> I;

    /* renamed from: l, reason: collision with root package name */
    public int f35182l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f35183m;

    /* renamed from: n, reason: collision with root package name */
    public int f35184n;

    /* renamed from: o, reason: collision with root package name */
    public int f35185o;

    /* renamed from: p, reason: collision with root package name */
    public int f35186p;

    /* renamed from: q, reason: collision with root package name */
    public int f35187q;

    /* renamed from: r, reason: collision with root package name */
    public float[] f35188r;

    /* renamed from: s, reason: collision with root package name */
    public float f35189s;

    /* renamed from: t, reason: collision with root package name */
    public float f35190t;

    /* renamed from: u, reason: collision with root package name */
    public float f35191u;

    /* renamed from: v, reason: collision with root package name */
    public float f35192v;

    /* renamed from: w, reason: collision with root package name */
    public float f35193w;

    /* renamed from: x, reason: collision with root package name */
    public float f35194x;

    /* renamed from: y, reason: collision with root package name */
    public int f35195y;

    /* renamed from: z, reason: collision with root package name */
    public int f35196z;
    public int D = -1;
    public RectF B = new RectF();
    public RectF C = new RectF();

    public int A() {
        return this.D;
    }

    public ConcurrentHashMap<Integer, Float> B() {
        return this.I;
    }

    public boolean C() {
        return this.A;
    }

    public boolean D() {
        return this.f35183m;
    }

    public boolean E() {
        ConcurrentHashMap<Integer, Float> concurrentHashMap = this.I;
        return concurrentHashMap == null || concurrentHashMap.size() == 0;
    }

    public void a(@NonNull float[] fArr) {
        this.f35188r = fArr;
    }

    public t b() {
        t tVar = new t();
        tVar.q(w());
        tVar.p(v());
        tVar.a(d());
        tVar.c(c());
        tVar.d(f());
        tVar.l(y());
        tVar.t(A());
        tVar.c(D());
        tVar.r(x());
        tVar.i(o());
        tVar.e(g());
        tVar.s(z());
        tVar.m(r());
        tVar.a(e());
        tVar.b(h());
        tVar.d(q());
        tVar.c(i());
        tVar.j(p());
        if (s() != null && tVar.s() != null) {
            RectF s2 = tVar.s();
            RectF s10 = s();
            s2.left = s10.left;
            s2.top = s10.top;
            s2.right = s10.right;
            s2.bottom = s10.bottom;
        }
        if (l() != null && tVar.l() != null) {
            RectF l10 = tVar.l();
            RectF l11 = l();
            l10.left = l11.left;
            l10.top = l11.top;
            l10.right = l11.right;
            l10.bottom = l11.bottom;
        }
        return tVar;
    }

    public void c(boolean z10) {
        this.f35183m = z10;
    }

    public float[] d() {
        return this.f35188r;
    }

    public void e(float f10) {
        this.f35191u = f10;
    }

    public float f() {
        return this.f35190t;
    }

    public float g() {
        return this.f35191u;
    }

    public void h(float f10) {
        this.C.top = f10;
    }

    public void i(float f10) {
        this.f35193w = f10;
    }

    public void j(float f10) {
        this.f35194x = f10;
    }

    public float k() {
        return this.f35183m ? this.C.left : this.C.right;
    }

    public void l(float f10) {
        this.f35192v = f10;
    }

    public void m(int i10) {
        this.f35195y = i10;
    }

    public void n(int i10) {
        this.f35187q = i10;
    }

    public void o(int i10) {
        this.f35186p = i10;
    }

    public void p(int i10) {
        this.f35185o = i10;
    }

    public void q(int i10) {
        this.f35182l = i10;
    }

    public void r(int i10) {
        if (i10 > 0) {
            this.f35184n = i10;
        }
    }

    public RectF s() {
        return this.B;
    }

    public int t() {
        return this.f35187q;
    }

    public int u() {
        return this.f35186p;
    }

    public int v() {
        return this.f35185o;
    }

    public int w() {
        return this.f35182l;
    }

    public int x() {
        return this.f35184n;
    }

    public float y() {
        return this.f35192v;
    }

    public int z() {
        return this.f35196z;
    }

    private int u(int i10) {
        return this.f35183m ? (this.f35184n - 1) - i10 : i10;
    }

    public void a(@NonNull RectF rectF) {
        this.C = rectF;
    }

    public float c() {
        return this.f35189s;
    }

    public void d(float f10) {
        this.f35190t = f10;
    }

    public float[][] e() {
        return this.E;
    }

    public void f(float f10) {
        if (this.f35183m) {
            this.C.left = f10;
        } else {
            this.C.right = f10;
        }
    }

    public void g(float f10) {
        if (this.f35183m) {
            this.C.right = f10;
        } else {
            this.C.left = f10;
        }
    }

    public float[][] h() {
        return this.F;
    }

    public float[][] i() {
        return this.G;
    }

    public float j() {
        return this.C.bottom;
    }

    public void k(float f10) {
        this.C.bottom = f10;
    }

    public RectF l() {
        return this.C;
    }

    public float m() {
        return this.f35183m ? this.C.right : this.C.left;
    }

    public float n() {
        return this.C.top;
    }

    public float o() {
        return this.f35193w;
    }

    public float p() {
        return this.f35194x;
    }

    public float[][] q() {
        return this.H;
    }

    public int r() {
        return this.f35195y;
    }

    public void s(int i10) {
        this.f35196z = i10;
    }

    public void t(int i10) {
        this.D = i10;
    }

    public void a(float f10, float f11, float f12, float f13) {
        g(f10);
        h(f11);
        f(f12);
        k(f13);
    }

    public void c(float f10) {
        this.f35189s = f10;
    }

    public void d(float[][] fArr) {
        this.H = fArr;
    }

    public float[] e(boolean z10, int i10) {
        float b4;
        float[] fArr = new float[this.f35184n];
        for (int i11 = 0; i11 < this.f35184n; i11++) {
            if (z10) {
                b4 = a(i11, i10);
            } else {
                b4 = b(i11, i10);
            }
            fArr[i11] = b4;
        }
        return fArr;
    }

    public float h(int i10) {
        int u10 = u(i10);
        if (a(this.G, u10)) {
            return 0.0f;
        }
        return this.G[u10][!this.f35183m ? 1 : 0];
    }

    public float i(int i10) {
        int u10 = u(i10);
        if (a(this.G, u10)) {
            return 0.0f;
        }
        return this.G[u10][this.f35183m ? 1 : 0];
    }

    public float[] j(int i10) {
        float[] fArr = new float[this.f35184n];
        for (int i11 = 0; i11 < this.f35184n; i11++) {
            fArr[i11] = a(i11, i10);
        }
        return fArr;
    }

    public float[] k(int i10) {
        float[] fArr = new float[this.f35184n];
        for (int i11 = 0; i11 < this.f35184n; i11++) {
            fArr[i11] = b(i11, i10);
        }
        return fArr;
    }

    public void l(int i10) {
        ConcurrentHashMap<Integer, Float> concurrentHashMap = this.I;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(i10));
        }
    }

    public void c(float[][] fArr) {
        this.G = fArr;
    }

    public float d(int i10) {
        int u10 = u(i10);
        if (a(this.H, u10)) {
            return 0.0f;
        }
        return this.H[u10][2];
    }

    public float c(int i10) {
        int u10 = u(i10);
        if (a(this.F, u10)) {
            return 0.0f;
        }
        return this.F[u10][this.f35183m ? (char) 2 : (char) 1];
    }

    public float f(int i10) {
        int u10 = u(i10);
        if (a(this.G, u10)) {
            return 0.0f;
        }
        return this.G[u10][2];
    }

    public float g(int i10) {
        int u10 = u(i10);
        if (a(this.H, u10)) {
            return 0.0f;
        }
        return this.H[u10][this.f35183m ? 1 : 0];
    }

    public void a(float[][] fArr) {
        this.E = fArr;
    }

    public float d(boolean z10, int i10) {
        return z10 ? g(i10) : i(i10);
    }

    public float e(int i10) {
        int u10 = u(i10);
        if (a(this.H, u10)) {
            return 0.0f;
        }
        return this.H[u10][!this.f35183m ? 1 : 0];
    }

    public boolean a(boolean z10, int i10, float[] fArr) {
        if (this.E == null || this.F == null || fArr == null || fArr.length != this.f35184n) {
            return true;
        }
        for (int i11 = 0; i11 < this.f35184n; i11++) {
            if (i10 != i11) {
                if (Math.abs((z10 ? a(i11, i10) : b(i11, i10)) - fArr[i11]) > 1.0f) {
                    return false;
                }
            }
        }
        return true;
    }

    public float c(boolean z10, int i10) {
        return z10 ? e(i10) : h(i10);
    }

    public boolean a(boolean z10, int i10, float f10, float f11) {
        float d10 = d(z10, i10);
        float c4 = c(z10, i10);
        float abs = Math.abs(d10 - f10);
        float abs2 = Math.abs(c4 - f11);
        float abs3 = Math.abs(c4 - d10) / 8.0f;
        return (Float.compare(abs, abs3) < 0) && (Float.compare(abs2, abs3) < 0);
    }

    public void a(int i10, float f10) {
        if (this.I == null) {
            this.I = new ConcurrentHashMap<>();
        }
        this.I.put(Integer.valueOf(i10), Float.valueOf(f10));
    }

    public void a() {
        ConcurrentHashMap<Integer, Float> concurrentHashMap = this.I;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public void a(float f10) {
        int i10 = this.f35184n;
        this.E = (float[][]) Array.newInstance((Class<?>) float.class, i10, 3);
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) float.class, i10, 3);
        this.H = fArr;
        fArr[0][0] = f10;
        float[] fArr2 = fArr[0];
        float f11 = this.f35193w;
        fArr2[1] = f10 + f11;
        fArr[0][2] = (fArr[0][0] + fArr[0][1]) / 2.0f;
        float[][] fArr3 = this.E;
        float[] fArr4 = fArr3[0];
        float f12 = this.f35190t;
        fArr4[1] = f10 + f12;
        fArr3[0][0] = (f11 / 2.0f) + f10;
        fArr3[0][2] = fArr3[0][0];
        float f13 = f12 * 2.0f;
        int i11 = 1;
        while (true) {
            int i12 = this.f35184n;
            if (i11 >= i12) {
                return;
            }
            float[][] fArr5 = this.H;
            float[] fArr6 = fArr5[i11];
            int i13 = i11 - 1;
            float f14 = fArr5[i13][0];
            float f15 = this.f35195y;
            fArr6[0] = f14 + f15 + f13;
            fArr5[i11][1] = fArr5[i13][1] + f15 + f13;
            fArr5[i11][2] = fArr5[i13][2] + f15 + f13;
            float[][] fArr7 = this.E;
            fArr7[i11][1] = fArr7[i13][1] + f15 + f13;
            float[] fArr8 = fArr7[i11];
            float f16 = (r11 * i11) + f10;
            float f17 = this.f35193w;
            fArr8[0] = (f17 / 2.0f) + (i11 * f13) + f16;
            fArr7[i11][2] = (i13 * f13) + f16 + f17 + this.f35190t;
            if (i11 == i12 - 1) {
                fArr7[i11][1] = fArr7[i11][0];
            }
            i11++;
        }
    }

    public void b(@NonNull RectF rectF) {
        if (this.B == null) {
            this.B = new RectF();
        }
        RectF rectF2 = this.B;
        rectF2.left = rectF.left;
        rectF2.top = rectF.top;
        rectF2.right = rectF.right;
        rectF2.bottom = rectF.bottom;
    }

    public void b(float f10, float f11, float f12, float f13) {
        if (this.B == null) {
            this.B = new RectF();
        }
        RectF rectF = this.B;
        rectF.left = f10;
        rectF.top = f11;
        rectF.right = f12;
        rectF.bottom = f13;
    }

    public float[] a(boolean z10, int i10) {
        return z10 ? j(i10) : k(i10);
    }

    public float a(int i10, int i11) {
        int u10 = u(i10);
        if (a(this.E, u10)) {
            return 0.0f;
        }
        if (i10 > i11) {
            return this.E[u10][this.f35183m ? (char) 1 : (char) 2];
        }
        if (i10 < i11) {
            return this.E[u10][this.f35183m ? (char) 2 : (char) 1];
        }
        return this.E[u10][0];
    }

    public void b(int i10, float f10) {
        float[] fArr = this.f35188r;
        if (fArr == null || i10 < 0 || i10 >= fArr.length) {
            return;
        }
        fArr[i10] = f10;
    }

    public float a(int i10) {
        int u10 = u(i10);
        if (a(this.F, u10)) {
            return 0.0f;
        }
        return this.F[u10][0];
    }

    public void b(boolean z10) {
        this.A = z10;
    }

    public void b(float[][] fArr) {
        this.F = fArr;
    }

    public float a(boolean z10) {
        return z10 ? (this.f35193w / 2.0f) - this.f35190t : (this.f35194x - this.f35191u) / 2.0f;
    }

    public void b(float f10) {
        int i10 = this.f35184n;
        this.F = (float[][]) Array.newInstance((Class<?>) float.class, i10, 3);
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) float.class, i10, 3);
        this.G = fArr;
        fArr[0][0] = f10;
        float[] fArr2 = fArr[0];
        float f11 = this.f35194x;
        fArr2[1] = f10 + f11;
        float f12 = f11 / 2.0f;
        fArr[0][2] = fArr[0][0] + f12;
        float[][] fArr3 = this.F;
        fArr3[0][1] = (this.f35191u / 2.0f) + f10;
        fArr3[0][0] = f12 + f10;
        fArr3[0][2] = fArr3[0][0];
        int i11 = 1;
        while (true) {
            int i12 = this.f35184n;
            if (i11 >= i12) {
                return;
            }
            float[][] fArr4 = this.G;
            float[] fArr5 = fArr4[i11];
            int i13 = i11 - 1;
            float f13 = fArr4[i13][0];
            float f14 = this.f35196z;
            float f15 = this.f35191u;
            fArr5[0] = f13 + f14 + f15;
            fArr4[i11][1] = fArr4[i13][1] + f14 + f15;
            fArr4[i11][2] = fArr4[i13][2] + f14 + f15;
            float[][] fArr6 = this.F;
            fArr6[i11][1] = fArr6[i13][1] + f14 + f15;
            float[] fArr7 = fArr6[i11];
            float f16 = (r10 * i11) + f10;
            float f17 = this.f35194x;
            fArr7[0] = (f17 / 2.0f) + (i11 * f15) + f16;
            fArr6[i11][2] = (i13 * f15) + (f15 / 2.0f) + f16 + f17;
            if (i11 == i12 - 1) {
                fArr6[i11][1] = fArr6[i11][0];
            }
            i11++;
        }
    }

    private boolean a(float[][] fArr, int i10) {
        return fArr == null || i10 < 0 || i10 >= fArr.length;
    }

    public float b(int i10, int i11) {
        int u10 = u(i10);
        if (a(this.F, u10)) {
            return 0.0f;
        }
        if (i10 > i11) {
            return this.F[u10][this.f35183m ? (char) 1 : (char) 2];
        }
        if (i10 < i11) {
            return this.F[u10][this.f35183m ? (char) 2 : (char) 1];
        }
        return this.F[u10][0];
    }

    public float b(int i10) {
        int u10 = u(i10);
        if (a(this.F, u10)) {
            return 0.0f;
        }
        return this.F[u10][this.f35183m ? (char) 1 : (char) 2];
    }

    public float b(boolean z10, int i10) {
        return z10 ? d(i10) : f(i10);
    }
}
