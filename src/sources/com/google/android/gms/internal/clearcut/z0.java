package com.google.android.gms.internal.clearcut;

import com.android.internal.logging.nano.MetricsProto;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f24119a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f24120b = Charset.forName(CharEncoding.ISO_8859_1);

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f24121c;

    /* renamed from: d, reason: collision with root package name */
    public static final ByteBuffer f24122d;

    /* renamed from: e, reason: collision with root package name */
    public static final e0 f24123e;

    static {
        byte[] bArr = new byte[0];
        f24121c = bArr;
        f24122d = ByteBuffer.wrap(bArr);
        f24123e = e0.b(bArr, 0, bArr.length, false);
    }

    public static <T> T a(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        int c4 = c(length, bArr, 0, length);
        if (c4 == 0) {
            return 1;
        }
        return c4;
    }

    public static int c(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public static Object d(Object obj, Object obj2) {
        return ((a2) obj).a().H((a2) obj2).G();
    }

    public static <T> T e(T t2, String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }

    public static int f(boolean z10) {
        return z10 ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
    }

    public static boolean g(byte[] bArr) {
        return r3.h(bArr);
    }

    public static String h(byte[] bArr) {
        return new String(bArr, f24119a);
    }

    public static boolean i(a2 a2Var) {
        return false;
    }

    public static int j(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }
}
