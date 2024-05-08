package com.huawei.hms.scankit.p;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.hmsscankit.WriterException;
import java.io.ObjectStreamConstants;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import okio.Utf8;
import sun.security.util.DerValue;

/* compiled from: PDF417HighLevelEncoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class q5 {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f31427c;

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f31425a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, ExifInterface.START_CODE, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f31426b = {59, 60, 62, DerValue.TAG_APPLICATION, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, ObjectStreamConstants.TC_LONGSTRING, ExifInterface.START_CODE, 40, 41, Utf8.REPLACEMENT_BYTE, ObjectStreamConstants.TC_EXCEPTION, ObjectStreamConstants.TC_PROXYCLASSDESC, 39, 0};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f31428d = new byte[128];

    /* renamed from: e, reason: collision with root package name */
    private static final Charset f31429e = StandardCharsets.ISO_8859_1;

    /* compiled from: PDF417HighLevelEncoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31430a;

        static {
            int[] iArr = new int[y0.values().length];
            f31430a = iArr;
            try {
                iArr[y0.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31430a[y0.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31430a[y0.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        byte[] bArr = new byte[128];
        f31427c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr2 = f31425a;
            if (i11 >= bArr2.length) {
                break;
            }
            byte b4 = bArr2[i11];
            if (b4 > 0) {
                f31427c[b4] = (byte) i11;
            }
            i11++;
        }
        Arrays.fill(f31428d, (byte) -1);
        while (true) {
            byte[] bArr3 = f31426b;
            if (i10 >= bArr3.length) {
                return;
            }
            byte b10 = bArr3[i10];
            if (b10 > 0) {
                f31428d[b10] = (byte) i10;
            }
            i10++;
        }
    }

    public static String a(String str, y0 y0Var, Charset charset) throws WriterException {
        StringBuilder sb2 = new StringBuilder(str.length());
        if (charset == null) {
            charset = f31429e;
        } else if (!f31429e.equals(charset)) {
            o0 a10 = o0.a(charset.name());
            if (a10 != null) {
                a(a10.a(), sb2);
            }
        } else {
            o4.a("PDF417", "else");
        }
        int length = str.length();
        int i10 = a.f31430a[y0Var.ordinal()];
        if (i10 == 1) {
            a(str, 0, length, sb2, 0);
        } else if (i10 == 2) {
            byte[] bytes = str.getBytes(charset);
            a(bytes, 0, bytes.length, 1, sb2);
        } else if (i10 != 3) {
            int i11 = 0;
            int i12 = 0;
            loop0: while (true) {
                int i13 = 0;
                while (i11 < length) {
                    int a11 = a(str, i11);
                    if (a11 >= 13) {
                        sb2.append((char) 902);
                        a(str, i11, a11, sb2);
                        i11 += a11;
                        i12 = 2;
                    } else {
                        int b4 = b(str, i11);
                        if (b4 < 5 && a11 != length) {
                            int a12 = a(str, i11, charset);
                            if (a12 == 0) {
                                a12 = 1;
                            }
                            int i14 = a12 + i11;
                            byte[] bytes2 = str.substring(i11, i14).getBytes(charset);
                            if (bytes2.length == 1 && i12 == 0) {
                                a(bytes2, 0, 1, 0, sb2);
                                i11 = i14;
                            } else {
                                a(bytes2, 0, bytes2.length, i12, sb2);
                                i11 = i14;
                                i12 = 1;
                            }
                        } else {
                            if (i12 != 0) {
                                sb2.append((char) 900);
                                i12 = 0;
                                i13 = 0;
                            }
                            i13 = a(str, i11, b4, sb2, i13);
                            i11 += b4;
                        }
                    }
                }
                break loop0;
            }
        } else {
            sb2.append((char) 902);
            a(str, 0, length, sb2);
        }
        return sb2.toString();
    }

    private static boolean a(char c4) {
        return c4 == ' ' || (c4 >= 'a' && c4 <= 'z');
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0027, code lost:
    
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(java.lang.CharSequence r6, int r7) {
        /*
            int r0 = r6.length()
            r1 = r7
        L5:
            if (r1 >= r0) goto L39
            char r2 = r6.charAt(r1)
            r3 = 0
        Lc:
            r4 = 13
            if (r3 >= r4) goto L23
            boolean r5 = c(r2)
            if (r5 == 0) goto L23
            if (r1 >= r0) goto L23
            int r3 = r3 + 1
            int r1 = r1 + 1
            if (r1 >= r0) goto Lc
            char r2 = r6.charAt(r1)
            goto Lc
        L23:
            if (r3 < r4) goto L28
            int r1 = r1 - r7
            int r1 = r1 - r3
            return r1
        L28:
            if (r3 <= 0) goto L2b
            goto L5
        L2b:
            char r2 = r6.charAt(r1)
            boolean r2 = f(r2)
            if (r2 != 0) goto L36
            goto L39
        L36:
            int r1 = r1 + 1
            goto L5
        L39:
            int r1 = r1 - r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q5.b(java.lang.CharSequence, int):int");
    }

    private static boolean b(char c4) {
        return c4 == ' ' || (c4 >= 'A' && c4 <= 'Z');
    }

    private static boolean c(char c4) {
        return c4 >= '0' && c4 <= '9';
    }

    private static boolean d(char c4) {
        try {
            byte[] bArr = f31427c;
            if (w7.a(bArr, (int) c4)) {
                return bArr[c4] != -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    private static boolean e(char c4) {
        try {
            if (w7.a(f31427c, (int) c4)) {
                return f31428d[c4] != -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    private static boolean f(char c4) {
        return c4 == '\t' || c4 == '\n' || c4 == '\r' || (c4 >= ' ' && c4 <= '~');
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f6 A[EDGE_INSN: B:21:0x00f6->B:22:0x00f6 BREAK  A[LOOP:0: B:2:0x0011->B:16:0x0011], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0011 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q5.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void a(byte[] bArr, int i10, int i11, int i12, StringBuilder sb2) {
        int i13;
        if (i11 == 1 && i12 == 0) {
            sb2.append((char) 913);
        } else if (i11 % 6 == 0) {
            sb2.append((char) 924);
        } else {
            sb2.append((char) 901);
        }
        if (i11 >= 6) {
            char[] cArr = new char[5];
            i13 = i10;
            while ((i10 + i11) - i13 >= 6) {
                long j10 = 0;
                for (int i14 = 0; i14 < 6; i14++) {
                    j10 = (j10 << 8) + (bArr[i13 + i14] & 255);
                }
                for (int i15 = 0; i15 < 5; i15++) {
                    cArr[i15] = (char) (j10 % 900);
                    j10 /= 900;
                }
                for (int i16 = 4; i16 >= 0; i16--) {
                    sb2.append(cArr[i16]);
                }
                i13 += 6;
            }
        } else {
            i13 = i10;
        }
        while (i13 < i10 + i11) {
            sb2.append((char) (bArr[i13] & 255));
            i13++;
        }
    }

    private static void a(String str, int i10, int i11, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder((i11 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i12 = 0;
        while (i12 < i11) {
            sb3.setLength(0);
            int min = Math.min(44, i11 - i12);
            if (str.length() > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append('1');
                int i13 = i10 + i12;
                sb4.append(str.substring(i13, i13 + min));
                BigInteger bigInteger = new BigInteger(sb4.toString());
                do {
                    sb3.append((char) bigInteger.mod(valueOf).intValue());
                    bigInteger = bigInteger.divide(valueOf);
                } while (!bigInteger.equals(valueOf2));
            }
            for (int length = sb3.length() - 1; length >= 0; length--) {
                sb2.append(sb3.charAt(length));
            }
            i12 += min;
        }
    }

    private static int a(CharSequence charSequence, int i10) {
        return d4.a(charSequence, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.lang.String r5, int r6, java.nio.charset.Charset r7) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L9:
            if (r1 >= r0) goto L5b
            char r2 = r5.charAt(r1)
            r3 = 0
        L10:
            r4 = 13
            if (r3 >= r4) goto L26
            boolean r2 = c(r2)
            if (r2 == 0) goto L26
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 < r0) goto L21
            goto L26
        L21:
            char r2 = r5.charAt(r2)
            goto L10
        L26:
            if (r3 < r4) goto L2a
            int r1 = r1 - r6
            return r1
        L2a:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 == 0) goto L37
            int r1 = r1 + 1
            goto L9
        L37:
            com.huawei.hms.hmsscankit.WriterException r5 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Non-encodable character detected: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L5b:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q5.a(java.lang.String, int, java.nio.charset.Charset):int");
    }

    private static void a(int i10, StringBuilder sb2) throws WriterException {
        if (i10 >= 0 && i10 < 900) {
            sb2.append((char) 927);
            sb2.append((char) i10);
            return;
        }
        if (i10 < 810900) {
            sb2.append((char) 926);
            sb2.append((char) ((i10 / 900) - 1));
            sb2.append((char) (i10 % 900));
        } else if (i10 < 811800) {
            sb2.append((char) 925);
            sb2.append((char) (810900 - i10));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i10);
        }
    }
}
