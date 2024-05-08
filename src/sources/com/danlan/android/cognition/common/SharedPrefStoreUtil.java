package com.danlan.android.cognition.common;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SharedPrefStoreUtil {
    public static String getDataFromSharePref(@NonNull Context context, String str, @NonNull String str2, @NonNull String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void setDataToSharePref(@NonNull Context context, String str, @NonNull String str2, String str3) {
        context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }
}
