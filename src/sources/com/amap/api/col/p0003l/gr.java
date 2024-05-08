package com.amap.api.col.p0003l;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: SecurityUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gr {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f6134a;

    /* renamed from: b, reason: collision with root package name */
    private static String[] f6135b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};

    /* renamed from: c, reason: collision with root package name */
    private static int[] f6136c = null;

    private static int a(int i10, int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 = (i12 >> 1) | Integer.MIN_VALUE;
        }
        return (i10 << i11) | ((i10 & i12) >>> (32 - i11));
    }

    public static String a(String str) {
        return fq.b(str);
    }

    private static int b(int i10) {
        int i11 = 1;
        for (int i12 = 0; i12 < 15; i12++) {
            i11 = (i11 << 2) | 1;
        }
        return ((i10 & i11) << 1) | (((i11 << 1) & i10) >>> 1);
    }

    private static int[] b() {
        int[] iArr = f6136c;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[8];
        int i10 = 0;
        while (true) {
            String[] strArr = f6135b;
            if (i10 >= strArr.length) {
                return iArr2;
            }
            byte[] b4 = fn.b(strArr[i10]);
            iArr2[i10] = ((b4[0] & 255) << 24) | (b4[3] & 255) | ((b4[2] & 255) << 8) | ((b4[1] & 255) << 16);
            i10++;
        }
    }

    public static String a() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(fv.c("EQUVT"));
            keyGenerator.init(128, secureRandom);
            return gm.a(keyGenerator.generateKey().getEncoded());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            return gm.a(a(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(byte[] bArr) {
        try {
            if (f6134a == null) {
                f6134a = fv.c("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f6134a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(b()).getBytes("UTF-8"), fv.c("EQUVT"));
            Cipher cipher = Cipher.getInstance(fv.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        if (iArr != null) {
            for (int i10 = 0; i10 < iArr.length; i10++) {
                sb2.append(a(a(b(iArr[i10]), i10)));
            }
        }
        return sb2.toString();
    }

    private static String a(int i10) {
        char[] cArr = new char[4];
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = (4 - i11) - 1;
            cArr[i12] = (char) ((i10 >>> (i11 * 8)) & 255);
            char c4 = cArr[i12];
            String str = " ";
            for (int i13 = 0; i13 < 32; i13++) {
                str = str + (((Integer.MIN_VALUE >>> i13) & c4) >>> (31 - i13));
            }
        }
        return new String(cArr);
    }
}
