package com.danlan.android.cognition.common;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FileStoreUtil {
    public static String getDataFromSharePref(@NonNull Context context, String str, @NonNull String str2) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void setDataToSharePref(@NonNull Context context, String str, @NonNull String str2, String str3) {
        try {
            context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
