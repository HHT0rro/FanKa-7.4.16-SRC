package com.jd.ad.sdk.jad_do;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_dq {
    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException
        */
    /* JADX WARN: Failed to calculate best type for var: r3v0 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v1 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v10 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v11 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v12 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v2 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v3 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v5 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v6 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v7 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v8 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v9 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0086: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:75:0x0085 */
    public static java.lang.String jad_an() {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.String r2 = "/proc/meminfo"
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46 java.io.IOException -> L58 java.io.FileNotFoundException -> L6a
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46 java.io.IOException -> L58 java.io.FileNotFoundException -> L6a
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            r4 = 4096(0x1000, float:5.74E-42)
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c java.io.IOException -> L31 java.io.FileNotFoundException -> L36
            java.lang.String r4 = "\\s+"
            java.lang.String[] r1 = r1.split(r4)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c java.io.IOException -> L31 java.io.FileNotFoundException -> L36
            r4 = 1
            r0 = r1[r4]     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c java.io.IOException -> L31 java.io.FileNotFoundException -> L36
            r2.close()     // Catch: java.io.IOException -> L23
            goto L7b
        L23:
            r1 = move-exception
            r1.printStackTrace()
            goto L7b
        L29:
            r0 = move-exception
            goto L88
        L2c:
            r1 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L48
        L31:
            r1 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L5a
        L36:
            r1 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L6c
        L3b:
            r0 = move-exception
            goto L89
        L3d:
            r2 = move-exception
            goto L48
        L3f:
            r2 = move-exception
            goto L5a
        L41:
            r2 = move-exception
            goto L6c
        L43:
            r0 = move-exception
            r3 = r1
            goto L89
        L46:
            r2 = move-exception
            r3 = r1
        L48:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto L55
            r1.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r1 = move-exception
            r1.printStackTrace()
        L55:
            if (r3 == 0) goto L83
            goto L7b
        L58:
            r2 = move-exception
            r3 = r1
        L5a:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto L67
            r1.close()     // Catch: java.io.IOException -> L63
            goto L67
        L63:
            r1 = move-exception
            r1.printStackTrace()
        L67:
            if (r3 == 0) goto L83
            goto L7b
        L6a:
            r2 = move-exception
            r3 = r1
        L6c:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto L79
            r1.close()     // Catch: java.io.IOException -> L75
            goto L79
        L75:
            r1 = move-exception
            r1.printStackTrace()
        L79:
            if (r3 == 0) goto L83
        L7b:
            r3.close()     // Catch: java.io.IOException -> L7f
            goto L83
        L7f:
            r1 = move-exception
            r1.printStackTrace()
        L83:
            return r0
        L84:
            r0 = move-exception
            r2 = r1
            r1 = r3
            r3 = r1
        L88:
            r1 = r2
        L89:
            if (r1 == 0) goto L93
            r1.close()     // Catch: java.io.IOException -> L8f
            goto L93
        L8f:
            r1 = move-exception
            r1.printStackTrace()
        L93:
            if (r3 == 0) goto L9d
            r3.close()     // Catch: java.io.IOException -> L99
            goto L9d
        L99:
            r1 = move-exception
            r1.printStackTrace()
        L9d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_do.jad_dq.jad_an():java.lang.String");
    }
}
