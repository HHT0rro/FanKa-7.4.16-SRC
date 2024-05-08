package com.tencent.turingface.sdk.mfa;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class qbihQ {
    public static String a(Context context) {
        return System.getProperty("http.proxyHost");
    }

    public static int b(Context context) {
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
