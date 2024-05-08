package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29496a = "ApkUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, List<String>> f29497b;

    static {
        HashMap hashMap = new HashMap();
        f29497b = hashMap;
        hashMap.put("com.huawei.hwid", Arrays.asList("b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05"));
        hashMap.put("com.huawei.hms", Arrays.asList("e49d5c2c0e11b3b1b96ca56c6de2a14ec7dab5ccc3b5f300d03e5b4dba44f539"));
        hashMap.put("com.huawei.hwid.tv", Arrays.asList("3517262215d8d3008cbf888750b6418edc4d562ac33ed6874e0d73aba667bc3c"));
    }

    public static String a(Context context, String str) {
        byte[] b4 = b(context, str);
        if (b4 == null || b4.length == 0) {
            return null;
        }
        return z.a(ad.a(b4));
    }

    public static boolean a(Context context) {
        String str = "com.huawei.hwid";
        if (!c(context, "com.huawei.hwid")) {
            if (c(context, "com.huawei.hms")) {
                str = "com.huawei.hms";
            } else if (c(context, "com.huawei.hwid.tv")) {
                str = "com.huawei.hwid.tv";
            }
        }
        byte[] f10 = f(context, str);
        return a(f29497b.get(str), (f10 == null || f10.length == 0) ? null : z.a(ad.a(f10)));
    }

    public static boolean a(List<String> list, String str) {
        if (list != null && !TextUtils.isEmpty(str)) {
            Iterator<String> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (str.equalsIgnoreCase(iterator2.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static byte[] a(PackageInfo packageInfo) {
        ByteArrayInputStream byteArrayInputStream = null;
        if (packageInfo != null) {
            try {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr.length > 0) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(signatureArr[0].toByteArray());
                    try {
                        byte[] encoded = CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f29912b).generateCertificate(byteArrayInputStream2).getEncoded();
                        ae.a(byteArrayInputStream2);
                        return encoded;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream = byteArrayInputStream2;
                        try {
                            aa.d(f29496a, "getPackageSignatureBytes Exception:" + th.getClass().getSimpleName());
                            ae.a(byteArrayInputStream);
                            aa.b(f29496a, "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Throwable th2) {
                            ae.a(byteArrayInputStream);
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        ae.a(byteArrayInputStream);
        aa.b(f29496a, "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    private static String b(Context context) {
        return c(context, "com.huawei.hwid") ? "com.huawei.hwid" : c(context, "com.huawei.hms") ? "com.huawei.hms" : c(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    private static byte[] b(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return a(packageManager.getPackageArchiveInfo(str, 64));
            }
        } catch (Throwable th) {
            aa.d(f29496a, "getPackageSignatureBytesByPath RuntimeException:" + th.getClass().getSimpleName());
        }
        return new byte[0];
    }

    private static boolean c(Context context, String str) {
        return d(context, str) != null;
    }

    private static PackageInfo d(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (Throwable unused) {
            aa.c(f29496a, "getPackageInfo Exception");
            return null;
        }
    }

    private static String e(Context context, String str) {
        byte[] f10 = f(context, str);
        if (f10 == null || f10.length == 0) {
            return null;
        }
        return z.a(ad.a(f10));
    }

    private static byte[] f(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return a(packageManager.getPackageInfo(str, 64));
            }
        } catch (Throwable th) {
            aa.d(f29496a, "getPackageSignatureBytes RuntimeException:" + th.getClass().getSimpleName());
        }
        return new byte[0];
    }
}
