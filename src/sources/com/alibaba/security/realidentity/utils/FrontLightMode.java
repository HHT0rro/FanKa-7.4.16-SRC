package com.alibaba.security.realidentity.utils;

import android.content.SharedPreferences;
import com.alibaba.security.realidentity.build.hk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum FrontLightMode {
    ON,
    AUTO,
    OFF;

    private static FrontLightMode parse(String str) {
        return str == null ? OFF : valueOf(str);
    }

    public static FrontLightMode readPref(SharedPreferences sharedPreferences) {
        return parse(sharedPreferences.getString(hk.f3842b, OFF.toString()));
    }
}
