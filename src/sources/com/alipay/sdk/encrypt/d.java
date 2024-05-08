package com.alipay.sdk.encrypt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4612a = "RSA";

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0052: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:30:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            java.lang.String r1 = "RSA"
            java.security.PublicKey r6 = b(r1, r6)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            java.lang.String r1 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            r2 = 1
            r1.init(r2, r6)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            java.lang.String r6 = "UTF-8"
            byte[] r5 = r5.getBytes(r6)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            int r6 = r1.getBlockSize()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            r2.<init>()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            r3 = 0
        L21:
            int r4 = r5.length     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L51
            if (r3 >= r4) goto L35
            int r4 = r5.length     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L51
            int r4 = r4 - r3
            if (r4 >= r6) goto L2b
            int r4 = r5.length     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L51
            int r4 = r4 - r3
            goto L2c
        L2b:
            r4 = r6
        L2c:
            byte[] r4 = r1.doFinal(r5, r3, r4)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L51
            r2.write(r4)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L51
            int r3 = r3 + r6
            goto L21
        L35:
            byte[] r0 = r2.toByteArray()     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L51
            r2.close()     // Catch: java.io.IOException -> L3d
            goto L50
        L3d:
            r5 = move-exception
            com.alipay.sdk.util.c.a(r5)
            goto L50
        L42:
            r5 = move-exception
            goto L48
        L44:
            r5 = move-exception
            goto L53
        L46:
            r5 = move-exception
            r2 = r0
        L48:
            com.alipay.sdk.util.c.a(r5)     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.io.IOException -> L3d
        L50:
            return r0
        L51:
            r5 = move-exception
            r0 = r2
        L53:
            if (r0 == 0) goto L5d
            r0.close()     // Catch: java.io.IOException -> L59
            goto L5d
        L59:
            r6 = move-exception
            com.alipay.sdk.util.c.a(r6)
        L5d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.encrypt.d.a(java.lang.String, java.lang.String):byte[]");
    }

    private static PublicKey b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.a(str2)));
    }
}
