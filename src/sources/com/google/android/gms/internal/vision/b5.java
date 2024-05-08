package com.google.android.gms.internal.vision;

import com.android.internal.logging.nano.MetricsProto;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b5 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f25436a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f25437b = Charset.forName(CharEncoding.ISO_8859_1);

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f25438c;

    /* renamed from: d, reason: collision with root package name */
    public static final ByteBuffer f25439d;

    /* renamed from: e, reason: collision with root package name */
    public static final f4 f25440e;

    static {
        byte[] bArr = new byte[0];
        f25438c = bArr;
        f25439d = ByteBuffer.wrap(bArr);
        f25440e = f4.b(bArr, 0, bArr.length, false);
    }

    public static int a(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public static int b(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static int c(boolean z10) {
        return z10 ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
    }

    public static <T> T d(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    public static Object e(Object obj, Object obj2) {
        return ((c6) obj).zzp().f((c6) obj2).zze();
    }

    public static <T> T f(T t2, String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }

    public static boolean g(c6 c6Var) {
        if (!(c6Var instanceof n3)) {
            return false;
        }
        return false;
    }

    public static boolean h(byte[] bArr) {
        return s7.f(bArr);
    }

    public static String i(byte[] bArr) {
        return new String(bArr, f25436a);
    }

    public static int j(byte[] bArr) {
        int length = bArr.length;
        int a10 = a(length, bArr, 0, length);
        if (a10 == 0) {
            return 1;
        }
        return a10;
    }
}
