package com.huawei.hms.scankit.p;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: FinderPatternFinder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j3 {

    /* renamed from: a, reason: collision with root package name */
    private final s f31158a;

    /* renamed from: b, reason: collision with root package name */
    private final List<f3> f31159b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final int[] f31160c = new int[5];

    /* renamed from: d, reason: collision with root package name */
    private final v6 f31161d;

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class b implements Comparator<f3>, Serializable {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f3 f3Var, f3 f3Var2) {
            return Float.compare(f3Var2.e(), f3Var.e());
        }
    }

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class c implements Comparator<f3>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final float f31162a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f3 f3Var, f3 f3Var2) {
            return Float.compare(Math.abs(f3Var2.e() - this.f31162a), Math.abs(f3Var.e() - this.f31162a));
        }

        private c(float f10) {
            this.f31162a = f10;
        }
    }

    public j3(s sVar, v6 v6Var) {
        this.f31158a = sVar;
        this.f31161d = v6Var;
    }

    public static boolean b(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 5) {
            return false;
        }
        float f10 = i10 / 5.0f;
        float f11 = f10 / 1.6f;
        float f12 = f10 * 0.8f;
        float f13 = 0.8f * f11;
        if (Math.abs(f12 - iArr[0]) >= f13) {
            return false;
        }
        float f14 = f10 * 1.2f;
        float f15 = 1.2f * f11;
        return Math.abs(f14 - ((float) iArr[1])) < f15 && Math.abs(f10 - ((float) iArr[2])) < f11 && Math.abs(f14 - ((float) iArr[3])) < f15 && Math.abs(f12 - ((float) iArr[4])) < f13;
    }

    public static boolean c(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 5) {
            return false;
        }
        float f10 = i10 / 5.0f;
        float f11 = f10 / 1.0f;
        float f12 = f10 * 0.8f;
        float f13 = 0.8f * f11;
        if (Math.abs(f12 - iArr[0]) >= f13) {
            return false;
        }
        float f14 = f10 * 1.2f;
        float f15 = 1.2f * f11;
        return Math.abs(f14 - ((float) iArr[1])) < f15 && Math.abs(f10 - ((float) iArr[2])) < f11 && Math.abs(f14 - ((float) iArr[3])) < f15 && Math.abs(f12 - ((float) iArr[4])) < f13;
    }

    private void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public final f3[] a(Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        int c4 = this.f31158a.c();
        int e2 = this.f31158a.e();
        int[] iArr = new int[5];
        for (int i10 = 1; i10 < c4; i10 += 2) {
            a(iArr);
            int i11 = 0;
            for (int i12 = 0; i12 < e2; i12++) {
                if (this.f31158a.b(i12, i10)) {
                    if ((i11 & 1) == 1) {
                        i11++;
                    }
                    iArr[i11] = iArr[i11] + 1;
                } else if ((i11 & 1) != 0) {
                    iArr[i11] = iArr[i11] + 1;
                } else if (i11 == 4) {
                    if (b(iArr)) {
                        if (!a(iArr, i10, i12)) {
                            d(iArr);
                        } else {
                            a(iArr);
                            i11 = 0;
                        }
                    } else {
                        d(iArr);
                    }
                    i11 = 3;
                } else {
                    i11++;
                    iArr[i11] = iArr[i11] + 1;
                }
            }
            if (b(iArr)) {
                a(iArr, i10, e2);
            }
        }
        return b();
    }

    private float d(int i10, int i11, int i12) {
        s sVar = this.f31158a;
        int c4 = sVar.c();
        int[] a10 = a();
        int i13 = i10;
        while (i13 >= 0 && sVar.b(i11, i13)) {
            a10[2] = a10[2] + 1;
            i13--;
        }
        if (i13 < 0) {
            return Float.NaN;
        }
        while (i13 >= 0 && !sVar.b(i11, i13)) {
            a10[1] = a10[1] + 1;
            i13--;
        }
        if (i13 < 0 || a10[1] == 0) {
            return Float.NaN;
        }
        while (i13 >= 0 && sVar.b(i11, i13)) {
            a10[0] = a10[0] + 1;
            i13--;
        }
        if (a10[0] == 0) {
            return Float.NaN;
        }
        int i14 = i10 + 1;
        while (i14 < c4 && sVar.b(i11, i14)) {
            a10[2] = a10[2] + 1;
            i14++;
        }
        if (i14 == c4 || a10[2] == 0) {
            return Float.NaN;
        }
        while (i14 < c4 && !sVar.b(i11, i14)) {
            a10[3] = a10[3] + 1;
            i14++;
        }
        if (i14 == c4 || a10[3] == 0) {
            return Float.NaN;
        }
        while (i14 < c4 && sVar.b(i11, i14)) {
            a10[4] = a10[4] + 1;
            i14++;
        }
        if (a10[4] != 0 && Math.abs(((((a10[0] + a10[1]) + a10[2]) + a10[3]) + a10[4]) - i12) < i12 * 0.4f && b(a10)) {
            return a(a10, i14);
        }
        return Float.NaN;
    }

    private boolean b(int i10, int i11, int i12) {
        int i13;
        int i14;
        int[] a10 = a();
        int c4 = this.f31158a.c();
        int e2 = this.f31158a.e();
        int i15 = 0;
        while (true) {
            int i16 = i10 + i15;
            if (i16 >= c4 || i11 < i15 || !this.f31158a.b(i11 - i15, i16)) {
                break;
            }
            a10[2] = a10[2] + 1;
            i15++;
        }
        if (a10[2] == 0) {
            return false;
        }
        while (true) {
            int i17 = i10 + i15;
            if (i17 >= c4 || i11 < i15 || this.f31158a.b(i11 - i15, i17)) {
                break;
            }
            a10[1] = a10[1] + 1;
            i15++;
        }
        if (a10[1] == 0) {
            return false;
        }
        while (true) {
            int i18 = i10 + i15;
            if (i18 >= c4 || i11 < i15 || !this.f31158a.b(i11 - i15, i18)) {
                break;
            }
            a10[0] = a10[0] + 1;
            i15++;
        }
        if (a10[0] == 0) {
            return false;
        }
        int i19 = 1;
        while (i10 >= i19) {
            int i20 = i11 + i19;
            if (i20 >= e2 || !this.f31158a.b(i20, i10 - i19)) {
                break;
            }
            a10[2] = a10[2] + 1;
            i19++;
        }
        while (i10 >= i19 && (i14 = i11 + i19) < e2 && !this.f31158a.b(i14, i10 - i19)) {
            a10[3] = a10[3] + 1;
            i19++;
        }
        if (a10[3] == 0) {
            return false;
        }
        while (i10 >= i19 && (i13 = i11 + i19) < e2 && this.f31158a.b(i13, i10 - i19)) {
            a10[4] = a10[4] + 1;
            i19++;
        }
        if (a10[4] != 0 && Math.abs(((((a10[0] + a10[1]) + a10[2]) + a10[3]) + a10[4]) - i12) < i12 * 0.5f) {
            return c(a10);
        }
        return false;
    }

    private float c(int i10, int i11, int i12) {
        s sVar = this.f31158a;
        int e2 = sVar.e();
        int[] a10 = a();
        int i13 = i10;
        while (i13 >= 0 && sVar.b(i13, i11)) {
            a10[2] = a10[2] + 1;
            i13--;
        }
        if (i13 < 0) {
            return Float.NaN;
        }
        while (i13 >= 0 && !sVar.b(i13, i11)) {
            a10[1] = a10[1] + 1;
            i13--;
        }
        if (i13 < 0 || a10[1] == 0) {
            return Float.NaN;
        }
        while (i13 >= 0 && sVar.b(i13, i11)) {
            a10[0] = a10[0] + 1;
            i13--;
        }
        if (a10[0] == 0) {
            return Float.NaN;
        }
        int i14 = i10 + 1;
        while (i14 < e2 && sVar.b(i14, i11)) {
            a10[2] = a10[2] + 1;
            i14++;
        }
        if (i14 == e2 || a10[2] == 0) {
            return Float.NaN;
        }
        while (i14 < e2 && !sVar.b(i14, i11)) {
            a10[3] = a10[3] + 1;
            i14++;
        }
        if (i14 == e2 || a10[3] == 0) {
            return Float.NaN;
        }
        while (i14 < e2 && sVar.b(i14, i11)) {
            a10[4] = a10[4] + 1;
            i14++;
        }
        if (a10[4] != 0 && Math.abs(((((a10[0] + a10[1]) + a10[2]) + a10[3]) + a10[4]) - i12) < i12 * 0.2f && b(a10)) {
            return a(a10, i14);
        }
        return Float.NaN;
    }

    private static float a(int[] iArr, int i10) {
        return ((i10 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private int[] a() {
        a(this.f31160c);
        return this.f31160c;
    }

    private void a(int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr[i10] = 0;
        }
    }

    private boolean a(int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int[] a10 = a();
        int i16 = 0;
        while (i10 >= i16 && i11 >= i16 && this.f31158a.b(i11 - i16, i10 - i16)) {
            a10[2] = a10[2] + 1;
            i16++;
        }
        if (a10[2] == 0) {
            return false;
        }
        while (i10 >= i16 && i11 >= i16 && !this.f31158a.b(i11 - i16, i10 - i16)) {
            a10[1] = a10[1] + 1;
            i16++;
        }
        if (a10[1] == 0) {
            return false;
        }
        while (i10 >= i16 && i11 >= i16 && this.f31158a.b(i11 - i16, i10 - i16)) {
            a10[0] = a10[0] + 1;
            i16++;
        }
        if (a10[0] == 0) {
            return false;
        }
        int c4 = this.f31158a.c();
        int e2 = this.f31158a.e();
        int i17 = 1;
        while (true) {
            int i18 = i10 + i17;
            if (i18 >= c4 || (i15 = i11 + i17) >= e2 || !this.f31158a.b(i15, i18)) {
                break;
            }
            a10[2] = a10[2] + 1;
            i17++;
        }
        while (true) {
            int i19 = i10 + i17;
            if (i19 >= c4 || (i14 = i11 + i17) >= e2 || this.f31158a.b(i14, i19)) {
                break;
            }
            a10[3] = a10[3] + 1;
            i17++;
        }
        if (a10[3] == 0) {
            return false;
        }
        while (true) {
            int i20 = i10 + i17;
            if (i20 >= c4 || (i13 = i11 + i17) >= e2 || !this.f31158a.b(i13, i20)) {
                break;
            }
            a10[4] = a10[4] + 1;
            i17++;
        }
        if (a10[4] != 0 && Math.abs(((((a10[0] + a10[1]) + a10[2]) + a10[3]) + a10[4]) - i12) < i12 * 0.5f) {
            return c(a10);
        }
        return false;
    }

    private f3[] b() throws com.huawei.hms.scankit.p.a {
        int i10 = 0;
        int i11 = 0;
        while (i11 < this.f31159b.size()) {
            f3 f3Var = this.f31159b.get(i11);
            if (f3Var.e() <= 5.0f || f3Var.a() <= 2) {
                this.f31159b.remove(i11);
                i11--;
            }
            i11++;
        }
        int size = this.f31159b.size();
        if (size >= 3) {
            Iterator<f3> iterator2 = this.f31159b.iterator2();
            float f10 = 0.0f;
            float f11 = 0.0f;
            float f12 = 0.0f;
            while (iterator2.hasNext()) {
                float e2 = iterator2.next().e();
                f11 += e2;
                f12 += e2 * e2;
            }
            float f13 = f11 / size;
            float sqrt = (float) Math.sqrt((f12 / r1) - (f13 * f13));
            Collections.sort(this.f31159b, new c(f13));
            float max = Math.max(0.36f * f13, sqrt);
            int i12 = 0;
            while (i12 < this.f31159b.size() && this.f31159b.size() > 3) {
                if (Math.abs(this.f31159b.get(i12).e() - f13) > max) {
                    this.f31159b.remove(i12);
                    i12--;
                }
                i12++;
            }
            int size2 = this.f31159b.size();
            while (this.f31159b.iterator2().hasNext()) {
                f10 += r3.next().a();
            }
            float f14 = f10 / size2;
            while (i10 < this.f31159b.size() && this.f31159b.size() > 3) {
                if (this.f31159b.get(i10).a() <= 0.5f * f14) {
                    this.f31159b.remove(i10);
                    i10--;
                }
                i10++;
            }
            Collections.sort(this.f31159b, new b());
            List<f3> list = this.f31159b;
            return (f3[]) list.toArray(new f3[list.size()]);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    public final boolean a(int[] iArr, int i10, int i11) {
        boolean z10 = false;
        int i12 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a10 = (int) a(iArr, i11);
        float d10 = d(i10, a10, i12);
        if (!Float.isNaN(d10)) {
            int i13 = (int) d10;
            float c4 = c(a10, i13, i12);
            if (!Float.isNaN(c4)) {
                int i14 = (int) c4;
                if (a(i13, i14, i12) && b(i13, i14, i12)) {
                    float f10 = i12 / 5.0f;
                    int i15 = 0;
                    while (true) {
                        if (i15 >= this.f31159b.size()) {
                            break;
                        }
                        f3 f3Var = this.f31159b.get(i15);
                        if (f3Var.b(f10, d10, c4)) {
                            this.f31159b.set(i15, f3Var.c(d10, c4, f10));
                            z10 = true;
                            break;
                        }
                        i15++;
                    }
                    if (!z10) {
                        f3 f3Var2 = new f3(c4, d10, f10);
                        this.f31159b.add(f3Var2);
                        v6 v6Var = this.f31161d;
                        if (v6Var != null) {
                            v6Var.a(f3Var2);
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
