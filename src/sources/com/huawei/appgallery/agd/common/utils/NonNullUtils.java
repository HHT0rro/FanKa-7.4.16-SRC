package com.huawei.appgallery.agd.common.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class NonNullUtils {
    @NonNull
    public static String toNonNull(@Nullable String str) {
        return str == null ? "" : str;
    }

    @NonNull
    public static String[] toNonNull(@Nullable String[] strArr) {
        return strArr == null ? new String[0] : strArr;
    }
}
