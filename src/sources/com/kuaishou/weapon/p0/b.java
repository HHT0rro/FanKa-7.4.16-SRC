package com.kuaishou.weapon.p0;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f35814a = "AES/CBC/NoPadding";

    /* renamed from: b, reason: collision with root package name */
    public static final int f35815b = 16;

    /* renamed from: c, reason: collision with root package name */
    public static final String f35816c = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";

    /* renamed from: d, reason: collision with root package name */
    private static final String f35817d = "AES/CBC/PKCS5Padding";

    /* renamed from: e, reason: collision with root package name */
    private static final String f35818e = "AES";

    /* renamed from: f, reason: collision with root package name */
    private static final String f35819f = "AES/CBC/PKCS7Padding";

    public static byte[] a(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(f35817d);
        cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(f35817d);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0098, code lost:
    
        if (r8 == null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            r0 = -1
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L9c
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L9c
            int r9 = r1.length()     // Catch: java.lang.Throwable -> L9c
            r2 = 0
            r3 = 16
            if (r9 >= r3) goto L2a
            int r9 = r1.length()     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L9c
            r1 = 0
        L19:
            int r5 = 16 - r9
            if (r1 >= r5) goto L25
            java.lang.String r5 = "0"
            r4.append(r5)     // Catch: java.lang.Throwable -> L9c
            int r1 = r1 + 1
            goto L19
        L25:
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L9c
            goto L34
        L2a:
            int r9 = r1.length()     // Catch: java.lang.Throwable -> L9c
            if (r9 <= r3) goto L34
            java.lang.String r1 = r1.substring(r2, r3)     // Catch: java.lang.Throwable -> L9c
        L34:
            r9 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L88
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L88
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L86
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L86
            javax.crypto.spec.SecretKeySpec r8 = new javax.crypto.spec.SecretKeySpec     // Catch: java.lang.Throwable -> L83
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L83
            java.lang.String r5 = "AES"
            r8.<init>(r1, r5)     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch: java.lang.Throwable -> L83
            byte[] r5 = new byte[r3]     // Catch: java.lang.Throwable -> L83
            r6 = 0
        L53:
            if (r6 >= r3) goto L5a
            r5[r6] = r2     // Catch: java.lang.Throwable -> L83
            int r6 = r6 + 1
            goto L53
        L5a:
            javax.crypto.spec.IvParameterSpec r3 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Throwable -> L83
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L83
            r5 = 2
            r1.init(r5, r8, r3)     // Catch: java.lang.Throwable -> L83
            javax.crypto.CipherInputStream r8 = new javax.crypto.CipherInputStream     // Catch: java.lang.Throwable -> L83
            r8.<init>(r4, r1)     // Catch: java.lang.Throwable -> L83
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r9]     // Catch: java.lang.Throwable -> L84
        L6c:
            int r1 = r8.read(r9)     // Catch: java.lang.Throwable -> L84
            if (r1 == r0) goto L76
            r7.write(r9, r2, r1)     // Catch: java.lang.Throwable -> L84
            goto L6c
        L76:
            r8.close()     // Catch: java.lang.Throwable -> L84
            r7.close()     // Catch: java.io.IOException -> L7c java.lang.Throwable -> L9c
        L7c:
            r4.close()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> L9c
        L7f:
            r8.close()     // Catch: java.io.IOException -> L9b java.lang.Throwable -> L9c
            goto L9b
        L83:
            r8 = r9
        L84:
            r9 = r7
            goto L8a
        L86:
            r8 = r9
            goto L8a
        L88:
            r8 = r9
            r4 = r8
        L8a:
            if (r9 == 0) goto L91
            r9.close()     // Catch: java.io.IOException -> L90 java.lang.Throwable -> L9c
            goto L91
        L90:
        L91:
            if (r4 == 0) goto L98
            r4.close()     // Catch: java.io.IOException -> L97 java.lang.Throwable -> L9c
            goto L98
        L97:
        L98:
            if (r8 == 0) goto L9b
            goto L7f
        L9b:
            return r2
        L9c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.b.c(java.lang.String, java.lang.String, byte[]):int");
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z10) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance(f35817d);
            byte[] bArr3 = new byte[16];
            for (int i10 = 0; i10 < 16; i10++) {
                bArr3[i10] = 0;
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            if (z10) {
                byte[] bArr4 = new byte[bArr2.length - 16];
                System.arraycopy((Object) bArr2, 0, (Object) bArr4, 0, bArr2.length - 16);
                bArr2 = bArr4;
            }
            return cipher.doFinal(bArr2);
        } catch (Throwable th) {
            System.out.println(th.getMessage());
            return null;
        }
    }
}
