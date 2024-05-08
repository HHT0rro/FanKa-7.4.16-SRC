package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* compiled from: UPCEANReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class q7 extends g5 {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f31433c = {1, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f31434d = {1, 1, 1, 1, 1};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f31435e = {1, 1, 1, 1, 1, 1};

    /* renamed from: f, reason: collision with root package name */
    public static final int[][] f31436f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[][] f31437g;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f31438a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private final p7 f31439b = new p7();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f31436f = iArr;
        int[][] iArr2 = new int[20];
        f31437g = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i10 = 10; i10 < 20; i10++) {
            int[] iArr3 = f31436f[i10 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i11 = 0; i11 < iArr3.length; i11++) {
                iArr4[i11] = iArr3[(iArr3.length - i11) - 1];
            }
            f31437g[i10] = iArr4;
        }
    }

    public static int[] a(r rVar) throws a {
        return b(rVar, 0);
    }

    public static ArrayList<int[]> b(r rVar) throws a {
        int e2 = rVar.e() / 2;
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i10 = 0;
        while (i10 < e2) {
            try {
                int[] b4 = b(rVar, i10);
                arrayList.add(b4);
                i10 = b4[0] + 1;
            } catch (a unused) {
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        throw a.a();
    }

    public abstract int a(r rVar, int[] iArr, StringBuilder sb2) throws a;

    public abstract BarcodeFormat a();

    public abstract boolean a(int i10, int i11, r rVar);

    public abstract boolean a(int[] iArr, int[] iArr2) throws a;

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i10, r rVar, Map<l1, ?> map) throws a {
        return a(i10, rVar, a(rVar), map);
    }

    public s6 a(int i10, r rVar, int[] iArr, Map<l1, ?> map) throws a {
        v6 v6Var = map == null ? null : (v6) map.get(l1.NEED_RESULT_POINT_CALLBACK);
        if (v6Var != null) {
            v6Var.a(new u6((iArr[0] + iArr[1]) / 2.0f, i10));
        }
        StringBuilder sb2 = this.f31438a;
        sb2.setLength(0);
        int a10 = a(rVar, iArr, sb2);
        if (v6Var != null) {
            v6Var.a(new u6(a10, i10));
        }
        int[] a11 = a(rVar, a10);
        if (a11[0] - a10 <= 1) {
            if (v6Var != null) {
                v6Var.a(new u6((a11[0] + a11[1]) / 2.0f, i10));
            }
            if (a(iArr, a11)) {
                int i11 = a11[1];
                if ((i11 - a11[0]) + i11 < rVar.e() && a(a11[0], i11, rVar)) {
                    String sb3 = sb2.toString();
                    if (sb3.length() >= 8) {
                        if (a(sb3)) {
                            float f10 = i10;
                            s6 s6Var = new s6(sb3, null, new u6[]{new u6(iArr[0], f10), new u6(a11[1], f10)}, a());
                            a(s6Var, a11, i10, rVar, map);
                            return s6Var;
                        }
                        throw a.a();
                    }
                    throw a.a();
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    public static int[] b(r rVar, int i10) throws a {
        int[] iArr = new int[f31433c.length];
        int[] iArr2 = null;
        boolean z10 = false;
        while (!z10) {
            int[] iArr3 = f31433c;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = a(rVar, i10, false, iArr3, iArr);
            int i11 = iArr2[0];
            int i12 = iArr2[1];
            int i13 = i11 - (i12 - i11);
            int i14 = i13 + 3;
            while (i13 <= i14 && (i13 < 0 || !(z10 = rVar.a(i13, i11, false, true)))) {
                i13++;
            }
            i10 = i12;
        }
        return iArr2;
    }

    public static int b(CharSequence charSequence) throws a {
        int length = charSequence.length();
        int i10 = 0;
        for (int i11 = length - 1; i11 >= 0; i11 -= 2) {
            int charAt = charSequence.charAt(i11) - '0';
            if (charAt < 0 || charAt > 9) {
                throw a.a();
            }
            i10 += charAt;
        }
        int i12 = i10 * 3;
        for (int i13 = length - 2; i13 >= 0; i13 -= 2) {
            int charAt2 = charSequence.charAt(i13) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw a.a();
            }
            i12 += charAt2;
        }
        return (1000 - i12) % 10;
    }

    private void a(s6 s6Var, int[] iArr, int i10, r rVar, Map<l1, ?> map) throws a {
        int i11;
        boolean z10 = true;
        try {
            s6 a10 = this.f31439b.a(i10, rVar, iArr[1]);
            s6Var.a(a10.j());
            i11 = a10.k().length();
        } catch (a unused) {
            i11 = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(l1.ALLOWED_EAN_EXTENSIONS);
        if (iArr2 != null) {
            int length = iArr2.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    z10 = false;
                    break;
                } else if (i11 == iArr2[i12]) {
                    break;
                } else {
                    i12++;
                }
            }
            if (!z10) {
                throw a.a();
            }
        }
    }

    public boolean a(String str) throws a {
        return a((CharSequence) str);
    }

    public static boolean a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i10 = length - 1;
        return b(charSequence.subSequence(0, i10)) == Character.digit(charSequence.charAt(i10), 10);
    }

    public int[] a(r rVar, int i10) throws a {
        return a(rVar, i10, false, f31433c);
    }

    public static int[] a(r rVar, int i10, boolean z10, int[] iArr) throws a {
        return a(rVar, i10, z10, iArr, new int[iArr.length]);
    }

    private static int[] a(r rVar, int i10, boolean z10, int[] iArr, int[] iArr2) throws a {
        int e2 = rVar.e();
        int d10 = z10 ? rVar.d(i10) : rVar.c(i10);
        int length = iArr.length;
        boolean z11 = z10;
        int i11 = 0;
        int i12 = d10;
        while (d10 < e2) {
            if (rVar.b(d10) != z11) {
                if (i11 >= 0 && i11 < iArr2.length) {
                    iArr2[i11] = iArr2[i11] + 1;
                } else {
                    throw a.a();
                }
            } else {
                if (i11 != length - 1) {
                    i11++;
                } else {
                    if (g5.a(iArr2, iArr, 0.8f) < 0.46f) {
                        return new int[]{i12, d10};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i13 = i11 - 1;
                    System.arraycopy((Object) iArr2, 2, (Object) iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i11] = 0;
                    i11--;
                }
                iArr2[i11] = 1;
                z11 = !z11;
            }
            d10++;
        }
        throw a.a();
    }

    public static int a(r rVar, int[] iArr, int i10, int[][] iArr2) throws a {
        g5.a(rVar, i10, iArr);
        int length = iArr2.length;
        float f10 = 0.46f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float a10 = g5.a(iArr, iArr2[i12], 0.8f);
            if (a10 < f10) {
                i11 = i12;
                f10 = a10;
            }
        }
        if (i11 >= 0) {
            return i11;
        }
        throw a.a();
    }
}
