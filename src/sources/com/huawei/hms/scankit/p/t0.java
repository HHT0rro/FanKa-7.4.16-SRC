package com.huawei.hms.scankit.p;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code39Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class t0 extends g5 {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f31534e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: a, reason: collision with root package name */
    private final boolean f31535a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f31536b;

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f31537c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f31538d;

    public t0() {
        this(false);
    }

    private static boolean b(int[] iArr) {
        int i10 = Integer.MAX_VALUE;
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 < i10) {
                i10 = i12;
            }
            if (i12 > i11) {
                i11 = i12;
            }
        }
        return i11 / i10 > 6;
    }

    private static int c(int[] iArr) {
        int length = iArr.length;
        if (b(iArr)) {
            return -1;
        }
        int i10 = 0;
        while (true) {
            int i11 = Integer.MAX_VALUE;
            for (int i12 : iArr) {
                if (i12 < i11 && i12 > i10) {
                    i11 = i12;
                }
            }
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                int i17 = iArr[i16];
                if (i17 > i11) {
                    i15 |= 1 << ((length - 1) - i16);
                    i13++;
                    i14 += i17;
                }
            }
            if (i13 == 3) {
                for (int i18 = 0; i18 < length && i13 > 0; i18++) {
                    int i19 = iArr[i18];
                    if (i19 > i11) {
                        i13--;
                        if (i19 * 2 >= i14) {
                            return -1;
                        }
                    }
                }
                return i15;
            }
            if (i13 <= 3) {
                return -1;
            }
            i10 = i11;
        }
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i10, r rVar, Map<l1, ?> map) throws a {
        int[] iArr = this.f31538d;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f31537c;
        sb2.setLength(0);
        int[] a10 = a(rVar, iArr);
        int c4 = rVar.c(a10[1]);
        int e2 = rVar.e();
        while (true) {
            g5.a(rVar, c4, iArr);
            int c10 = c(iArr);
            if (c10 >= 0) {
                char a11 = a(c10);
                sb2.append(a11);
                int i11 = c4;
                for (int i12 : iArr) {
                    i11 += i12;
                }
                int c11 = rVar.c(i11);
                if (a11 == '*') {
                    sb2.setLength(sb2.length() - 1);
                    int i13 = 0;
                    for (int i14 : iArr) {
                        i13 += i14;
                    }
                    int i15 = (c11 - c4) - i13;
                    if (c11 != e2 && i15 * 5 < i13) {
                        throw a.a();
                    }
                    return a(sb2, a10, c4, i13, i10);
                }
                c4 = c11;
            } else {
                throw a.a();
            }
        }
    }

    public t0(boolean z10) {
        this(z10, false);
    }

    public t0(boolean z10, boolean z11) {
        this.f31535a = z10;
        this.f31536b = z11;
        this.f31537c = new StringBuilder(20);
        this.f31538d = new int[9];
    }

    private s6 a(StringBuilder sb2, int[] iArr, int i10, int i11, int i12) throws a {
        String sb3;
        if (this.f31535a) {
            int length = sb2.length() - 1;
            int i13 = 0;
            for (int i14 = 0; i14 < length; i14++) {
                i13 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f31537c.charAt(i14));
            }
            if (sb2.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i13 % 43)) {
                sb2.setLength(length);
            } else {
                throw a.a();
            }
        }
        if (sb2.length() != 0) {
            if (this.f31536b) {
                sb3 = a(sb2);
            } else {
                sb3 = sb2.toString();
            }
            float f10 = i12;
            return new s6(sb3, null, new u6[]{new u6(iArr[0], f10), new u6(i10 + i11, f10)}, BarcodeFormat.CODE_39);
        }
        throw a.a();
    }

    private static int[] a(r rVar, int[] iArr) throws a {
        int e2 = rVar.e();
        int c4 = rVar.c(0);
        int length = iArr.length;
        int i10 = c4;
        boolean z10 = false;
        int i11 = 0;
        while (c4 < e2) {
            if (rVar.b(c4) != z10) {
                if (i11 >= 0 && i11 < iArr.length) {
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    throw a.a();
                }
            } else {
                if (i11 != length - 1) {
                    i11++;
                } else {
                    if (c(iArr) == 148 && rVar.a(Math.max(0, i10 - ((c4 - i10) / 5)), i10, false, true)) {
                        return new int[]{i10, c4};
                    }
                    i10 += iArr[0] + iArr[1];
                    int i12 = i11 - 1;
                    System.arraycopy((Object) iArr, 2, (Object) iArr, 0, i12);
                    iArr[i12] = 0;
                    iArr[i11] = 0;
                    i11--;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            c4++;
        }
        throw a.a();
    }

    private static char a(int i10) throws a {
        int i11 = 0;
        while (true) {
            int[] iArr = f31534e;
            if (i11 >= iArr.length) {
                if (i10 == 148) {
                    return '*';
                }
                throw a.a();
            }
            if (iArr[i11] == i10) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i11);
            }
            i11++;
        }
    }

    private static String a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i10 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt != '+' && charAt != '$' && charAt != '%' && charAt != '/') {
                sb2.append(charAt);
            } else {
                i10++;
                sb2.append(a(charAt, charSequence.charAt(i10)));
            }
            i10++;
        }
        return sb2.toString();
    }

    private static char a(char c4, char c10) throws a {
        int i10;
        if (c4 != '$') {
            if (c4 != '%') {
                if (c4 != '+') {
                    if (c4 == '/') {
                        if (c10 < 'A' || c10 > 'O') {
                            if (c10 == 'Z') {
                                return ShortcutConstants.SERVICES_SEPARATOR;
                            }
                            throw a.a();
                        }
                        i10 = c10 - ' ';
                    }
                    return (char) 0;
                }
                if (c10 < 'A' || c10 > 'Z') {
                    throw a.a();
                }
                i10 = c10 + ' ';
            } else if (c10 >= 'A' && c10 <= 'E') {
                i10 = c10 - '&';
            } else if (c10 >= 'F' && c10 <= 'J') {
                i10 = c10 - 11;
            } else if (c10 >= 'K' && c10 <= 'O') {
                i10 = c10 + 16;
            } else {
                if (c10 < 'P' || c10 > 'T') {
                    if (c10 != 'U') {
                        if (c10 == 'V') {
                            return '@';
                        }
                        if (c10 == 'W') {
                            return '`';
                        }
                        if (c10 == 'X' || c10 == 'Y' || c10 == 'Z') {
                            return (char) 127;
                        }
                        throw a.a();
                    }
                    return (char) 0;
                }
                i10 = c10 + '+';
            }
        } else {
            if (c10 < 'A' || c10 > 'Z') {
                throw a.a();
            }
            i10 = c10 - '@';
        }
        return (char) i10;
    }
}
