package p0;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        if (r1 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.Integer, java.nio.ByteBuffer> a(java.io.File r3) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L3a
            java.lang.String r2 = "r"
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L3a
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L28
            p0.c r2 = p0.b.i(r3)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            java.lang.Object r2 = r2.a()     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            java.util.Map r0 = p0.b.e(r2)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            if (r3 == 0) goto L1f
            r3.close()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L46
        L1f:
            r1.close()     // Catch: java.lang.Throwable -> L46
            goto L46
        L23:
            r2 = move-exception
            goto L2d
        L25:
            r2 = move-exception
            r3 = r0
            goto L2d
        L28:
            r3 = r0
            goto L3c
        L2a:
            r2 = move-exception
            r3 = r0
            r1 = r3
        L2d:
            if (r3 == 0) goto L34
            r3.close()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L46
            goto L34
        L33:
        L34:
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L46
        L39:
            throw r2     // Catch: java.lang.Throwable -> L46
        L3a:
            r3 = r0
            r1 = r3
        L3c:
            if (r3 == 0) goto L43
            r3.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L46
            goto L43
        L42:
        L43:
            if (r1 == 0) goto L46
            goto L1f
        L46:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.d.a(java.io.File):java.util.Map");
    }

    public static byte[] b(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, arrayOffset + byteBuffer.limit());
    }

    public static String[] c(File file, int[] iArr) {
        byte[][] d10 = d(file, iArr);
        if (d10 == null) {
            return null;
        }
        String[] strArr = new String[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            try {
                if (d10[i10] != null) {
                    strArr[i10] = new String(d10[i10], "UTF-8");
                } else {
                    strArr[i10] = "";
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return strArr;
    }

    public static byte[][] d(File file, int[] iArr) {
        Map<Integer, ByteBuffer> a10 = a(file);
        if (a10 == null || iArr.length <= 0) {
            return null;
        }
        byte[][] bArr = new byte[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            ByteBuffer byteBuffer = a10.get(Integer.valueOf(iArr[i10]));
            if (byteBuffer != null) {
                bArr[i10] = b(byteBuffer);
            }
        }
        return bArr;
    }
}
