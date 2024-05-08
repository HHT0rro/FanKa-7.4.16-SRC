package com.huawei.hms.feature.dynamic.f;

import android.util.Base64;
import com.huawei.hms.common.util.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29899a = "Base64";

    public static String a(byte[] bArr) {
        String encodeToString;
        if (bArr == null) {
            return "";
        }
        try {
            encodeToString = Base64.encodeToString(bArr, 2);
        } catch (AssertionError e2) {
            Logger.e(f29899a, "An exception occurred while encoding with Base64,AssertionError:", e2);
        }
        return encodeToString != null ? encodeToString : "";
    }

    public static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            byte[] decode = Base64.decode(str, 2);
            if (decode != null) {
                return decode;
            }
        } catch (IllegalArgumentException e2) {
            Logger.e(f29899a, "Decoding with Base64 IllegalArgumentException:", e2);
        }
        return new byte[0];
    }
}
