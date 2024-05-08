package com.kwad.sdk.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {
    public static void ap(String str, String str2) {
        com.kwad.sdk.core.e.c.d("callbackLog", str + str2);
    }

    public static void e(String str, String str2, String str3, String str4) {
        ap(str, str2 + "_" + str3 + "_" + str4);
    }

    public static void s(String str, int i10) {
        com.kwad.sdk.core.e.c.d("audioVideoLog", str + "_type_" + i10 + "_time_" + System.currentTimeMillis());
    }
}
