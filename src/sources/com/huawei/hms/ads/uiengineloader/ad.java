package com.huawei.hms.ads.uiengineloader;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ad {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29426a = "Sha256Util";

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            aa.d(f29426a, "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
