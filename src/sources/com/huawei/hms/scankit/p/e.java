package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;

/* compiled from: AlignmentPatternFinder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final s f30896a;

    /* renamed from: c, reason: collision with root package name */
    private final int f30898c;

    /* renamed from: d, reason: collision with root package name */
    private final int f30899d;

    /* renamed from: e, reason: collision with root package name */
    private final int f30900e;

    /* renamed from: f, reason: collision with root package name */
    private final int f30901f;

    /* renamed from: g, reason: collision with root package name */
    private final float f30902g;

    /* renamed from: i, reason: collision with root package name */
    private final v6 f30904i;

    /* renamed from: b, reason: collision with root package name */
    private final List<d> f30897b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    private final int[] f30903h = new int[3];

    public e(s sVar, int i10, int i11, int i12, int i13, float f10, v6 v6Var) {
        this.f30896a = sVar;
        this.f30898c = i10;
        this.f30899d = i11;
        this.f30900e = i12;
        this.f30901f = i13;
        this.f30902g = f10;
        this.f30904i = v6Var;
    }

    public d a() throws a {
        d a10;
        int i10 = this.f30898c;
        int i11 = this.f30901f;
        int i12 = this.f30900e + i10;
        int i13 = this.f30899d + (i11 / 2);
        int[] iArr = new int[3];
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = ((i14 & 1) == 0 ? (i14 + 1) / 2 : -((i14 + 1) / 2)) + i13;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i16 = i10;
            while (i16 < i12 && !this.f30896a.b(i16, i15)) {
                i16++;
            }
            d a11 = a(i15, i16, i12, iArr);
            if (a11 != null) {
                return a11;
            }
            if (a(iArr) && (a10 = a(iArr, i15, i12)) != null) {
                return a10;
            }
        }
        if (!this.f30897b.isEmpty()) {
            return this.f30897b.get(0);
        }
        throw a.a();
    }

    private d a(int i10, int i11, int i12, int[] iArr) {
        d a10;
        int i13 = 0;
        while (i11 < i12) {
            if (!this.f30896a.b(i11, i10)) {
                if (i13 == 1) {
                    i13++;
                }
                iArr[i13] = iArr[i13] + 1;
            } else if (i13 == 1) {
                iArr[1] = iArr[1] + 1;
            } else if (i13 == 2) {
                if (a(iArr) && (a10 = a(iArr, i10, i11)) != null) {
                    return a10;
                }
                iArr[0] = iArr[2];
                iArr[1] = 1;
                iArr[2] = 0;
                i13 = 1;
            } else {
                i13++;
                iArr[i13] = iArr[i13] + 1;
            }
            i11++;
        }
        return null;
    }

    private static float a(int[] iArr, int i10) {
        return (i10 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private boolean a(int[] iArr) {
        float f10 = this.f30902g;
        float f11 = (3.0f * f10) / 4.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            if (Math.abs(f10 - iArr[i10]) >= f11) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        if (r2[1] <= r12) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r10 >= r1) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
    
        if (r0.b(r11, r10) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
    
        if (r2[2] > r12) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
    
        r2[2] = r2[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (r2[2] <= r12) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
    
        r11 = (r2[0] + r2[1]) + r2[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0088, code lost:
    
        if (r11 >= (r13 * 3)) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008c, code lost:
    
        if ((r11 * 3) > r13) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
    
        if (a(r2) == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0099, code lost:
    
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.s r0 = r9.f30896a
            int r1 = r0.c()
            int[] r2 = r9.f30903h
            r3 = 0
            r2[r3] = r3
            r4 = 1
            r2[r4] = r3
            r5 = 2
            r2[r5] = r3
            r6 = r10
        L12:
            if (r6 < 0) goto L26
            boolean r7 = r0.b(r11, r6)
            if (r7 == 0) goto L26
            r7 = r2[r4]
            if (r7 > r12) goto L26
            r7 = r2[r4]
            int r7 = r7 + r4
            r2[r4] = r7
            int r6 = r6 + (-1)
            goto L12
        L26:
            r7 = 2143289344(0x7fc00000, float:NaN)
            if (r6 < 0) goto L99
            r8 = r2[r4]
            if (r8 <= r12) goto L30
            goto L99
        L30:
            if (r6 < 0) goto L44
            boolean r8 = r0.b(r11, r6)
            if (r8 != 0) goto L44
            r8 = r2[r3]
            if (r8 > r12) goto L44
            r8 = r2[r3]
            int r8 = r8 + r4
            r2[r3] = r8
            int r6 = r6 + (-1)
            goto L30
        L44:
            r6 = r2[r3]
            if (r6 <= r12) goto L49
            return r7
        L49:
            int r10 = r10 + r4
        L4a:
            if (r10 >= r1) goto L5e
            boolean r6 = r0.b(r11, r10)
            if (r6 == 0) goto L5e
            r6 = r2[r4]
            if (r6 > r12) goto L5e
            r6 = r2[r4]
            int r6 = r6 + r4
            r2[r4] = r6
            int r10 = r10 + 1
            goto L4a
        L5e:
            if (r10 == r1) goto L99
            r6 = r2[r4]
            if (r6 <= r12) goto L65
            goto L99
        L65:
            if (r10 >= r1) goto L79
            boolean r6 = r0.b(r11, r10)
            if (r6 != 0) goto L79
            r6 = r2[r5]
            if (r6 > r12) goto L79
            r6 = r2[r5]
            int r6 = r6 + r4
            r2[r5] = r6
            int r10 = r10 + 1
            goto L65
        L79:
            r11 = r2[r5]
            if (r11 <= r12) goto L7e
            return r7
        L7e:
            r11 = r2[r3]
            r12 = r2[r4]
            int r11 = r11 + r12
            r12 = r2[r5]
            int r11 = r11 + r12
            int r12 = r13 * 3
            if (r11 >= r12) goto L99
            int r11 = r11 * 3
            if (r11 > r13) goto L8f
            goto L99
        L8f:
            boolean r11 = r9.a(r2)
            if (r11 == 0) goto L99
            float r7 = a(r2, r10)
        L99:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.e.a(int, int, int, int):float");
    }

    private d a(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2];
        float a10 = a(iArr, i11);
        float a11 = a(i10, (int) a10, iArr[1] * 3, i12);
        if (Float.isNaN(a11)) {
            return null;
        }
        float f10 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (d dVar : this.f30897b) {
            if (dVar.b(f10, a11, a10)) {
                return dVar.c(a11, a10, f10);
            }
        }
        d dVar2 = new d(a10, a11, f10);
        this.f30897b.add(dVar2);
        v6 v6Var = this.f30904i;
        if (v6Var == null) {
            return null;
        }
        v6Var.a(dVar2);
        return null;
    }
}
