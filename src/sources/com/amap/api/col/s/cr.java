package com.amap.api.col.s;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ConstConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cr {

    /* renamed from: a, reason: collision with root package name */
    public static String f7577a = "9aj&#k81";

    /* renamed from: b, reason: collision with root package name */
    public static String f7578b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";

    /* renamed from: c, reason: collision with root package name */
    public static byte[] f7579c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f7580d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f7581e = false;

    /* renamed from: k, reason: collision with root package name */
    private static String f7587k = "ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09";

    /* renamed from: l, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f7588l = new ConcurrentHashMap<>(8);

    /* renamed from: f, reason: collision with root package name */
    public static final Integer f7582f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final Integer f7583g = 2;

    /* renamed from: h, reason: collision with root package name */
    public static final Integer f7584h = 3;

    /* renamed from: i, reason: collision with root package name */
    public static final Integer f7585i = 4;

    /* renamed from: j, reason: collision with root package name */
    public static final Integer f7586j = 5;

    public static byte[] a() {
        if (f7579c == null) {
            f7579c = cb.b(f7587k);
        }
        byte[] bArr = new byte[4];
        System.arraycopy((Object) f7579c, 40, (Object) bArr, 0, 4);
        int i10 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        int i11 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i11];
        System.arraycopy((Object) f7579c, i10, (Object) bArr2, 0, i11);
        return bArr2;
    }

    public static void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                synchronized (f7588l) {
                    if (f7588l == null) {
                        f7588l = new ConcurrentHashMap<>(8);
                    }
                    if (!f7588l.containsKey(str)) {
                        f7588l.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        String str2 = "";
        try {
            synchronized (f7588l) {
                if (f7588l != null && f7588l.containsKey(str)) {
                    str2 = f7588l.get(str);
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }
}
