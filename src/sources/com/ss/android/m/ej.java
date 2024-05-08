package com.ss.android.m;

import android.support.v4.media.session.PlaybackStateCompat;
import com.huawei.openalliance.ad.constant.u;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej {

    /* renamed from: m, reason: collision with root package name */
    private static final char[] f38828m = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {
        private int dk;
        private int ej;

        /* renamed from: l, reason: collision with root package name */
        private long f38829l;

        /* renamed from: m, reason: collision with root package name */
        private int f38830m;
        private String np;

        private m() {
        }
    }

    private static String dk(File file, int i10, long j10) throws Exception {
        return m(new com.ss.android.m.m(file), i10, j10);
    }

    public static String m(File file) {
        return m(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    private static long dk(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static String m(File file, int i10, long j10) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return dk(file, i10, j10);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static int m(String str, File file) {
        return m(str, file, (dk) null);
    }

    public static int m(String str, File file, dk dkVar) {
        String str2;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (dkVar != null) {
                if (dkVar.m() <= 0) {
                    try {
                        dkVar.dk();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            int i10 = -1;
            long j10 = -1;
            try {
                m m10 = m(str);
                if (m10 != null) {
                    if (m10.f38830m > 1) {
                        return 3;
                    }
                    i10 = m10.ej;
                    j10 = m10.f38829l;
                }
                m mVar = null;
                try {
                    if (dkVar != null) {
                        str2 = m(dkVar, i10, j10);
                    } else {
                        str2 = dk(file, i10, j10);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    if (m10 != null && (m10.f38830m != 1 || m10.dk != 1)) {
                        if (m10.np != null) {
                            try {
                                mVar = m(str2);
                            } catch (Throwable unused2) {
                            }
                            if (mVar != null && m10.ej == mVar.ej && m10.f38829l == mVar.f38829l && m10.np.equals(mVar.np)) {
                                return 0;
                            }
                        }
                    }
                    return str2.equals(str) ? 0 : 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|32|33|34)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|32|33|34) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x002e, B:16:0x0040, B:18:0x004d, B:21:0x0064, B:22:0x006e, B:31:0x0080), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x002e, B:16:0x0040, B:18:0x004d, B:21:0x0064, B:22:0x006e, B:31:0x0080), top: B:5:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m(com.ss.android.m.dk r21, int r22, long r23) throws java.lang.Exception {
        /*
            r0 = r22
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)
            if (r1 != 0) goto Ld
            java.lang.String r0 = ""
            return r0
        Ld:
            long r9 = r21.m()     // Catch: java.lang.Throwable -> L9c
            r11 = 1
            if (r0 <= 0) goto L2c
            r2 = 0
            int r4 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
            if (r4 <= 0) goto L2c
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L9c
            long r2 = r2 * r23
            r4 = 8
            long r4 = r4 * r9
            r6 = 10
            long r4 = r4 / r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L29
            goto L2c
        L29:
            r12 = r23
            goto L2e
        L2c:
            r12 = r9
            r0 = 1
        L2e:
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r14 = new byte[r2]     // Catch: java.lang.Throwable -> L9c
            r15 = 0
            r2 = r21
            r3 = r1
            r4 = r14
            r5 = r15
            r7 = r12
            m(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
            r2 = 2
            if (r0 <= r2) goto L62
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L9c
            long r2 = r2 * r12
            long r2 = r9 - r2
            int r7 = r0 + (-1)
            long r4 = (long) r7     // Catch: java.lang.Throwable -> L9c
            long r17 = r2 / r4
            r8 = 1
        L4b:
            if (r8 >= r7) goto L62
            long r2 = r12 + r17
            long r15 = r15 + r2
            r2 = r21
            r3 = r1
            r4 = r14
            r5 = r15
            r19 = r7
            r20 = r8
            r7 = r12
            m(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
            int r8 = r20 + 1
            r7 = r19
            goto L4b
        L62:
            if (r0 <= r11) goto L6e
            long r5 = r9 - r12
            r2 = r21
            r3 = r1
            r4 = r14
            r7 = r12
            m(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
        L6e:
            byte[] r1 = r1.digest()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = m(r1)     // Catch: java.lang.Throwable -> L9c
            if (r0 != r11) goto L80
            int r2 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r2 != 0) goto L80
            r21.dk()     // Catch: java.lang.Throwable -> L7f
        L7f:
            return r1
        L80:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r2.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = m(r0, r12)     // Catch: java.lang.Throwable -> L9c
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = ";"
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            r2.append(r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L9c
            r21.dk()     // Catch: java.lang.Throwable -> L9b
        L9b:
            return r0
        L9c:
            r0 = move-exception
            r21.dk()     // Catch: java.lang.Throwable -> La0
        La0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.m.ej.m(com.ss.android.m.dk, int, long):java.lang.String");
    }

    private static void m(dk dkVar, MessageDigest messageDigest, byte[] bArr, long j10, long j11) throws IOException {
        dkVar.m(j10, j11);
        long j12 = 0;
        while (j12 < j11) {
            int m10 = dkVar.m(bArr, 0, (int) Math.min(j11 - j12, bArr.length));
            if (m10 > 0) {
                messageDigest.update(bArr, 0, m10);
                j12 += m10;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + m10 + ", readTotalCount = " + j12 + ", sampleSize = " + j11);
            }
        }
    }

    private static String m(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        int length = bArr.length;
        int i10 = length * 2;
        char[] cArr = new char[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = bArr[i12 + 0] & 255;
            int i14 = i11 + 1;
            char[] cArr2 = f38828m;
            cArr[i11] = cArr2[i13 >> 4];
            i11 = i14 + 1;
            cArr[i14] = cArr2[i13 & 15];
        }
        return new String(cArr, 0, i10);
    }

    private static String m(int i10, long j10) {
        return "ttmd5:1:1:" + m(i10) + "g" + m(j10);
    }

    private static m m(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] split = str.split(";");
        String[] split2 = split[0].split(u.bD);
        m mVar = new m();
        mVar.f38830m = Integer.parseInt(split2[1]);
        if (mVar.f38830m > 1) {
            return mVar;
        }
        mVar.dk = Integer.parseInt(split2[2]);
        String[] split3 = split2[3].split("g");
        mVar.ej = (int) dk(split3[0]);
        mVar.f38829l = dk(split3[1]);
        mVar.np = split[1];
        return mVar;
    }

    private static String m(long j10) {
        return Long.toHexString((j10 << 4) + 31);
    }
}
