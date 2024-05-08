package ac;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f732a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f733b;

    /* renamed from: c, reason: collision with root package name */
    public static final HostnameVerifier f734c = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0045 A[Catch: Exception -> 0x0048, TRY_LEAVE, TryCatch #2 {Exception -> 0x0048, blocks: (B:38:0x0040, B:33:0x0045), top: B:37:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.io.InputStream r6) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2d
            r1.<init>()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2d
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3d
        La:
            int r3 = r6.read(r2)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3d
            r4 = -1
            if (r3 == r4) goto L16
            r4 = 0
            r1.write(r2, r4, r3)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3d
            goto La
        L16:
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3d
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3d
            r3.<init>(r2)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3d
            r1.close()     // Catch: java.lang.Exception -> L25
            r6.close()     // Catch: java.lang.Exception -> L25
        L25:
            return r3
        L26:
            r2 = move-exception
            goto L2f
        L28:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3e
        L2d:
            r2 = move-exception
            r1 = r0
        L2f:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L37
            r1.close()     // Catch: java.lang.Exception -> L3c
        L37:
            if (r6 == 0) goto L3c
            r6.close()     // Catch: java.lang.Exception -> L3c
        L3c:
            return r0
        L3d:
            r0 = move-exception
        L3e:
            if (r1 == 0) goto L43
            r1.close()     // Catch: java.lang.Exception -> L48
        L43:
            if (r6 == 0) goto L48
            r6.close()     // Catch: java.lang.Exception -> L48
        L48:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ac.b0.c(java.io.InputStream):java.lang.String");
    }

    public static String d(String str) {
        if (!str.contains(com.huawei.openalliance.ad.constant.u.bD)) {
            return str;
        }
        return "[" + str + "]";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079 A[Catch: all -> 0x01bb, Exception -> 0x01bd, TryCatch #7 {Exception -> 0x01bd, all -> 0x01bb, blocks: (B:19:0x0072, B:21:0x0079, B:22:0x0080, B:67:0x0083), top: B:18:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fc A[Catch: Exception -> 0x01b9, all -> 0x01fc, TRY_ENTER, TryCatch #2 {Exception -> 0x01b9, blocks: (B:25:0x0089, B:28:0x00fc, B:30:0x010a, B:38:0x0131, B:40:0x015f, B:42:0x0167, B:45:0x016f, B:48:0x0177, B:51:0x0192), top: B:24:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0083 A[Catch: all -> 0x01bb, Exception -> 0x01bd, TRY_LEAVE, TryCatch #7 {Exception -> 0x01bd, all -> 0x01bb, blocks: (B:19:0x0072, B:21:0x0079, B:22:0x0080, B:67:0x0083), top: B:18:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(android.content.Context r13, java.lang.String r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ac.b0.a(android.content.Context, java.lang.String, java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0233 A[Catch: all -> 0x02df, TryCatch #3 {, blocks: (B:18:0x0072, B:20:0x0079, B:21:0x0080, B:22:0x0088, B:24:0x00ae, B:25:0x00b6, B:27:0x00bc, B:29:0x00d2, B:32:0x0130, B:34:0x013e, B:40:0x015e, B:42:0x018c, B:44:0x0194, B:46:0x019a, B:48:0x019f, B:50:0x01b7, B:52:0x0083, B:54:0x01dc, B:56:0x0205, B:58:0x020b, B:61:0x0219, B:63:0x0223, B:68:0x0233, B:70:0x0257, B:71:0x0265, B:74:0x026a, B:76:0x0272, B:78:0x028e, B:81:0x02aa), top: B:16:0x0072, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(android.content.Context r18, java.lang.String r19, java.util.HashMap<java.lang.String, java.lang.String> r20, java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ac.b0.b(android.content.Context, java.lang.String, java.util.HashMap, java.lang.Object):java.lang.String");
    }
}
