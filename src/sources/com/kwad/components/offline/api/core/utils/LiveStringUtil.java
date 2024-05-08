package com.kwad.components.offline.api.core.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LiveStringUtil {
    @NonNull
    public static String emptyIfNull(String str) {
        return str != null ? str : "";
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }
}
