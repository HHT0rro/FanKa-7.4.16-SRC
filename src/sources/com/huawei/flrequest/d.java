package com.huawei.flrequest;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: LocaleUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f28718a = "en";

    /* renamed from: b, reason: collision with root package name */
    public static final String f28719b = "";

    /* renamed from: c, reason: collision with root package name */
    public static final String f28720c = "US";

    private d() {
    }

    public static String a() {
        String str;
        String str2;
        String str3;
        Locale locale = Locale.getDefault();
        if (locale != null) {
            str3 = locale.getLanguage();
            str2 = locale.getScript();
            str = locale.getCountry();
        } else {
            str = "US";
            str2 = "";
            str3 = "en";
        }
        return a(TextUtils.isEmpty(str3) ? "en" : str3, TextUtils.isEmpty(str2) ? "" : str2, TextUtils.isEmpty(str) ? "US" : str);
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return str;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str + "-" + str2 + "-" + str3;
        }
        return str + "-" + str3;
    }
}
