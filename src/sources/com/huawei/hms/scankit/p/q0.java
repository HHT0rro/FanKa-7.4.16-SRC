package com.huawei.hms.scankit.p;

import com.android.internal.accessibility.common.ShortcutConstants;
import org.apache.commons.io.IOUtils;

/* compiled from: CodaBarWriter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class q0 extends h5 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f31405a;

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f31406b = {'T', 'N', '*', 'E'};

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f31407c = {IOUtils.DIR_SEPARATOR_UNIX, ShortcutConstants.SERVICES_SEPARATOR, '+', '.'};

    /* renamed from: d, reason: collision with root package name */
    private static final char f31408d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f31405a = cArr;
        f31408d = cArr[0];
    }

    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int i10;
        if (str.length() < 2) {
            StringBuilder sb2 = new StringBuilder();
            char c4 = f31408d;
            sb2.append(c4);
            sb2.append(str);
            sb2.append(c4);
            str = sb2.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f31405a;
            boolean a10 = p0.a(cArr, upperCase);
            boolean a11 = p0.a(cArr, upperCase2);
            char[] cArr2 = f31406b;
            boolean a12 = p0.a(cArr2, upperCase);
            boolean a13 = p0.a(cArr2, upperCase2);
            if (a10) {
                if (!a11) {
                    throw new IllegalArgumentException("Invalid start/end guards: error contents");
                }
            } else if (a12) {
                if (!a13) {
                    throw new IllegalArgumentException("Invalid start/end guards: error contents");
                }
            } else if (!a11 && !a13) {
                StringBuilder sb3 = new StringBuilder();
                char c10 = f31408d;
                sb3.append(c10);
                sb3.append(str);
                sb3.append(c10);
                str = sb3.toString();
            } else {
                throw new IllegalArgumentException("Invalid start/end guards: error contents");
            }
        }
        int i11 = 20;
        for (int i12 = 1; i12 < str.length() - 1; i12++) {
            if (Character.isDigit(str.charAt(i12)) || str.charAt(i12) == '-' || str.charAt(i12) == '$') {
                i11 += 9;
            } else {
                if (!p0.a(f31407c, str.charAt(i12))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i12) + '\'');
                }
                i11 += 10;
            }
        }
        boolean[] zArr = new boolean[i11 + (str.length() - 1)];
        int i13 = 0;
        for (int i14 = 0; i14 < str.length(); i14++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i14));
            if (i14 == 0 || i14 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i15 = 0;
            while (true) {
                char[] cArr3 = p0.f31384e;
                if (i15 >= cArr3.length) {
                    i10 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i15]) {
                    i10 = p0.f31385f[i15];
                    break;
                }
                i15++;
            }
            int i16 = 0;
            boolean z10 = true;
            while (true) {
                int i17 = 0;
                while (i16 < 7) {
                    zArr[i13] = z10;
                    i13++;
                    if (((i10 >> (6 - i16)) & 1) == 0 || i17 == 1) {
                        z10 = !z10;
                        i16++;
                    } else {
                        i17++;
                    }
                }
                break;
            }
            if (i14 < str.length() - 1) {
                zArr[i13] = false;
                i13++;
            }
        }
        return zArr;
    }
}
