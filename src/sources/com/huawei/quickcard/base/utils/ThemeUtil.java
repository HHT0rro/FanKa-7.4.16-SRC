package com.huawei.quickcard.base.utils;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ThemeUtil {
    public static int getId(@NonNull Context context, @NonNull String str) {
        return context.getResources().getIdentifier(str, "style", context.getPackageName());
    }
}
