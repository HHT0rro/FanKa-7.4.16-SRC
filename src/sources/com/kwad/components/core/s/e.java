package com.kwad.components.core.s;

import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    public static String a(long j10, boolean z10) {
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j10 <= 1) {
            return j10 + "B";
        }
        double d10 = j10;
        int log = (int) (Math.log(d10) / Math.log(1024.0d));
        return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(j10 > 1024 ? d10 / Math.pow(1024.0d, log) : d10 / 1024.0d), strArr[log]);
    }
}
