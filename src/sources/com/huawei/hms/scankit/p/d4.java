package com.huawei.hms.scankit.p;

import com.huawei.appgallery.agd.api.AgdConstant;
import java.util.Arrays;

/* compiled from: HighLevelEncoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d4 {
    private static char a(char c4, int i10) {
        int i11 = c4 + ((i10 * 149) % 253) + 1;
        if (i11 > 254) {
            i11 -= 254;
        }
        return (char) i11;
    }

    public static boolean b(char c4) {
        return c4 >= '0' && c4 <= '9';
    }

    public static boolean c(char c4) {
        return c4 >= 128 && c4 <= 255;
    }

    private static boolean d(char c4) {
        return c4 == ' ' || (c4 >= '0' && c4 <= '9') || (c4 >= 'A' && c4 <= 'Z');
    }

    private static boolean e(char c4) {
        return c4 >= ' ' && c4 <= '^';
    }

    private static boolean f(char c4) {
        return c4 == ' ' || (c4 >= '0' && c4 <= '9') || (c4 >= 'a' && c4 <= 'z');
    }

    private static boolean g(char c4) {
        return i(c4) || c4 == ' ' || (c4 >= '0' && c4 <= '9') || (c4 >= 'A' && c4 <= 'Z');
    }

    private static boolean h(char c4) {
        return false;
    }

    private static boolean i(char c4) {
        return c4 == '\r' || c4 == '*' || c4 == '>';
    }

    public static String a(String str, e7 e7Var, l2 l2Var, l2 l2Var2) {
        int i10 = 0;
        v2[] v2VarArr = {new b(), new d0(), new g7(), new n8(), new s2(), new n()};
        y2 y2Var = new y2(str);
        y2Var.a(e7Var);
        y2Var.a(l2Var, l2Var2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            y2Var.a((char) 236);
            y2Var.a(2);
            y2Var.f31753f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            y2Var.a((char) 237);
            y2Var.a(2);
            y2Var.f31753f += 7;
        }
        while (y2Var.i()) {
            if (i10 >= 0 && i10 < 6) {
                v2VarArr[i10].a(y2Var);
            }
            if (y2Var.e() >= 0) {
                i10 = y2Var.e();
                y2Var.j();
            }
        }
        int a10 = y2Var.a();
        y2Var.l();
        int a11 = y2Var.g().a();
        if (a10 < a11 && i10 != 0 && i10 != 5 && i10 != 4) {
            y2Var.a((char) 254);
        }
        StringBuilder b4 = y2Var.b();
        if (b4.length() < a11) {
            b4.append((char) 129);
        }
        while (b4.length() < a11) {
            b4.append(a((char) 129, b4.length() + 1));
        }
        return y2Var.b().toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x01ec, code lost:
    
        r1 = (r18 + r5) + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01f2, code lost:
    
        if (r1 >= r17.length()) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01f4, code lost:
    
        r2 = r17.charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01fc, code lost:
    
        if (i(r2) == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0203, code lost:
    
        if (g(r2) != false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0206, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0209, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01fe, code lost:
    
        return 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.CharSequence r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.d4.a(java.lang.CharSequence, int, int):int");
    }

    private static int a(float[] fArr, int[] iArr, int i10, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i11 = 0; i11 < 6; i11++) {
            iArr[i11] = (int) Math.ceil(fArr[i11]);
            int i12 = iArr[i11];
            if (i10 > i12) {
                Arrays.fill(bArr, (byte) 0);
                i10 = i12;
            }
            if (i10 == i12) {
                bArr[i11] = (byte) (bArr[i11] + 1);
            }
        }
        return i10;
    }

    private static int a(byte[] bArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            i10 += bArr[i11];
        }
        return i10;
    }

    public static int a(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        if (i10 < length) {
            char charAt = charSequence.charAt(i10);
            while (b(charAt) && i10 < length) {
                i11++;
                i10++;
                if (i10 < length) {
                    charAt = charSequence.charAt(i10);
                }
            }
        }
        return i11;
    }

    public static void a(char c4) {
        String hexString = Integer.toHexString(c4);
        try {
            throw new IllegalArgumentException("Illegal character: " + c4 + " (0x" + (AgdConstant.INSTALL_TYPE_DEFAULT.substring(0, 4 - hexString.length()) + hexString) + ')');
        } catch (Exception e2) {
            throw e2;
        }
    }
}
