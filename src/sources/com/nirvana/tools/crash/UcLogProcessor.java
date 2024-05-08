package com.nirvana.tools.crash;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class UcLogProcessor {
    public static final String getJavaStackTracingFromLog(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("Back traces starts.");
        int indexOf2 = str.indexOf("Back traces ends.");
        return (indexOf < 0 || indexOf2 < 0) ? str : str.substring(indexOf, indexOf2);
    }

    public static final String getNativeStackTracingFromLog(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf("Process Name:");
        int indexOf2 = str.indexOf("--- --- --- ---", indexOf);
        return indexOf >= 0 ? indexOf2 >= 0 ? str.substring(indexOf, indexOf2) : str.substring(indexOf) : "";
    }
}
