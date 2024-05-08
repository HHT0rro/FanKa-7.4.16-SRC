package com.huawei.hms.scankit.p;

import com.android.internal.logging.nano.MetricsProto;
import com.tencent.rtmp.TXLiveConstants;

/* compiled from: Detector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c2 {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f30782g = {3808, MetricsProto.MetricsEvent.ACTION_SELECT_SUMMARY, TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY, 1799};

    /* renamed from: a, reason: collision with root package name */
    private final s f30783a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f30784b;

    /* renamed from: c, reason: collision with root package name */
    private int f30785c;

    /* renamed from: d, reason: collision with root package name */
    private int f30786d;

    /* renamed from: e, reason: collision with root package name */
    private int f30787e;

    /* renamed from: f, reason: collision with root package name */
    private int f30788f;

    /* compiled from: Detector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f30789a;

        /* renamed from: b, reason: collision with root package name */
        private final int f30790b;

        public a(int i10, int i11) {
            this.f30789a = i10;
            this.f30790b = i11;
        }

        public u6 c() {
            return new u6(this.f30789a, this.f30790b);
        }

        public String toString() {
            return "<" + this.f30789a + ' ' + this.f30790b + '>';
        }

        public int a() {
            return this.f30789a;
        }

        public int b() {
            return this.f30790b;
        }
    }

    public c2(s sVar) {
        this.f30783a = sVar;
    }

    private a b() {
        u6 c4;
        u6 u6Var;
        u6 u6Var2;
        u6 u6Var3;
        u6 c10;
        u6 c11;
        u6 c12;
        u6 c13;
        try {
            u6[] a10 = new j8(this.f30783a).a();
            u6Var2 = a10[0];
            u6Var3 = a10[1];
            u6Var = a10[2];
            c4 = a10[3];
        } catch (com.huawei.hms.scankit.p.a unused) {
            int e2 = this.f30783a.e() / 2;
            int c14 = this.f30783a.c() / 2;
            int i10 = e2 + 7;
            int i11 = c14 - 7;
            u6 c15 = a(new a(i10, i11), false, 1, -1).c();
            int i12 = c14 + 7;
            u6 c16 = a(new a(i10, i12), false, 1, 1).c();
            int i13 = e2 - 7;
            u6 c17 = a(new a(i13, i12), false, -1, 1).c();
            c4 = a(new a(i13, i11), false, -1, -1).c();
            u6Var = c17;
            u6Var2 = c15;
            u6Var3 = c16;
        }
        int a11 = s4.a((((u6Var2.b() + c4.b()) + u6Var3.b()) + u6Var.b()) / 4.0f);
        int a12 = s4.a((((u6Var2.c() + c4.c()) + u6Var3.c()) + u6Var.c()) / 4.0f);
        try {
            u6[] a13 = new j8(this.f30783a, 15, a11, a12).a();
            c10 = a13[0];
            c11 = a13[1];
            c12 = a13[2];
            c13 = a13[3];
        } catch (com.huawei.hms.scankit.p.a unused2) {
            int i14 = a11 + 7;
            int i15 = a12 - 7;
            c10 = a(new a(i14, i15), false, 1, -1).c();
            int i16 = a12 + 7;
            c11 = a(new a(i14, i16), false, 1, 1).c();
            int i17 = a11 - 7;
            c12 = a(new a(i17, i16), false, -1, 1).c();
            c13 = a(new a(i17, i15), false, -1, -1).c();
        }
        return new a(s4.a((((c10.b() + c13.b()) + c11.b()) + c12.b()) / 4.0f), s4.a((((c10.c() + c13.c()) + c11.c()) + c12.c()) / 4.0f));
    }

    public g a(boolean z10) throws com.huawei.hms.scankit.p.a {
        u6[] a10 = a(b());
        if (z10) {
            u6 u6Var = a10[0];
            a10[0] = a10[2];
            a10[2] = u6Var;
        }
        a(a10);
        s sVar = this.f30783a;
        int i10 = this.f30788f;
        return new g(a(sVar, a10[i10 % 4], a10[(i10 + 1) % 4], a10[(i10 + 2) % 4], a10[(i10 + 3) % 4]), b(a10), this.f30784b, this.f30786d, this.f30785c);
    }

    private void a(u6[] u6VarArr) throws com.huawei.hms.scankit.p.a {
        long j10;
        long j11;
        if (a(u6VarArr[0]) && a(u6VarArr[1]) && a(u6VarArr[2]) && a(u6VarArr[3])) {
            int i10 = this.f30787e * 2;
            int[] iArr = {a(u6VarArr[0], u6VarArr[1], i10), a(u6VarArr[1], u6VarArr[2], i10), a(u6VarArr[2], u6VarArr[3], i10), a(u6VarArr[3], u6VarArr[0], i10)};
            this.f30788f = a(iArr, i10);
            long j12 = 0;
            for (int i11 = 0; i11 < 4; i11++) {
                int i12 = iArr[(this.f30788f + i11) % 4];
                if (this.f30784b) {
                    j10 = j12 << 7;
                    j11 = (i12 >> 1) & 127;
                } else {
                    j10 = j12 << 10;
                    j11 = ((i12 >> 2) & MetricsProto.MetricsEvent.SETTINGS_ASSIST_GESTURE_TRAINING_ENROLLING) + ((i12 >> 1) & 31);
                }
                j12 = j10 + j11;
            }
            int a10 = a(j12, this.f30784b);
            if (this.f30784b) {
                this.f30785c = (a10 >> 6) + 1;
                this.f30786d = (a10 & 63) + 1;
                return;
            } else {
                this.f30785c = (a10 >> 11) + 1;
                this.f30786d = (a10 & 2047) + 1;
                return;
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private u6[] b(u6[] u6VarArr) {
        return a(u6VarArr, this.f30787e * 2, a());
    }

    private boolean b(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int b4 = b(aVar8, aVar5);
        return b4 != 0 && b(aVar5, aVar6) == b4 && b(aVar6, aVar7) == b4 && b(aVar7, aVar8) == b4;
    }

    private static int a(int[] iArr, int i10) throws com.huawei.hms.scankit.p.a {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 = (i11 << 3) + ((i12 >> (i10 - 2)) << 1) + (i12 & 1);
        }
        int i13 = ((i11 & 1) << 11) + (i11 >> 1);
        for (int i14 = 0; i14 < 4; i14++) {
            if (Integer.bitCount(f30782g[i14] ^ i13) <= 2) {
                return i14;
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static int a(long j10, boolean z10) throws com.huawei.hms.scankit.p.a {
        int i10;
        int i11;
        if (z10) {
            i10 = 7;
            i11 = 2;
        } else {
            i10 = 10;
            i11 = 4;
        }
        int i12 = i10 - i11;
        int[] iArr = new int[i10];
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            iArr[i13] = ((int) j10) & 15;
            j10 >>= 4;
        }
        try {
            new p6(o3.f31364k).a(iArr, i12);
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                i14 = (i14 << 4) + iArr[i15];
            }
            return i14;
        } catch (com.huawei.hms.scankit.p.a unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private int b(a aVar, a aVar2) {
        float a10 = a(aVar, aVar2);
        float a11 = (aVar2.a() - aVar.a()) / a10;
        float b4 = (aVar2.b() - aVar.b()) / a10;
        float a12 = aVar.a();
        float b10 = aVar.b();
        boolean b11 = this.f30783a.b(aVar.a(), aVar.b());
        int ceil = (int) Math.ceil(a10);
        int i10 = 0;
        for (int i11 = 0; i11 < ceil; i11++) {
            a12 += a11;
            b10 += b4;
            if (this.f30783a.b(s4.a(a12), s4.a(b10)) != b11) {
                i10++;
            }
        }
        float f10 = i10 / a10;
        if (f10 <= 0.1f || f10 >= 0.9f) {
            return (f10 <= 0.1f) == b11 ? 1 : -1;
        }
        return 0;
    }

    private u6[] a(a aVar) throws com.huawei.hms.scankit.p.a {
        int i10 = 1;
        this.f30787e = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z10 = true;
        while (this.f30787e < 9) {
            a a10 = a(aVar5, z10, i10, -1);
            a a11 = a(aVar4, z10, i10, i10);
            a a12 = a(aVar3, z10, -1, i10);
            a a13 = a(aVar2, z10, -1, -1);
            if (this.f30787e > 2) {
                double a14 = (a(a13, a10) * this.f30787e) / (a(aVar2, aVar5) * (this.f30787e + 2));
                if (a14 < 0.75d) {
                    break;
                }
                if (a14 > 1.25d) {
                    break;
                }
                if (!a(a10, a11, a12, a13)) {
                    break;
                }
                if (!b(a10, a11, a12, a13)) {
                    int i11 = this.f30787e;
                    if (i11 == 5 || i11 == 7) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            z10 = !z10;
            this.f30787e++;
            aVar2 = a13;
            aVar5 = a10;
            aVar4 = a11;
            aVar3 = a12;
            i10 = 1;
        }
        int i12 = this.f30787e;
        if (i12 != 5 && i12 != 7) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        this.f30784b = i12 == 5;
        u6[] u6VarArr = {new u6(aVar5.a() + 0.5f, aVar5.b() - 0.5f), new u6(aVar4.a() + 0.5f, aVar4.b() + 0.5f), new u6(aVar3.a() - 0.5f, aVar3.b() + 0.5f), new u6(aVar2.a() - 0.5f, aVar2.b() - 0.5f)};
        int i13 = this.f30787e * 2;
        return a(u6VarArr, i13 - 3, i13);
    }

    private s a(s sVar, u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4) throws com.huawei.hms.scankit.p.a {
        s3 a10 = s3.a();
        int a11 = a();
        float f10 = a11 / 2.0f;
        float f11 = this.f30787e;
        float f12 = f10 - f11;
        float f13 = f10 + f11;
        return a10.a(sVar, a11, a11, f12, f12, f13, f12, f13, f13, f12, f13, u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c(), u6Var3.b(), u6Var3.c(), u6Var4.b(), u6Var4.c());
    }

    private int a(u6 u6Var, u6 u6Var2, int i10) {
        float a10 = a(u6Var, u6Var2);
        float f10 = a10 / i10;
        float b4 = u6Var.b();
        float c4 = u6Var.c();
        float b10 = ((u6Var2.b() - u6Var.b()) * f10) / a10;
        float c10 = (f10 * (u6Var2.c() - u6Var.c())) / a10;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f11 = i12;
            if (this.f30783a.b(s4.a((f11 * b10) + b4), s4.a((f11 * c10) + c4))) {
                i11 |= 1 << ((i10 - i12) - 1);
            }
        }
        return i11;
    }

    private boolean a(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a((int) Math.ceil((((aVar.f30789a + aVar2.f30789a) + aVar3.f30789a) + aVar4.f30789a) / 4.0f), (int) Math.ceil((((aVar.f30790b + aVar2.f30790b) + aVar3.f30790b) + aVar4.f30790b) / 4.0f));
        float a10 = a(aVar5, aVar);
        float a11 = a(aVar5, aVar2);
        float a12 = a(aVar5, aVar3);
        float a13 = a(aVar5, aVar4);
        double d10 = a10 / a11;
        if (d10 <= 0.75d || d10 >= 1.25d) {
            return false;
        }
        double d11 = a10 / a12;
        if (d11 <= 0.75d || d11 >= 1.25d) {
            return false;
        }
        double d12 = a10 / a13;
        return d12 > 0.75d && d12 < 1.25d;
    }

    private a a(a aVar, boolean z10, int i10, int i11) {
        int a10 = aVar.a() + i10;
        int b4 = aVar.b();
        while (true) {
            b4 += i11;
            if (!a(a10, b4) || this.f30783a.b(a10, b4) != z10) {
                break;
            }
            a10 += i10;
        }
        int i12 = a10 - i10;
        int i13 = b4 - i11;
        while (a(i12, i13) && this.f30783a.b(i12, i13) == z10) {
            i12 += i10;
        }
        int i14 = i12 - i10;
        while (a(i14, i13) && this.f30783a.b(i14, i13) == z10) {
            i13 += i11;
        }
        return new a(i14, i13 - i11);
    }

    private static u6[] a(u6[] u6VarArr, int i10, int i11) {
        float f10 = i11 / (i10 * 2.0f);
        float b4 = u6VarArr[0].b() - u6VarArr[2].b();
        float c4 = u6VarArr[0].c() - u6VarArr[2].c();
        float b10 = (u6VarArr[0].b() + u6VarArr[2].b()) / 2.0f;
        float c10 = (u6VarArr[0].c() + u6VarArr[2].c()) / 2.0f;
        float f11 = b4 * f10;
        float f12 = c4 * f10;
        u6 u6Var = new u6(b10 + f11, c10 + f12);
        u6 u6Var2 = new u6(b10 - f11, c10 - f12);
        float b11 = u6VarArr[1].b() - u6VarArr[3].b();
        float c11 = u6VarArr[1].c() - u6VarArr[3].c();
        float b12 = (u6VarArr[1].b() + u6VarArr[3].b()) / 2.0f;
        float c12 = (u6VarArr[1].c() + u6VarArr[3].c()) / 2.0f;
        float f13 = b11 * f10;
        float f14 = f10 * c11;
        return new u6[]{u6Var, new u6(b12 + f13, c12 + f14), u6Var2, new u6(b12 - f13, c12 - f14)};
    }

    private boolean a(int i10, int i11) {
        return i10 >= 0 && i10 < this.f30783a.e() && i11 > 0 && i11 < this.f30783a.c();
    }

    private boolean a(u6 u6Var) {
        return a(s4.a(u6Var.b()), s4.a(u6Var.c()));
    }

    private static float a(a aVar, a aVar2) {
        return s4.a(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static float a(u6 u6Var, u6 u6Var2) {
        return s4.a(u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c());
    }

    private int a() {
        if (this.f30784b) {
            return (this.f30785c * 4) + 11;
        }
        int i10 = this.f30785c;
        return i10 <= 4 ? (i10 * 4) + 15 : (i10 * 4) + ((((i10 - 4) / 8) + 1) * 2) + 15;
    }
}
