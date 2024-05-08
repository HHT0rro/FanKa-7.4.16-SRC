package com.huawei.hms.scankit.p;

/* compiled from: ErrorCorrection.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class z2 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f31782a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f31783b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f31784c = new int[256];

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f31785d = new int[255];

    static {
        int i10 = 1;
        for (int i11 = 0; i11 < 255; i11++) {
            try {
                int[] iArr = f31785d;
                if (w7.a(iArr, i11)) {
                    iArr[i11] = i10;
                }
                int[] iArr2 = f31784c;
                if (w7.a(iArr2, i10)) {
                    iArr2[i10] = i11;
                }
                i10 *= 2;
                if (i10 >= 256) {
                    i10 ^= 301;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw e2;
            }
        }
    }

    public static String a(String str, d7 d7Var) {
        if (str.length() == d7Var.a()) {
            StringBuilder sb2 = new StringBuilder(d7Var.a() + d7Var.b());
            sb2.append(str);
            int d10 = d7Var.d();
            if (d10 == 1) {
                sb2.append(a(str, d7Var.b()));
            } else {
                sb2.setLength(sb2.capacity());
                int[] iArr = new int[d10];
                int[] iArr2 = new int[d10];
                int[] iArr3 = new int[d10];
                int i10 = 0;
                while (i10 < d10) {
                    int i11 = i10 + 1;
                    iArr[i10] = d7Var.a(i11);
                    iArr2[i10] = d7Var.b(i11);
                    iArr3[i10] = 0;
                    if (i10 > 0) {
                        iArr3[i10] = iArr3[i10 - 1] + iArr[i10];
                    }
                    i10 = i11;
                }
                for (int i12 = 0; i12 < d10; i12++) {
                    StringBuilder sb3 = new StringBuilder(iArr[i12]);
                    for (int i13 = i12; i13 < d7Var.a(); i13 += d10) {
                        sb3.append(str.charAt(i13));
                    }
                    String a10 = a(sb3.toString(), iArr2[i12]);
                    int i14 = i12;
                    int i15 = 0;
                    while (i14 < iArr2[i12] * d10) {
                        sb2.setCharAt(d7Var.a() + i14, a10.charAt(i15));
                        i14 += d10;
                        i15++;
                    }
                }
            }
            return sb2.toString();
        }
        try {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String a(CharSequence charSequence, int i10) {
        return a(charSequence, 0, charSequence.length(), i10);
    }

    private static String a(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = 0;
        while (true) {
            int[] iArr = f31782a;
            if (i13 >= iArr.length) {
                i13 = -1;
                break;
            }
            if (iArr[i13] == i12) {
                break;
            }
            i13++;
        }
        if (i13 >= 0) {
            int[] iArr2 = f31783b[i13];
            char[] cArr = new char[i12];
            for (int i14 = 0; i14 < i12; i14++) {
                cArr[i14] = 0;
            }
            for (int i15 = i10; i15 < i10 + i11; i15++) {
                int i16 = i12 - 1;
                int charAt = cArr[i16] ^ charSequence.charAt(i15);
                while (i16 > 0) {
                    if (charAt != 0 && iArr2[i16] != 0) {
                        char c4 = cArr[i16 - 1];
                        int[] iArr3 = f31785d;
                        int[] iArr4 = f31784c;
                        cArr[i16] = (char) (c4 ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i16]]) % 255]);
                    } else {
                        cArr[i16] = cArr[i16 - 1];
                    }
                    i16--;
                }
                if (charAt != 0 && iArr2[0] != 0) {
                    int[] iArr5 = f31785d;
                    int[] iArr6 = f31784c;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                } else {
                    cArr[0] = 0;
                }
            }
            char[] cArr2 = new char[i12];
            for (int i17 = 0; i17 < i12; i17++) {
                cArr2[i17] = cArr[(i12 - i17) - 1];
            }
            return String.valueOf(cArr2);
        }
        try {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i12);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
