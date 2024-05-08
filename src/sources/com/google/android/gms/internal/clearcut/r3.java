package com.google.android.gms.internal.clearcut;

import com.android.internal.os.PowerProfile;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r3 {

    /* renamed from: a, reason: collision with root package name */
    public static final s3 f24041a;

    static {
        f24041a = p3.x() && p3.y() ? new u3() : new t3();
    }

    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
                i11++;
            } else {
                int length2 = charSequence.length();
                while (i11 < length2) {
                    char charAt2 = charSequence.charAt(i11);
                    if (charAt2 < 2048) {
                        i10 += (127 - charAt2) >>> 31;
                    } else {
                        i10 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i11) < 65536) {
                                throw new zzfi(i11, length2);
                            }
                            i11++;
                        }
                    }
                    i11++;
                }
                i12 += i10;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        long j10 = i12 + PowerProfile.SUBSYSTEM_MODEM;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j10);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int b(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        return f24041a.b(charSequence, bArr, i10, i11);
    }

    public static void c(CharSequence charSequence, ByteBuffer byteBuffer) {
        s3 s3Var = f24041a;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(b(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            s3Var.c(charSequence, byteBuffer);
        } else {
            s3.d(charSequence, byteBuffer);
        }
    }

    public static int d(int i10) {
        if (i10 > -12) {
            return -1;
        }
        return i10;
    }

    public static int f(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }

    public static boolean h(byte[] bArr) {
        return f24041a.e(bArr, 0, bArr.length);
    }

    public static boolean i(byte[] bArr, int i10, int i11) {
        return f24041a.e(bArr, i10, i11);
    }

    public static int j(byte[] bArr, int i10, int i11) {
        byte b4 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 == 0) {
            return d(b4);
        }
        if (i12 == 1) {
            return l(b4, bArr[i10]);
        }
        if (i12 == 2) {
            return f(b4, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }

    public static int l(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }
}
