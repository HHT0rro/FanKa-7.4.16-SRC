package com.jd.ad.sdk.jad_do;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_jw {
    public static boolean jad_an(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int length = str.length();
            if (length % 4 != 0) {
                return false;
            }
            char[] charArray = str.toCharArray();
            int i10 = 0;
            while (true) {
                boolean z10 = true;
                if (i10 >= length) {
                    return true;
                }
                if (i10 == length - 3 && charArray[i10] == '=') {
                    return false;
                }
                char c4 = charArray[i10];
                if ((c4 < 'A' || c4 > 'Z') && ((c4 < 'a' || c4 > 'z') && ((c4 < '0' || c4 > '9') && c4 != '_' && c4 != '-' && c4 != '='))) {
                    z10 = false;
                }
                if (!z10) {
                    return false;
                }
                i10++;
            }
        } catch (Exception unused) {
            return false;
        }
    }
}
