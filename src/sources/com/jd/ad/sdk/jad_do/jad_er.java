package com.jd.ad.sdk.jad_do;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_er {
    public static final char[] jad_an = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String jad_an(String str) {
        byte[] decode;
        return (TextUtils.isEmpty(str) || (decode = Base64.decode(str.getBytes(), 10)) == null) ? "" : new String(decode);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033 A[LOOP:0: B:15:0x0031->B:16:0x0033, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_bo(java.lang.String r7) {
        /*
            java.lang.String r0 = ""
            if (r7 == 0) goto L54
            int r1 = r7.length()
            if (r1 != 0) goto Lb
            goto L54
        Lb:
            byte[] r7 = r7.getBytes()
            java.lang.String r1 = "MD5"
            if (r7 == 0) goto L23
            int r2 = r7.length
            if (r2 > 0) goto L17
            goto L23
        L17:
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch: java.security.NoSuchAlgorithmException -> L23
            r1.update(r7)     // Catch: java.security.NoSuchAlgorithmException -> L23
            byte[] r7 = r1.digest()     // Catch: java.security.NoSuchAlgorithmException -> L23
            goto L24
        L23:
            r7 = 0
        L24:
            if (r7 != 0) goto L27
            goto L54
        L27:
            int r1 = r7.length
            if (r1 > 0) goto L2b
            goto L54
        L2b:
            int r0 = r1 << 1
            char[] r0 = new char[r0]
            r2 = 0
            r3 = 0
        L31:
            if (r2 >= r1) goto L4e
            int r4 = r3 + 1
            char[] r5 = com.jd.ad.sdk.jad_do.jad_er.jad_an
            r6 = r7[r2]
            int r6 = r6 >> 4
            r6 = r6 & 15
            char r6 = r5[r6]
            r0[r3] = r6
            int r3 = r4 + 1
            r6 = r7[r2]
            r6 = r6 & 15
            char r5 = r5[r6]
            r0[r4] = r5
            int r2 = r2 + 1
            goto L31
        L4e:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r0)
            r0 = r7
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_do.jad_er.jad_bo(java.lang.String):java.lang.String");
    }
}
