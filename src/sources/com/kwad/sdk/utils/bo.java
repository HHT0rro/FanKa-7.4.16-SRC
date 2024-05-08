package com.kwad.sdk.utils;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bo {
    public static boolean az(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            for (int i10 = 0; i10 < split.length && i10 < split2.length; i10++) {
                try {
                    int parseInt = Integer.parseInt(split[i10]) - Integer.parseInt(split2[i10]);
                    if (parseInt > 0) {
                        return true;
                    }
                    if (parseInt < 0) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
            if (split.length >= split2.length) {
                return true;
            }
        }
        return false;
    }
}
