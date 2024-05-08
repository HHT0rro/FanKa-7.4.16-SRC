package com.huawei.appgallery.agd.serverreq.utils.os;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class SHA256 {
    @NonNull
    public static byte[] digest(@Nullable String str) {
        return str == null ? new byte[0] : digest(str.getBytes(Charset.defaultCharset()));
    }

    public static byte[] digest(byte[] bArr) {
        if (bArr == null) {
            return new byte[0];
        }
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(bArr);
            if (digest != null) {
                return digest;
            }
        } catch (NoSuchAlgorithmException unused) {
        }
        return new byte[0];
    }
}
