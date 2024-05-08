package com.huawei.hms.framework.common;

import android.util.Base64;
import com.huawei.secure.android.common.util.SafeBase64;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SecurityBase64Utils {
    private static final String SAFE_BASE64_PATH = "com.huawei.secure.android.common.util.SafeBase64";
    private static volatile boolean isAegisBase64LibraryLoaded;

    private static boolean checkCompatible(String str) {
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass(str);
            synchronized (SecurityBase64Utils.class) {
                isAegisBase64LibraryLoaded = true;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static byte[] decode(String str, int i10) {
        if (!isAegisBase64LibraryLoaded && !checkCompatible(SAFE_BASE64_PATH)) {
            try {
                return Base64.decode(str, i10);
            } catch (Exception unused) {
                return new byte[0];
            }
        }
        return SafeBase64.decode(str, i10);
    }

    public static String encodeToString(byte[] bArr, int i10) {
        if (!isAegisBase64LibraryLoaded && !checkCompatible(SAFE_BASE64_PATH)) {
            try {
                return Base64.encodeToString(bArr, i10);
            } catch (Exception unused) {
                return null;
            }
        }
        return SafeBase64.encodeToString(bArr, i10);
    }
}
