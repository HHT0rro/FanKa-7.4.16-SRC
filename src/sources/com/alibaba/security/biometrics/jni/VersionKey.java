package com.alibaba.security.biometrics.jni;

import com.alibaba.security.biometrics.jni.build.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class VersionKey {
    public static final String FL_SDK_VERSION = "3.3.0";
    public static final String RP_SDK_VERSION = formatVersion(a.f2430g);

    public static String formatVersion(String str) {
        int indexOf;
        if (str != null && (indexOf = str.indexOf("-")) != -1) {
            String substring = str.substring(0, indexOf);
            if (!substring.isEmpty()) {
                return substring;
            }
        }
        return str;
    }
}
