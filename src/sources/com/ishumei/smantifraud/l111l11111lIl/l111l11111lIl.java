package com.ishumei.smantifraud.l111l11111lIl;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111lIl {
    private static final String l1111l111111Il = "cloudms.conf";
    private static final String l111l11111lIl = "conf";

    public static String l1111l111111Il(Context context) {
        return context.getSharedPreferences(l1111l111111Il, 0).getString(l111l11111lIl, null);
    }

    public static void l1111l111111Il(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(l1111l111111Il, 0).edit();
        edit.putString(l111l11111lIl, str);
        edit.apply();
    }
}
