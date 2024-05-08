package com.amap.api.col.p0003l;

/* compiled from: AESMD5Util.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fh {

    /* renamed from: a, reason: collision with root package name */
    private static int f5752a = 6;

    private static byte[] a() {
        try {
            return a("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");
        } catch (Throwable th) {
            gy.b(th, "AMU", "grk");
            return null;
        }
    }

    private static byte[] b() {
        try {
            return a("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");
        } catch (Throwable th) {
            gy.b(th, "AMU", "giv");
            return null;
        }
    }

    private static byte[] a(String str) {
        try {
            String[] split = new StringBuffer(str).reverse().toString().split(",");
            int length = split.length;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                bArr[i10] = Byte.parseByte(split[i10]);
            }
            String[] split2 = new StringBuffer(new String(gm.a(new String(bArr)), "UTF-8")).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i11 = 0; i11 < split2.length; i11++) {
                bArr2[i11] = Byte.parseByte(split2[i11]);
            }
            return bArr2;
        } catch (Throwable th) {
            gy.b(th, "AMU", "rcs");
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return fn.a(a(), bArr, b());
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return fn.b(a(), bArr, b());
        } catch (Throwable unused) {
            return new byte[0];
        }
    }
}
