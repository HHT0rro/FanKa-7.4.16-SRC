package com.huawei.flexiblelayout.parser.cardmanager;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* compiled from: ComboNames.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "@" + str2;
    }

    public static String[] a(@NonNull String str) {
        int indexOf = str.indexOf("@");
        return (indexOf == -1 || indexOf >= str.indexOf("://")) ? new String[]{str, ""} : new String[]{str.substring(0, indexOf), str.substring(indexOf + 1)};
    }
}
