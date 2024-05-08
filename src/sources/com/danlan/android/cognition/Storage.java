package com.danlan.android.cognition;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Storage {
    public static String getIdFromSharePref(@NonNull Context context, String str, @NonNull String str2) {
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static void setIdToSharePref(@NonNull Context context, String str, @NonNull String str2, String str3) {
        context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }
}
