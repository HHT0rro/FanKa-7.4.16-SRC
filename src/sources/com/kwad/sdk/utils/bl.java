package com.kwad.sdk.utils;

import java.util.Formatter;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bl {
    public static String ab(long j10) {
        if (j10 <= 0 || j10 >= 86400000) {
            return "00:00";
        }
        try {
            long j11 = j10 / 1000;
            long j12 = j11 % 60;
            long j13 = (j11 / 60) % 60;
            long j14 = j11 / 3600;
            Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
            return j14 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j14), Long.valueOf(j13), Long.valueOf(j12)).toString() : formatter.format("%02d:%02d", Long.valueOf(j13), Long.valueOf(j12)).toString();
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return "";
        }
    }
}
