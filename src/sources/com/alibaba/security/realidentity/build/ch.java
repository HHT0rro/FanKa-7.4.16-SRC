package com.alibaba.security.realidentity.build;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: HmacSHA1Signature.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ch {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3337a = "UTF-8";

    /* renamed from: b, reason: collision with root package name */
    private static final String f3338b = "HmacSHA1";

    /* renamed from: c, reason: collision with root package name */
    private static final String f3339c = "1";

    /* renamed from: d, reason: collision with root package name */
    private static final Object f3340d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static Mac f3341e;

    private static String a() {
        return f3338b;
    }

    public static String a(String str, String str2) {
        cd.c(f3338b);
        cd.c("1");
        try {
            cd.b("sign start");
            byte[] a10 = a(str.getBytes("UTF-8"), str2.getBytes("UTF-8"));
            cd.b("base64 start");
            return cp.a(a10);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("Unsupported algorithm: UTF-8");
        }
    }

    private static String b() {
        return "1";
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        Mac mac;
        try {
            if (f3341e == null) {
                synchronized (f3340d) {
                    if (f3341e == null) {
                        f3341e = Mac.getInstance(f3338b);
                    }
                }
            }
            try {
                mac = (Mac) f3341e.clone();
            } catch (CloneNotSupportedException unused) {
                mac = Mac.getInstance(f3338b);
            }
            mac.init(new SecretKeySpec(bArr, f3338b));
            return mac.doFinal(bArr2);
        } catch (InvalidKeyException unused2) {
            throw new RuntimeException("key must not be null");
        } catch (NoSuchAlgorithmException unused3) {
            throw new RuntimeException("Unsupported algorithm: HmacSHA1");
        }
    }
}
