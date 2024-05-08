package com.huawei.secure.android.common.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafeString {
    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (str != null && charSequence != null && charSequence2 != null) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("replace: ");
                sb2.append(e2.getMessage());
            }
        }
        return str;
    }

    public static String substring(String str, int i10) {
        if (str != null && str.length() >= i10 && i10 >= 0) {
            try {
                return str.substring(i10);
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("substring exception: ");
                sb2.append(e2.getMessage());
            }
        }
        return "";
    }

    public static String substring(String str, int i10, int i11) {
        if (str != null && i10 >= 0 && i11 <= str.length() && i11 >= i10) {
            try {
                return str.substring(i10, i11);
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("substring: ");
                sb2.append(e2.getMessage());
            }
        }
        return "";
    }
}
