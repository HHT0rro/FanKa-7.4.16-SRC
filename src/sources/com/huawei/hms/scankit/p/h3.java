package com.huawei.hms.scankit.p;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: FinderPatternFinder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h3 {

    /* renamed from: a, reason: collision with root package name */
    private final s f31051a;

    /* renamed from: b, reason: collision with root package name */
    private final List<g3> f31052b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final int[] f31053c = new int[5];

    /* renamed from: d, reason: collision with root package name */
    private final v6 f31054d;

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class b implements Comparator<g3>, Serializable {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g3 g3Var, g3 g3Var2) {
            return Float.compare(g3Var2.e(), g3Var.e());
        }
    }

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class c implements Comparator<g3>, Serializable {
        private c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g3 g3Var, g3 g3Var2) {
            return Integer.compare(g3Var2.a(), g3Var.a());
        }
    }

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class d implements Comparator<g3>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final float f31055a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g3 g3Var, g3 g3Var2) {
            return Float.compare(Math.abs(g3Var.e() - this.f31055a), Math.abs(g3Var2.e() - this.f31055a));
        }

        private d(float f10) {
            this.f31055a = f10;
        }
    }

    public h3(s sVar, v6 v6Var) {
        this.f31051a = sVar;
        this.f31054d = v6Var;
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
        if (i10 < 6) {
            return false;
        }
        float f10 = i10 / 6.0f;
        float f11 = f10 / 1.5f;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs(f10 - ((float) iArr[1])) < f11 && Math.abs((f10 * 2.0f) - ((float) iArr[2])) < 2.0f * f11 && Math.abs(f10 - ((float) iArr[3])) < f11 && Math.abs(f10 - ((float) iArr[4])) < f11;
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
        if (i10 < 6) {
            return false;
        }
        float f10 = i10 / 6.0f;
        float f11 = f10 / 1.0f;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs(f10 - ((float) iArr[1])) < f11 && Math.abs((f10 * 2.0f) - ((float) iArr[2])) < 2.0f * f11 && Math.abs(f10 - ((float) iArr[3])) < f11 && Math.abs(f10 - ((float) iArr[4])) < f11;
    }

    private void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public final g3[] a(Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        int c4 = this.f31051a.c();
        int e2 = this.f31051a.e();
        int[] iArr = new int[5];
        for (int i10 = 0; i10 < c4; i10++) {
            a(iArr);
            int i11 = 0;
            for (int i12 = 0; i12 < e2; i12++) {
                if (this.f31051a.b(i12, i10)) {
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

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r2[1] <= r13) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r3 < 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r0.b(r12, r3) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if (r2[0] > r13) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        if (r2[0] <= r13) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (r11 >= r1) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005f, code lost:
    
        if (r0.b(r12, r11) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r11 != r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006d, code lost:
    
        if (r11 >= r1) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        if (r0.b(r12, r11) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0077, code lost:
    
        if (r2[3] >= r13) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0079, code lost:
    
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
    
        if (r11 == r1) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0085, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0089, code lost:
    
        if (r11 >= r1) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008f, code lost:
    
        if (r0.b(r12, r11) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0093, code lost:
    
        if (r2[4] >= r13) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0095, code lost:
    
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        if (r2[4] < r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a1, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b9, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < (r14 * 2)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c0, code lost:
    
        if (b(r2) == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c6, code lost:
    
        return a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float b(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.h3.b(int, int, int, int):float");
    }

    private static float a(int[] iArr, int i10) {
        return ((i10 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private int[] a() {
        a(this.f31053c);
        return this.f31053c;
    }

    private void a(int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr[i10] = 0;
        }
    }

    private boolean a(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int[] a10 = a();
        int i15 = 0;
        while (i10 >= i15 && i11 >= i15 && this.f31051a.b(i11 - i15, i10 - i15)) {
            a10[2] = a10[2] + 1;
            i15++;
        }
        if (a10[2] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && !this.f31051a.b(i11 - i15, i10 - i15)) {
            a10[1] = a10[1] + 1;
            i15++;
        }
        if (a10[1] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && this.f31051a.b(i11 - i15, i10 - i15)) {
            a10[0] = a10[0] + 1;
            i15++;
        }
        if (a10[0] == 0) {
            return false;
        }
        int c4 = this.f31051a.c();
        int e2 = this.f31051a.e();
        int i16 = 1;
        while (true) {
            int i17 = i10 + i16;
            if (i17 >= c4 || (i14 = i11 + i16) >= e2 || !this.f31051a.b(i14, i17)) {
                break;
            }
            a10[2] = a10[2] + 1;
            i16++;
        }
        while (true) {
            int i18 = i10 + i16;
            if (i18 >= c4 || (i13 = i11 + i16) >= e2 || this.f31051a.b(i13, i18)) {
                break;
            }
            a10[3] = a10[3] + 1;
            i16++;
        }
        if (a10[3] == 0) {
            return false;
        }
        while (true) {
            int i19 = i10 + i16;
            if (i19 >= c4 || (i12 = i11 + i16) >= e2 || !this.f31051a.b(i12, i19)) {
                break;
            }
            a10[4] = a10[4] + 1;
            i16++;
        }
        if (a10[4] == 0) {
            return false;
        }
        return c(a10);
    }

    private g3[] b() throws com.huawei.hms.scankit.p.a {
        int i10 = 0;
        while (i10 < this.f31052b.size()) {
            g3 g3Var = this.f31052b.get(i10);
            if (g3Var.e() <= 5.0f && g3Var.a() <= 2) {
                this.f31052b.remove(i10);
                i10--;
            }
            i10++;
        }
        int size = this.f31052b.size();
        int i11 = 3;
        if (size >= 3) {
            if (size >= 4) {
                float f10 = 0.0f;
                float f11 = 0.0f;
                while (this.f31052b.iterator2().hasNext()) {
                    f11 += r7.next().a();
                }
                float f12 = f11 / size;
                int i12 = 0;
                while (i12 < this.f31052b.size() && this.f31052b.size() > 4) {
                    if (this.f31052b.get(i12).a() <= 0.5f * f12) {
                        this.f31052b.remove(i12);
                        i12--;
                    }
                    i12++;
                }
                int size2 = this.f31052b.size();
                Iterator<g3> iterator2 = this.f31052b.iterator2();
                float f13 = 0.0f;
                while (iterator2.hasNext()) {
                    float e2 = iterator2.next().e();
                    f10 += e2;
                    f13 += e2 * e2;
                }
                float f14 = f10 / size2;
                float sqrt = (float) Math.sqrt((f13 / r1) - (f14 * f14));
                Collections.sort(this.f31052b, new d(f14));
                float max = Math.max(0.36f * f14, sqrt);
                int i13 = 0;
                while (i13 < this.f31052b.size() && this.f31052b.size() > 4) {
                    if (Math.abs(this.f31052b.get(i13).e() - f14) > max) {
                        this.f31052b.remove(i13);
                        i13--;
                    }
                    i13++;
                }
                int size3 = this.f31052b.size();
                if (size3 >= 4) {
                    Collections.sort(this.f31052b, new c());
                    if (size3 > 4 && this.f31052b.get(3).a() - this.f31052b.get(4).a() > 2) {
                        while (4 < this.f31052b.size()) {
                            this.f31052b.remove(4);
                        }
                    }
                    double[] dArr = new double[3];
                    while (i11 < this.f31052b.size()) {
                        dArr[0] = a(this.f31052b.get(0), this.f31052b.get(1));
                        dArr[1] = a(this.f31052b.get(1), this.f31052b.get(i11));
                        dArr[2] = a(this.f31052b.get(0), this.f31052b.get(i11));
                        Arrays.sort(dArr);
                        double sqrt2 = ((dArr[1] + dArr[0]) - dArr[2]) / ((Math.sqrt(dArr[0]) * 2.0d) * Math.sqrt(dArr[1]));
                        dArr[0] = a(this.f31052b.get(0), this.f31052b.get(2));
                        dArr[1] = a(this.f31052b.get(2), this.f31052b.get(i11));
                        dArr[2] = a(this.f31052b.get(0), this.f31052b.get(i11));
                        Arrays.sort(dArr);
                        double sqrt3 = ((dArr[1] + dArr[0]) - dArr[2]) / ((Math.sqrt(dArr[0]) * 2.0d) * Math.sqrt(dArr[1]));
                        if (Math.abs(sqrt2) > 0.25d || Math.abs(sqrt3) > 0.25d) {
                            this.f31052b.remove(i11);
                            i11--;
                        }
                        i11++;
                    }
                }
            }
            Collections.sort(this.f31052b, new b());
            List<g3> list = this.f31052b;
            return (g3[]) list.toArray(new g3[list.size()]);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r2[1] <= r13) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r3 < 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r0.b(r3, r12) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if (r2[0] > r13) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        if (r2[0] <= r13) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (r11 >= r1) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005f, code lost:
    
        if (r0.b(r11, r12) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r11 != r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006d, code lost:
    
        if (r11 >= r1) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        if (r0.b(r11, r12) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0077, code lost:
    
        if (r2[3] >= r13) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0079, code lost:
    
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
    
        if (r11 == r1) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0085, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0089, code lost:
    
        if (r11 >= r1) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008f, code lost:
    
        if (r0.b(r11, r12) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0093, code lost:
    
        if (r2[4] >= r13) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0095, code lost:
    
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        if (r2[4] < r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a1, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b7, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < r14) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b9, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00be, code lost:
    
        if (b(r2) == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c4, code lost:
    
        return a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.h3.a(int, int, int, int):float");
    }

    public final boolean a(int[] iArr, int i10, int i11) {
        boolean z10 = false;
        int i12 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a10 = (int) a(iArr, i11);
        float b4 = b(i10, a10, iArr[2], i12);
        if (!Float.isNaN(b4)) {
            int i13 = (int) b4;
            float a11 = a(a10, i13, iArr[2], i12);
            if (!Float.isNaN(a11) && a(i13, (int) a11)) {
                float f10 = i12 / 6.0f;
                int i14 = 0;
                while (true) {
                    if (i14 >= this.f31052b.size()) {
                        break;
                    }
                    g3 g3Var = this.f31052b.get(i14);
                    if (g3Var.b(f10, b4, a11)) {
                        this.f31052b.set(i14, g3Var.c(b4, a11, f10));
                        z10 = true;
                        break;
                    }
                    i14++;
                }
                if (!z10) {
                    g3 g3Var2 = new g3(a11, b4, f10);
                    this.f31052b.add(g3Var2);
                    v6 v6Var = this.f31054d;
                    if (v6Var != null) {
                        v6Var.a(g3Var2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static double a(g3 g3Var, g3 g3Var2) {
        double b4 = g3Var.b() - g3Var2.b();
        double c4 = g3Var.c() - g3Var2.c();
        return (b4 * b4) + (c4 * c4);
    }
}
