package com.ishumei.smantifraud.l111l11111lIl;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l1111l111111Il {
    private static int l1111l111111Il;

    public static int l1111l111111Il(Context context) {
        if (context == null) {
            return 0;
        }
        int i10 = l1111l111111Il;
        if (i10 != 0) {
            return i10;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("auc", 0);
            int i11 = sharedPreferences.getInt("auc", 0) + 1;
            sharedPreferences.edit().putInt("auc", i11).apply();
            l1111l111111Il = i11;
            return i11;
        } catch (Exception unused) {
            return 0;
        }
    }
}
