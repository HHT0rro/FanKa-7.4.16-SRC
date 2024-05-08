package com.danlan.android.cognition.collector.util;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class StringUtil {
    public static boolean isNumeric(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isDigit(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }
}
