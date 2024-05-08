package com.alipay.sdk.packet;

import com.alipay.sdk.util.n;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4625a;

    /* renamed from: b, reason: collision with root package name */
    private String f4626b = n.a(24);

    public c(boolean z10) {
        this.f4625a = z10;
    }

    private static byte[] b(String str, byte[] bArr) {
        return com.alipay.sdk.encrypt.e.b(str, bArr);
    }

    public d a(b bVar, boolean z10) {
        byte[] a10;
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.a().getBytes();
        byte[] bytes2 = bVar.b().getBytes();
        if (z10) {
            try {
                bytes2 = com.alipay.sdk.encrypt.c.a(bytes2);
            } catch (Exception unused) {
                z10 = false;
            }
        }
        if (this.f4625a) {
            a10 = a(bytes, a(this.f4626b, com.alipay.sdk.cons.a.f4520c), a(this.f4626b, bytes2));
        } else {
            a10 = a(bytes, bytes2);
        }
        return new d(z10, a10);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alipay.sdk.packet.b a(com.alipay.sdk.packet.d r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            byte[] r2 = r6.b()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r2 = 5
            byte[] r3 = new byte[r2]     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L77
            r1.read(r3)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L77
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L77
            r4.<init>(r3)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L77
            int r3 = a(r4)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L77
            byte[] r3 = new byte[r3]     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L77
            r1.read(r3)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L77
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L77
            r4.<init>(r3)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L77
            byte[] r2 = new byte[r2]     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            r1.read(r2)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            r3.<init>(r2)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            int r2 = a(r3)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            if (r2 <= 0) goto L52
            byte[] r2 = new byte[r2]     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            r1.read(r2)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            boolean r3 = r5.f4625a     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            if (r3 == 0) goto L42
            java.lang.String r3 = r5.f4626b     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            byte[] r2 = b(r3, r2)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
        L42:
            boolean r6 = r6.a()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            if (r6 == 0) goto L4c
            byte[] r2 = com.alipay.sdk.encrypt.c.b(r2)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
        L4c:
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            r6.<init>(r2)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L77
            goto L53
        L52:
            r6 = r0
        L53:
            r1.close()     // Catch: java.lang.Exception -> L57
            goto L6c
        L57:
            goto L6c
        L59:
            r6 = move-exception
            goto L63
        L5b:
            r6 = move-exception
            r4 = r0
            goto L63
        L5e:
            r6 = move-exception
            goto L79
        L60:
            r6 = move-exception
            r1 = r0
            r4 = r1
        L63:
            com.alipay.sdk.util.c.a(r6)     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L6b
            r1.close()     // Catch: java.lang.Exception -> L6b
        L6b:
            r6 = r0
        L6c:
            if (r4 != 0) goto L71
            if (r6 != 0) goto L71
            return r0
        L71:
            com.alipay.sdk.packet.b r0 = new com.alipay.sdk.packet.b
            r0.<init>(r4, r6)
            return r0
        L77:
            r6 = move-exception
            r0 = r1
        L79:
            if (r0 == 0) goto L7e
            r0.close()     // Catch: java.lang.Exception -> L7e
        L7e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.c.a(com.alipay.sdk.packet.d):com.alipay.sdk.packet.b");
    }

    private static byte[] a(String str, String str2) {
        return com.alipay.sdk.encrypt.d.a(str, str2);
    }

    private static byte[] a(String str, byte[] bArr) {
        return com.alipay.sdk.encrypt.e.a(str, bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        if (r2 == null) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(byte[]... r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L63
            int r1 = r7.length
            if (r1 != 0) goto L8
            goto L63
        L8:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r1.<init>()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r3 = r7.length     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L54
            r4 = 0
        L14:
            if (r4 >= r3) goto L2a
            r5 = r7[r4]     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L54
            int r6 = r5.length     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L54
            java.lang.String r6 = a(r6)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L54
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L54
            r2.write(r6)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L54
            r2.write(r5)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L54
            int r4 = r4 + 1
            goto L14
        L2a:
            r2.flush()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L54
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L54
            r1.close()     // Catch: java.lang.Exception -> L34
        L34:
            r2.close()     // Catch: java.lang.Exception -> L53
            goto L53
        L38:
            r7 = move-exception
            goto L46
        L3a:
            r7 = move-exception
            r2 = r0
            goto L55
        L3d:
            r7 = move-exception
            r2 = r0
            goto L46
        L40:
            r7 = move-exception
            r2 = r0
            goto L56
        L43:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L46:
            com.alipay.sdk.util.c.a(r7)     // Catch: java.lang.Throwable -> L54
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.lang.Exception -> L4f
            goto L50
        L4f:
        L50:
            if (r2 == 0) goto L53
            goto L34
        L53:
            return r0
        L54:
            r7 = move-exception
        L55:
            r0 = r1
        L56:
            if (r0 == 0) goto L5d
            r0.close()     // Catch: java.lang.Exception -> L5c
            goto L5d
        L5c:
        L5d:
            if (r2 == 0) goto L62
            r2.close()     // Catch: java.lang.Exception -> L62
        L62:
            throw r7
        L63:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.c.a(byte[][]):byte[]");
    }

    private static String a(int i10) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i10));
    }

    private static int a(String str) {
        return Integer.parseInt(str);
    }
}
